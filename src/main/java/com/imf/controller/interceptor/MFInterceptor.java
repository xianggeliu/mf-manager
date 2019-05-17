package com.imf.controller.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imf.utils.CommonVariable;
import com.imf.utils.CookieUtil;
import com.imf.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.imf.pojo.MFJSONResult;
import com.imf.utils.JsonUtils;

@Component
public class MFInterceptor implements HandlerInterceptor  {
	@Autowired
	private CommonVariable cv;

	@Autowired
	private RedisOperator redis;

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		HttpSession session=request.getSession();
//		String token = "MFTOKEN";
		String token = cv.getCookieToken();
		String cookie = CookieUtil.findCookie(request, token);
		if (StringUtils.isNotEmpty(cookie)){
			CookieUtil.addCookie(token,cookie,response);
			redis.expire(cookie,1800);
			return  true;
		}
		session.setAttribute("preurl",request.getRequestURI());
		StringBuffer url = request.getRequestURL();
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/login/index").toString() ;
		response.sendRedirect(tempContextUrl);
		return false;
	}
	
	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object object, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("dayn");
		
	}
	
	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
	 * （主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object object, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void returnErrorResponse(HttpServletResponse response, MFJSONResult result)
			throws IOException, UnsupportedEncodingException {
		OutputStream out=null;
		try{
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/json");
		    out = response.getOutputStream();
		    out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
		    out.flush();
		} finally{
		    if(out!=null){
		        out.close();
		    }
		}
	}
}
