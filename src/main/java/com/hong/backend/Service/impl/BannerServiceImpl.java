package com.hong.backend.Service.impl;

import com.hong.backend.Model.pojo.Banner;
import com.hong.backend.Mapper.BannerMapper;
import com.hong.backend.Service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HQ
 * @since 2024-05-23
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

//  TODO 这里可以用缓存
    @Override
    public List<Banner> getAll() {
        // 不带任何条件查询 检索所有消息
        return bannerMapper.selectList(null);
    }
}
