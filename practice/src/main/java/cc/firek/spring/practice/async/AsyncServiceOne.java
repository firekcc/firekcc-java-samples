package cc.firek.spring.practice.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service
public class AsyncServiceOne {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceOne.class);

    @Async
    public String doBiz() {
        logger.error("enter AsyncServiceOne doBiz");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            return "error";
        }
        return (String) requestAttributes.getAttribute("test01", 0);
    }
}