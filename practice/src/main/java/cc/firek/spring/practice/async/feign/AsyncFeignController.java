package cc.firek.spring.practice.async.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asyncFeign")
public class AsyncFeignController {

    private static final Logger logger = LoggerFactory.getLogger(cc.firek.spring.practice.async.AsyncController.class);

    @GetMapping("/testA")
    public String testA() {
        return "feign接口测试";
    }

}
