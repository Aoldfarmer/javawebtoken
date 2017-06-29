package com.koou.product.wechat.utils;

import java.io.Reader;
import java.io.Writer;
import com.koou.common.utils.StringUtil;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.io.xml.XppReader;

/**
 * 处理java转XML字段添加 <![CDATA[]]>
 * @author jianjian.li
 * @date 2013-8-30
 */
public class MyXppDriver extends XppDriver {

    @Override
    public HierarchicalStreamReader createReader(Reader reader) {
        return  new XppReader(reader){
            public String getNodeName(){
                return StringUtil.lowerFirstChar(super.getNodeName());
            }
        };
    }

    @Override
	public HierarchicalStreamWriter createWriter(Writer out) {
		return new PrettyPrintWriter(out){
            boolean cdata = true;  
            @SuppressWarnings("rawtypes")
			public void startNode(String name, Class clazz) {
                super.startNode(StringUtil.upperFirstChar(name), clazz);
            }   
            protected void writeText(QuickWriter writer, String text) {
                if (cdata) {
                    writer.write("<![CDATA[");  
                    writer.write(text);  
                    writer.write("]]>");  
                } else {  
                    writer.write(text);  
                }  
            }		
		};
	}
}
