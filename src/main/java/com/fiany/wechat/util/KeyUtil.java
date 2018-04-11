package com.fiany.wechat.util;

import java.util.Random;

/**
 * @Description : 生成键
 * @Author : yifan
 * @Data : 2018/4/10 20:50
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
