package com.hong.backend.Service;

import com.hong.backend.Model.pojo.Banner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HQ
 * @since 2024-05-23
 */
public interface IBannerService extends IService<Banner> {

    List<Banner> getAll();
}
