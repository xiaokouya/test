package com.zhao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestjwtApplication.class)
class TestjwtApplicationTests {


//    还有 @Before  @After
    @Test
    void contextLoads() {
        System.out.println("hello");
    }

}
