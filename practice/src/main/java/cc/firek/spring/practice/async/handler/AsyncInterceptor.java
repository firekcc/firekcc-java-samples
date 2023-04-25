package cc.firek.spring.practice.async.handler;

import cc.firek.spring.practice.async.RequestPoolThreadContextHolder;
import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.AsyncWebRequestInterceptor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;

@Configuration
public class AsyncInterceptor implements AsyncWebRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AsyncInterceptor.class);

    @Override
    public void afterConcurrentHandlingStarted(WebRequest request) {
        logger.error("afterConcurrentHandlingStarted");
    }

    @Override
    public void preHandle(WebRequest request) throws Exception {
        logger.error("preHandle");
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        logger.error("postHandle");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null != requestAttributes) {
            logger.error("web interceptor child requestAttributes is {}", JSON.toJSONString(requestAttributes.getSessionId()));
        }
        String temp = (String) requestAttributes.getAttribute("test01", 0);
        logger.error("temp is {}", temp);
        RequestContextHolder.setRequestAttributes(RequestPoolThreadContextHolder.getPoolThreadContext());
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        logger.error("afterCompletion");
//        RequestPoolThreadContextHolder.clearPoolThreadContext();
    }
}
