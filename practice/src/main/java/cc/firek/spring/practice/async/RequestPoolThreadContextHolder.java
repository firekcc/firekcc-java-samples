package cc.firek.spring.practice.async;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.springframework.web.context.request.RequestAttributes;

public class RequestPoolThreadContextHolder {

    private static final ThreadLocal<RequestAttributes> CONTEXT_HOLDER = new TransmittableThreadLocal<>();

    /**
     * 设置请求上下文
     *
     * @param requestAttributes 请求上下文
     */
    public static void setPoolThreadContext(RequestAttributes requestAttributes) {
        CONTEXT_HOLDER.set(requestAttributes);
    }

    /**
     * 获取请求上下文
     *
     * @return 请求上下文
     */
    public static RequestAttributes getPoolThreadContext() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除请求上下文
     */
    public static void clearPoolThreadContext() {
        CONTEXT_HOLDER.remove();
    }
}


