package com.koou.product.wechat.handle;

import com.koou.product.wechat.constant.MsgConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Description: 获取工厂
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-28 5:44 PM
 */
public class MessageFactoryUtil {

    private static final Logger log = LoggerFactory.getLogger(MessageFactoryUtil.class);

    /**
     * 根据不同的msgType获取工厂信息
     * @param msgType msgType
     * @return Handle工厂
     */
    public static MessageHandleFactory getHandleFactory(String msgType) {
        switch (msgType) {
            case MsgConstant.REQ_MESSAGE_TYPE_EVENT:
                log.info("获取的工厂为: EventFactory");
                return EventHandle.factory;
            default:
                return null;
        }
    }
}
