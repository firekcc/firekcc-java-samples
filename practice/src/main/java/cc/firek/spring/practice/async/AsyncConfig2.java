//package cc.firek.spring.practice.async;
//
//import com.alibaba.fastjson2.JSON;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//
//@EnableAsync
//@Configuration
//public class AsyncConfig2 extends AsyncConfigurerSupport {
//
//    private static final Logger logger = LoggerFactory.getLogger(AsyncConfig2.class);
//
//    @Bean
//    public ThreadPoolTaskExecutor asyncExecutor() {
//        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
//        threadPool.setCorePoolSize(3);
//        threadPool.setMaxPoolSize(3);
//        threadPool.setWaitForTasksToCompleteOnShutdown(true);
//        threadPool.setAwaitTerminationSeconds(60 * 15);
//        return threadPool;
//    }
//
//    @Override
//    public Executor getAsyncExecutor() {
//        return asyncExecutor();
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return (ex, method, params) -> logger.error("执行异步任务 method is {} params is {} exception is {}", method, JSON.toJSONString(params), ex);
//    }
//}