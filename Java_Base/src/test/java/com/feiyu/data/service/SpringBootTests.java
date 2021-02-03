package com.feiyu.data.service;

import com.feiyu.data.MavenApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author xzhou.James
 * @Date 2020/6/26  8:43
 */
@SpringBootTest(classes = MavenApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringBootTests {
    @Test
    public void Test(){
        String version = SpringBootVersion.getVersion();
        System.out.println("version"+version);
    }
}
