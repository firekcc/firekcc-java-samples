package cc.firek.spring.practice.async.feign;

import cc.firek.spring.practice.async.handler.AsyncInterceptor;
import cc.firek.spring.practice.async.RequestPoolThreadContextHolder;
import com.alibaba.fastjson2.JSON;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;

@Configuration
public class AsyncFeignInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AsyncInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        RequestAttributes requestAttributes = RequestPoolThreadContextHolder.getPoolThreadContext();
        if (null != requestAttributes) {
            logger.error("feign child requestAttributes is {}", JSON.toJSONString(requestAttributes.getSessionId()));
        }
        String tempFeign = (String) requestAttributes.getAttribute("test01", 0);
        logger.error("tempFeign is {}", tempFeign);
    }
}
