package top.truism.springbootunittest;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "top.truism.springbootunittest")
public class SpringBootUnitTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUnitTestApplication.class, args);
    }

}
