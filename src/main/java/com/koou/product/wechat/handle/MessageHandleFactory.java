package com.koou.product.wechat.handle;

/**
 * Description: 消息处理的工厂
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-28 2:08 PM
 */
public interface MessageHandleFactory {

    MessageHandle getMessageHandle();
}
