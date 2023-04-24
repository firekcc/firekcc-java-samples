package cc.firek.spring.practice.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class AsyncServiceOne {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceOne.class);

    @Async
    public String doBiz() {
        logger.error("enter AsyncServiceOne doBiz");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String testHeader = request.getHeader("test01");
        return (String) servletRequestAttributes.getAttribute("test01", 0);
    }
}
