package controller.testController;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class testController {

    static {
        System.out.println("1111111111111111");
    }
    @RequestMapping("/test111")
    public String test(){
        System.out.println("sss");
        return "cccc";
    }
}
