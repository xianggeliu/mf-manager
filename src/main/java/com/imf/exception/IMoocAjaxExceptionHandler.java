package com.imf.exception;

import javax.servlet.http.HttpServletRequest;

import com.imf.pojo.MFJSONResult;

//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public MFJSONResult defaultErrorHandler(HttpServletRequest req,
                                            Exception e) throws Exception {

		e.printStackTrace();
		return MFJSONResult.errorException(e.getMessage());
	}
}
