package com.koou.product.wechat.dto.response;

import lombok.Data;

import java.io.Serializable;


@Data
public class WxResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	// 接收方帐号（收到的OpenID）
    private String toUserName;
    // 开发者微信号
    private String fromUserName;
    // 消息创建时间 （整型）
    private long createTime;
    // 消息类型（text/music/news）
    private String msgType;
}
