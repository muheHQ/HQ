package com.hong.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }

}
