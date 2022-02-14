package top.truism.springbootunittest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootUnitTestApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootUnitTestApplicationTests.class);

    @Test
    void contextLoads() {
        logger.info("Test context started");

    }

}
