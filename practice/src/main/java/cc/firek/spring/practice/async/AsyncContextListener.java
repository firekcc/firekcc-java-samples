package cc.firek.spring.practice.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;

@Configuration
public class AsyncContextListener extends RequestContextListener {

    private static final Logger logger = LoggerFactory.getLogger(AsyncContextListener.class);

    public AsyncContextListener() {
        super();
    }

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {
        logger.error("AsyncContextListener requestInitialized");
        super.requestInitialized(requestEvent);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
        logger.error("AsyncContextListener requestDestroyed");
        super.requestDestroyed(requestEvent);
    }
}
