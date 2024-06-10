package com.hong.backend.Config;

import com.hong.backend.Constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author HQ
 * @Date: 2024/6/10
 */
@Configuration
@Slf4j
public class webPictureConfig implements WebMvcConfigurer {
    // 拦截器 遇到对应的资源会修改成对应的地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.error(Constants.BANNER_PICTURE_PATH);
//        registry.addResourceHandler("/img/swiper/**")
                 registry.addResourceHandler("/img/bannerPicture/**")
//                .addResourceLocations("hong");
                .addResourceLocations(Constants.BANNER_PICTURE_PATH);
    }
}
