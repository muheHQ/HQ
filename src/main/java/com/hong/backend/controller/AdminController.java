    package com.hong.backend.controller;


    import com.hong.backend.Tools.Result;
    import com.hong.backend.model.pojo.Register;
    import com.hong.backend.model.request.AdminRequest;
    import com.hong.backend.service.IAdminService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    /**
     * <p>
     *  前端控制器
     * </p>
     *
     * @author HQ
     * @since 2024-05-23
     */

    /**
     * 登录
     */
    @RestController
    @RequestMapping("/admin")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Tag(name = "用户登录", description = "测试模块")
    public class AdminController {

        @Autowired
        private IAdminService adminService;

        /**
         * 登录
         * @param adminRequest
         * @param session
         * @return
         */
        @PostMapping("/login/status")
        @Operation(summary = "登录接口", description = "管理员登录接口")
        public Result login(@RequestBody AdminRequest adminRequest, HttpSession session){
            return adminService.isLogin(adminRequest,session);
        }

        @PostMapping("/register")
        public Result register(@RequestBody Register register){
            return adminService.register(register);
        }
    }
