package y.y.yadmin.module.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testPageController {
    @RequestMapping("/page")
    public String page(){
        return "index";
    }
}
