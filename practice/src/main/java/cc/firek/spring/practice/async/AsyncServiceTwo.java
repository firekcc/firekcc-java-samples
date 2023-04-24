package cc.firek.spring.practice.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service
public class AsyncServiceTwo {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceTwo.class);

    @Async
    public String doBiz(){
        logger.error("enter AsyncServiceTwo doBiz");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (String) requestAttributes.getAttribute("test02", 1);
    }
}
