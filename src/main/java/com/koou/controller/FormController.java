package com.koou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author koou
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/form")
public class FormController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public void formSubmit(String name , String fave, String city, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gb2312");//通知服务器发送数据时查阅的码表
        response.setContentType("text/html;charset=gb2312");//通知浏览器以何种码表打开
        PrintWriter printWriter = response.getWriter();
        String form = "<!DOCTYPE html>" +
                        "<html>" +
                            "<head>" +
                                "<title>Post Data</title>" +
                            "</head>" +
                            "<body>" +
                                "<style>" +
                                    "th, td {" +
                                        "text-align: left;" +
                                        "padding: 5px;" +
                                        "color: black;" +
                                    "}" +
                                    "th {" +
                                        "background-color: grey;" +
                                        "color: white;" +
                                        "min-width: 10em;" +
                                    "}" +
                                    "td {" +
                                        "background-color: lightgrey;" +
                                    "}" +
                                    "caption {" +
                                        "font-weight: bold;" +
                                    "}" +
                                "</style>" +
                                "<table border=\"1\">" +
                                    "<caption>Form Data</caption>" +
                                    "<tr>" +
                                        "<th>Name</th>" +
                                        "<th>Value</th>" +
                                    "</tr>" +
                                    "<tr>" +
                                        "<td>fave</td>" +
                                        "<td>" + fave + "</td>" +
                                    "</tr>" +
                                    "<tr>" +
                                        "<td>name</td>" +
                                        "<td>" + name + "</td>" +
                                    "</tr>" +
                                    "<tr>" +
                                        "<td>city</td>" +
                                        "<td>" + city + "</td>" +
                                    "</tr>" +
                                "</table>" +
                            "</body>" +
                            "</html>";
        printWriter.write(form);
    }
}
