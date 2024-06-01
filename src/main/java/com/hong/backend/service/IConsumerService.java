package com.hong.backend.service;

import com.hong.backend.Tools.Result;
import com.hong.backend.model.pojo.Consumer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.backend.model.request.AdminRequest;
import com.hong.backend.model.request.ConsumerRequest;
import jakarta.servlet.http.HttpSession;

/**
 * 用户
 * @author HQ
 * @since 2024-05-23
 */
public interface IConsumerService extends IService<Consumer> {

    Result addUser(ConsumerRequest registerConsumerRequest);


    Result isLogin(ConsumerRequest consumerRequest, HttpSession session);
}
