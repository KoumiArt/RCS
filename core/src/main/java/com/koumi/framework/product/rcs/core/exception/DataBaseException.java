package com.koumi.framework.product.rcs.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(DataBaseException.class);
	
	public DataBaseException(){
		super();
		logger.error("");
	}
	
	public DataBaseException(Exception e){
		super(e);
	}
	
	public DataBaseException(String message){
		super(message);
	}

	public DataBaseException(String msg, Exception e) {
		super(msg+e.getMessage());
	}
}
