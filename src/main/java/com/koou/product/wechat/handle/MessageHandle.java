package com.koou.product.wechat.handle;

/**
 * Description: 微信各种消息类型的处理
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-28 2:06 PM
 */
public interface MessageHandle {

    String handle(String requestXml);
}
