package y.y.yadmin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import y.y.yadmin.module.test.controller.testController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YAdminApplicationTests {

    @Autowired
    private testController testController;

    @Test
    public void contextLoads() {
        System.out.println(testController.test1());
    }

}
