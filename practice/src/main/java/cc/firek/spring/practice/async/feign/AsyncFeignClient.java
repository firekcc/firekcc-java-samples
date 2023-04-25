package cc.firek.spring.practice.async.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId = "asyncFeignClient", value = "spring-boot-practice")
public interface AsyncFeignClient {

    @GetMapping("/asyncFeign/testA")
    String testA();
}
