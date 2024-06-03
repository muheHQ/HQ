package com.hong.backend.Service;

import com.hong.backend.Tools.Result;
import com.hong.backend.Model.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.backend.Model.pojo.Register;
import com.hong.backend.Model.request.AdminRequest;
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
