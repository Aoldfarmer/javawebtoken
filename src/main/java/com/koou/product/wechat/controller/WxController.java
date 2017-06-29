package com.koou.product.wechat.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koou.common.controller.AbstractController;
import com.koou.product.wechat.service.WxService;
import com.koou.product.wechat.utils.SignatureUtil;


/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-22 2:44 PM
 */
@Controller
@RequestMapping(value = "/weChat")
public class WxController extends AbstractController {

    @Autowired
    private WxService wxService;


    @RequestMapping(value="/connect",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void connectWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8"); //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        String method = request.getMethod();
        boolean isGet = method.equalsIgnoreCase("get");
        PrintWriter out = response.getWriter();
        try {
            if (isGet) {
                String signature = request.getParameter("signature");// 微信加密签名
                String timestamp = request.getParameter("timestamp");// 时间戳
                String nonce = request.getParameter("nonce");// 随机数
                String echostr = request.getParameter("echostr");//随机字符串
                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
                if (SignatureUtil.checkSignature(signature, timestamp, nonce)) {
                    out.print(echostr);
                }
                out.close();
            } else {
                try {
                    InputStream inputStream = request.getInputStream();
                    SAXReader reader = new SAXReader();
                    Document document = reader.read(inputStream);
                    String respMessage = wxService.handleMessage(document);
                    out.write(respMessage);
                    log.info("The request completed successfully");
                    log.info("to weChat server "+ respMessage);
                } catch (Exception e) {
                    log.error("Failed to convert the message from weChat!");
                }
            }
        } catch (Exception e) {
            log.error("Connect the wechat server is error.");
        } finally {
            out.close();
        }
    }

}
