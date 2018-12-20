package pers.tao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.tao.Application;
import pers.tao.conf.BizConf;

/**
 * @description: Test
 * @author: chenyutao
 * @date: 2018/12/20 15:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AutoConfTest {
    @Autowired
    private BizConf bizConf;

    @Test
    public void testConf(){
        System.out.println("system property: "+System.getProperty("spring.config.name"));
        System.out.println("system property: "+System.getenv("spring.config.name"));
        System.out.println(bizConf);
    }

}
