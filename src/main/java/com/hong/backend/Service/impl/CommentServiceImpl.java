package com.hong.backend.Service.impl;

import com.hong.backend.Model.pojo.Comment;
import com.hong.backend.Mapper.CommentMapper;
import com.hong.backend.Service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HQ
 * @since 2024-05-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
