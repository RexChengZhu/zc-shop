package com.zc.eshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.eshop.product.dao.CommentReplayDao;
import com.zc.eshop.product.entity.CommentReplayEntity;
import com.zc.eshop.product.service.CommentReplayService;
import org.springframework.stereotype.Service;


@Service("commentReplayService")
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayDao, CommentReplayEntity> implements CommentReplayService {


}