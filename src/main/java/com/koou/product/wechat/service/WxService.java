package com.koou.product.wechat.service;

import java.io.IOException;

import org.dom4j.Document;

/**
 * Description: 微信公众号处理Service
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-28 1:47 PM
 */
public interface WxService {

    /**
     * 根据code换取openid
     * @param code code
     * @return openid
     * @throws IOException IOException
     */
    String getOpenId(String code) throws IOException;


    /**
     * 操作不同的类型.
     * @param document document
     * @return String
     */
    String handleMessage(Document document);
}
