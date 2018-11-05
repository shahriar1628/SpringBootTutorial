package com.springBoot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springBoot.Application2;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application2.class)
@WebAppConfiguration
public class ApplicationTest {
    @Test
    public void contextLoads() {

    }
}