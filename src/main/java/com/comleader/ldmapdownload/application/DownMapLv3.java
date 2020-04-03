package com.comleader.ldmapdownload.application;

import com.comleader.ldmapdownload.util.CLStringUtil;
import com.comleader.ldmapdownload.util.HttpUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.concurrent.Future;

/**
 * @ClassName DownMapLv1
 * @Description: 下载第一层(全地图)
 * @Author zhanghang
 * @Date 2020/4/3
 * @Version V1.0
 **/
public class DownMapLv3 {

    private static int z = 3;

    /**
     * @description: 下载第三级的Map
     * @param
     * @return: void
     * @author: zhanghang
     * @date: 2020/4/3
     **/
    public static void downLoad() {
        new Thread(() -> {
            for (int y = 0; y <= 7; y++) { // Y轴
                for (int x = 0; x <= 7; x++) { // X轴
                    //高德地图(6：影像，7：矢量，8：影像路网)
                    String imgUrl = CLStringUtil.getImgUrl(z, x, y);
                    File file = CLStringUtil.getFullFile(z, x, y);
                    System.out.println(imgUrl);
                    // 开始下载地图
                    try {
                        HttpUtil.downImageByGet(imgUrl, file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}