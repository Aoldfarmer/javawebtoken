package com.koou.product.wechat.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class EventWxRequest extends WxRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	//事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件)、
	//LOCATION（上报地理位置）、SCAN(关注用户扫带参数的二维码)、VIEW（点击跳转链接事件）
	//、TEMPLATESENDJOBFINISH（模板消息结果）
	private String event;
	//事件KEY值，与自定义菜单接口中KEY值对应
	private String eventKey;
	//二维码标签 sunscribe 和SCAN时间专属
	private String ticket;
	//LOCATION时间专属，地理位置纬度
	private String latitude;
	//LOCATION时间专属，地理位置经度
	private String longitude;
	//LOCATION时间专属，地理位置精度
	private String precision;
	//模板事件返回消息ID
	private int msgID;
	//模板事件发送状态
	private String status;

}
