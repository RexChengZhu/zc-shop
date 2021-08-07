package com.zc.eshop.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author zhucheng
 * @email sunlightcs@gmail.com
 * @date 2021-08-01 16:38:08
 */
@Data
@TableName("t_admin_user")
public class TAdminUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 管理员主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码md5加密
	 */
	private String password;
	/**
	 * 上次登录时间
	 */
	private Date lastlogintime;

}
