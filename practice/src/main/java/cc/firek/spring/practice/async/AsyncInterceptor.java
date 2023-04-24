package cc.firek.spring.practice.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.AsyncWebRequestInterceptor;
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
        RequestContextHolder.setRequestAttributes(RequestPoolThreadContextHolder.getPoolThreadContext());
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        logger.error("afterCompletion");
//        RequestPoolThreadContextHolder.clearPoolThreadContext();
    }
}
