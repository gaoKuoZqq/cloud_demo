package com.guoyicap.micro.route.zuul.comment.filter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * @Description: post请求错误日志(服务抛出错误执行)
 * @author gaokuo
 */
@Component
public class LogFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	
    /**
     * 获取参数数组
     * @param request
     * @return byte[]
     * @throws IOException
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();  
        if (ctx.getResponseStatusCode() == 500) {
        	return true;
		}else {
			return false;
		}
	}

	@Override
	public Object run() {
		try {
			RequestContext ctx = RequestContext.getCurrentContext();  
	        HttpServletRequest request = ctx.getRequest();
	        byte buffer[] = getRequestPostBytes(request);
	        String charEncoding = request.getCharacterEncoding();
        	log.error("---------------SERVER_ERROR---------------");
        	log.error("info:" + ctx.getZuulRequestHeaders());
        	//log.error("from:" + ctx.getRequest().getRequestURI());
        	//log.error("info:" + ctx.getRequest().getRequestURL());
        	log.error("status:" + ctx.getResponseStatusCode());
        	log.error("params:" + new String(buffer, charEncoding));
        	log.error("------------------------------------------");
		} catch (Exception e) {
			log.error("===============FILTER_ERROR===============");
			log.error(e.getMessage());
			log.error("==========================================");
		}
        return null;  
	}
}
