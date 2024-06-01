package com.hong.backend.service.impl;

import com.hong.backend.model.pojo.Song;
import com.hong.backend.Mapper.SongMapper;
import com.hong.backend.service.ISongService;
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
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {

}
