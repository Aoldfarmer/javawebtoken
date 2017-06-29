package com.koou.product.wechat.service.impl;

import java.io.IOException;

import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.koou.common.httpclient.HttpProtocolHandler;
import com.koou.common.httpclient.HttpRequest;
import com.koou.common.httpclient.HttpResponse;
import com.koou.common.httpclient.HttpResultType;
import com.koou.product.wechat.handle.MessageFactoryUtil;
import com.koou.product.wechat.handle.MessageHandle;
import com.koou.product.wechat.handle.MessageHandleFactory;
import com.koou.product.wechat.service.WxService;


/**
 * Description: 微信公众号实现
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-28 1:48 PM
 */
@Service
public class WxServiceImpl implements WxService {

    private static final Logger log = LoggerFactory.getLogger(WxServiceImpl.class);


    /**
     * 根据code换取openid
     * @param code code
     * @return openid
     * @throws IOException IOException
     */
    @Override
    public String getOpenId(String code) throws IOException {
        String appId = "wx8b0713c712fe6a69";
        String secret = "ba339856fe8cc2366d0a12ea8cb7dcc1";
        //换取access_token 其中包含了openid
        String url = "https://api.wechat.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code".replace("APPID", appId).replace("SECRET", secret).replace("CODE", code);
        //URLConnectionHelper是一个模拟发送http请求的类
        HttpRequest requestOpenId = new HttpRequest(HttpResultType.STRING);
        requestOpenId.setMethod("get");
        requestOpenId.setUrl(url);
        HttpResponse openIdResponse = HttpProtocolHandler.getInstance()
                .execute(requestOpenId, "", "");
        String result = openIdResponse.getStringResult();
        JSONObject json = JSON.parseObject(result);
        return json.get("openid").toString();
    }


    /**
     * 操作不同的类型.
     * @param document document
     * @return String
     */
    @Override
    public String handleMessage(Document document) {
        String xml = document.asXML();
        log.info("请求的XML为:" + xml);
        String msgType = document.selectSingleNode("xml/MsgType").getText();
        log.info("获取的msgType为: " + msgType);
        MessageHandleFactory messageHandleFactory = MessageFactoryUtil.getHandleFactory(msgType);
        if (messageHandleFactory != null) {
            MessageHandle messageHandle = messageHandleFactory.getMessageHandle();
            return messageHandle.handle(xml);
        }
        return "";
    }

}
