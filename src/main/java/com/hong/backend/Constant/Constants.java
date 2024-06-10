package com.hong.backend.Constant;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 存放 歌曲图片 文件 歌手图片 歌单图片文件路径
 * @author hong
 */

public class Constants {


    public static String CURRENT_PARENT_PATH = getCurrentPath();

    public static String SONGLIST_PICTURE_PATH = "file:" + CURRENT_PARENT_PATH + "/img/songListPicture/";
    public static String SONG_PICTURE_PATH = "file:" + CURRENT_PARENT_PATH + "/img/songPicture/";
    public static String AVATOR_IMAGES_PATH = "file:" + CURRENT_PARENT_PATH + "/img/avatorImages/";
    public static String SONG_PATH = "file:" + CURRENT_PARENT_PATH + "/song/";
    public static String SINGER_PICTURE_PATH = "file:" + CURRENT_PARENT_PATH + "/img/singerPicture/";
    public static String BANNER_PICTURE_PATH = "file:" + CURRENT_PARENT_PATH + "/img/bannerPicture/";

    public static String MUHE = "hong";


    /**
     * 获取上一级路径
     * @return
     */
    public static String getCurrentPath() {
        String currentPath = System.getProperty("user.dir");
        Path path = Paths.get(currentPath);
        Path parentPath = path.getParent();
        return parentPath.toString();
    }
}
