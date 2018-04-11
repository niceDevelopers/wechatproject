package com.fiany.wechat.VO;

import lombok.Data;

/**
 * @Description : http请求返回的最外层对象
 * @Author : yifan
 * @Data : 2018/3/25 20:38
 */
@Data
public class ResultVO<T> {
    /** 错误码*/
    private Integer code;
    /** 提示信息*/
    private String msg;
    /** 具体内容*/
    private T data;
}
