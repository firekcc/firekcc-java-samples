package cc.firek.spring.practice.async.feign;

import cc.firek.spring.practice.async.AsyncServletRequestAttributes;
import cc.firek.spring.practice.async.RequestPoolThreadContextHolder;
import com.alibaba.fastjson2.JSON;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;

@Configuration
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class AsyncFeignInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AsyncFeignInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        AsyncServletRequestAttributes requestAttributes = (AsyncServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            requestAttributes = (AsyncServletRequestAttributes) RequestPoolThreadContextHolder.getPoolThreadContext();
            logger.error("从RequestContextHolder获取不到requestAttributes，改成从RequestPoolThreadContextHolder获取");
            logger.error("线程活跃状态为 {}", requestAttributes.getRequestActive());
        }
        logger.error("feign child requestAttributes is {}", JSON.toJSONString(requestAttributes.getSessionId()));
        String tempFeign = (String) requestAttributes.getAttribute("test01", 0);
        logger.error("tempFeign is {}", tempFeign);
    }
}
