package com.guoyicap.micro.config.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;

public class HeaderUtils {
	
	public static HttpHeaders getHeadersInfo(HttpServletRequest request) {
    	HttpHeaders headers = new HttpHeaders();  
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
          String key = (String) headerNames.nextElement();
          String value = request.getHeader(key);
          headers.add(key, value);
        }
        return headers;
      }
}
