package cc.firek.spring.practice.async;

import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsyncServletRequestAttributes extends ServletRequestAttributes {

    public AsyncServletRequestAttributes(ServletRequestAttributes servletRequestAttributes) {
        super(servletRequestAttributes.getRequest(), servletRequestAttributes.getResponse());
    }

    public AsyncServletRequestAttributes(HttpServletRequest request) {
        super(request);
    }

    public AsyncServletRequestAttributes(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public boolean getRequestActive(){
        return isRequestActive();
    }
}
