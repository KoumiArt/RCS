package com.koumi.framework.product.rcs.util;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koumi.framework.product.rcs.util.exception.XmlException;

public class SystemConfigBean {
	
	private static Logger logger = LoggerFactory.getLogger(SystemConfigBean.class);
	
	private final static String systemConfigFile = "SystemConfig.xml";
	
	private static Document doc;
	
	static {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read(Resources.getResourceAsStream(systemConfigFile));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取SystemConfig.xml中的节点的Text，多个相同节点去第一个;
	 * @param name
	 * @return
	 */
	public static String getProperty(String name) {
		Node node = null;
		try {
			node = getRootElement().selectSingleNode("//"+convertXpath(name)+"[1]");
			return node.getText();
		} catch (XmlException e) {
			logger.error("获取属性异常！",e);
			e.printStackTrace();
		} finally {
			if(node == null){
				logger.error("获取属性异常,不存在的节点!");
			}
		}
		return "";
	}
	
	private static String convertXpath(String name) throws XmlException {
		String result = null;
		try {
			result = name.replace(".", "/");
		} catch (Exception e) {
			logger.error("属性名["+name+"]有误，请检查！",e);
			throw new XmlException("属性名["+name+"]有误，请检查！"); 
		}
		return result;
	}

	private static Element getRootElement() {
		return doc.getRootElement();
	}
	
}
