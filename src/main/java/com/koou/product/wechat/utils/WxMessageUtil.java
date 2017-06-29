package com.koou.product.wechat.utils;


import com.koou.product.wechat.dto.response.TextWxResponse;
import com.koou.product.wechat.dto.request.EventWxRequest;
import com.thoughtworks.xstream.XStream;


public class WxMessageUtil {


	/**
	 * xml转化成EventWeixinRequest对象
	 * @param xml xml
	 * @return
	 */
	public static EventWxRequest msgXml2EventObject(String xml){
		XStream stream = new XStream(new MyXppDriver());
		stream.alias("xml", EventWxRequest.class);
		return (EventWxRequest) stream.fromXML(xml);
	}


	/**
	   * 文本消息对象转换成xml 
	   * 
	   * @param textMessage 文本消息对象 
	   * @return xml 
	   */ 
	 public static String textMessageToXml(TextWxResponse textMessage){
	 	XStream xstream = new XStream(new MyXppDriver());
	    xstream.alias("xml", textMessage.getClass());
	    return xstream.toXML(textMessage);
	 }

}
