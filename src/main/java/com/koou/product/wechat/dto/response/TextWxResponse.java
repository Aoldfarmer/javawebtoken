package com.koou.product.wechat.dto.response;


import lombok.Data;

@Data
public class TextWxResponse extends WxResponse {
	private static final long serialVersionUID = 1L;
	// 回复的消息内容
    private String content;


}
