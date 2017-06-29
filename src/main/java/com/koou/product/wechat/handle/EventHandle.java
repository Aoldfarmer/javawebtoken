package com.koou.product.wechat.handle;

import com.koou.product.wechat.constant.MsgConstant;
import com.koou.product.wechat.dto.request.EventWxRequest;
import com.koou.product.wechat.dto.response.TextWxResponse;
import com.koou.product.wechat.utils.WxMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Description: 微信公众号事件类型
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-28 2:28 PM
 */
public class EventHandle implements MessageHandle {
    private static final Logger log = LoggerFactory.getLogger(EventHandle.class);


    private EventHandle() {
    }

    @Override
    public String handle(String requestXml) {
        EventWxRequest eventWxRequest = WxMessageUtil.msgXml2EventObject(requestXml);
        String event = eventWxRequest.getEvent();
        TextWxResponse text = new TextWxResponse();
        log.info("Event事件处理中" + event);
        if (MsgConstant.EVENT_TYPE_SUBSCRIBE.equals(event)) {
            log.info("Event订阅事件处理中" + event);

            text.setContent("欢迎关注拍房宝微信公众号" );
            text.setToUserName(eventWxRequest.getFromUserName());
            text.setFromUserName(eventWxRequest.getToUserName());
            text.setCreateTime(System.currentTimeMillis());
            text.setMsgType(MsgConstant.REQ_MESSAGE_TYPE_TEXT);
        }

        return WxMessageUtil.textMessageToXml(text);
    }

    public static MessageHandleFactory factory =  new MessageHandleFactory() {
            @Override
            public MessageHandle getMessageHandle() {
                return new EventHandle();
            }
        };

}
