package com.koou.product.wechat.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class WxRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	// 开发者微信号
    private String toUserName;
    // 发送方帐号（一个OpenID）
    private String fromUserName;
    // 消息创建时间 （整型）
    private long createTime;
    // 消息类型（text/image/location/link/event）
    private String msgType;
    // 消息id，64位整型
    private long msgId;
}
