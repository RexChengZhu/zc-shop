package com.zc.eshop.common.tree;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 树状结构生成器
 */
public class TreeMaker<T extends TreeChild<T>> {
    Integer defaultPidValue = 0;
    Field pidField;
    Field idField;
    List<T> pidList = new ArrayList<>();
    /**
     * 自定义pid的默认值
     *
     * @param pid
     * @return
     */
    public TreeMaker<T> pid(Integer pid) {
        defaultPidValue = pid;
        return this;
    }
    public List<T> build(List<T> list) {
        try {
            // 遍历list，找到pid = defaultvalue 的数据，找到第一层pid
            makeField(list);
            List<T> childList = list.stream().filter(item -> {
                try {
                    Integer pid = (Integer) pidField.get(item);
                    if (pid.equals(defaultPidValue)) {
                        pidList.add(item);
                        return false;
                    }
                } catch (IllegalAccessException ignore) {

                }
                return true;
            }).collect(Collectors.toList());

            for (T item : childList) {
                Integer pid = (Integer) pidField.get(item);
                T parent = findParent(pid, pidList);
                if (parent == null) {
                    // 如果谁都没找到，则表示自己是第一层
                    pidList.add(item);
                } else {

                    parent.getChild().add(item);
                }
            }

        } catch (Exception ignore) {

        }
        return pidList;

    }

    private T findParent(Integer pid, List<T> pidList) throws Exception {
        for (T pItem : pidList) {
            Integer id = (Integer) idField.get(pItem);
            if (id.equals(pid)) {
                return pItem;
            } else {
                for (T t : pItem.getChild()) {
                    Integer innerId = (Integer)idField.get(t);
                    if (innerId.equals(pid)){
                        return t;
                    }else{
                        T parent = findParent(pid, t.getChild());
                        if (parent != null) {
                            return parent;
                        }
                    }
                }
            }
        }
        return null;
    }


    private void makeField(List<T> list) {
        T t = list.get(0);
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            TreeId annotationId = field.getAnnotation(TreeId.class);
            if (annotationId != null) {
                idField = field;
                continue;
            }

            TreePid annotationPid = field.getAnnotation(TreePid.class);
            if (annotationPid != null) {
                pidField = field;
            }
        }
    }
}
