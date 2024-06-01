package com.hong.backend.service;

import com.hong.backend.Tools.Result;
import com.hong.backend.model.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.backend.model.pojo.Register;
import com.hong.backend.model.request.AdminRequest;
import jakarta.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HQ
 * @since 2024-05-23
 */
public interface IAdminService extends IService<Admin> {

    Result isLogin(AdminRequest adminRequest, HttpSession session);

    Result register(Register register);
}
