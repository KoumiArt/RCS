package com.koumi.framework.product.rcs.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(XmlException.class);
	
	public XmlException(){
		super();
		logger.error("");
	}
	
	public XmlException(Exception e){
		super(e);
	}
	
	public XmlException(String message){
		super(message);
	}
}
