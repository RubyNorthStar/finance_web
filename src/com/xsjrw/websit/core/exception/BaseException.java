package com.xsjrw.websit.core.exception;

/**
 * 异常处理
 * @author hejianming
 * @date 2012-12-13
 */
@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	
	public BaseException() {
		super();
	}
	
	public BaseException(String message) {
		super(message);
	}
	
}
