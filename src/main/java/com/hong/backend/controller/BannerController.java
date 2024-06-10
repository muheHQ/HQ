package com.hong.backend.controller;


import com.hong.backend.Service.IBannerService;
import com.hong.backend.Tools.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HQ
 * @since 2024-05-23
 */
@RestController
@RequestMapping("/banner")
@Tag(name = "页面图片模块")
public class BannerController {
    @Autowired
    private IBannerService bannerService;
    @GetMapping("/getAllBanner")
    @Operation(summary = "获取海报轮播图")
    public Result getAllBanner(){
        return Result.success(bannerService.getAll());
//        return Result.success("获取轮播图"+bannerService.getAll());
    }

}
