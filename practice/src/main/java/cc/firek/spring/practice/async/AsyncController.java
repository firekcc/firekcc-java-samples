package cc.firek.spring.practice.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@RequestMapping("/asyncTest")
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private AsyncServiceOne asyncServiceOne;

    @Autowired
    private AsyncServiceTwo asyncServiceTwo;

    @GetMapping("/one")
    public String test01() {
        logger.error("enter test01");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        requestAttributes.setAttribute("test01", "哈哈哈", 0);
        RequestContextHolder.setRequestAttributes(requestAttributes, true);
        return asyncServiceOne.doBiz();
    }

    @GetMapping("02")
    public String test02() {
        logger.error("enter test02");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        requestAttributes.setAttribute("test02", "呵呵呵", 1);
        RequestContextHolder.setRequestAttributes(requestAttributes, true);
        return asyncServiceTwo.doBiz();
    }
}
