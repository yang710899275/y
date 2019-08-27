package y.y.yadmin.module.test.controller;

import com.baomidou.mybatisplus.toolkit.Sequence;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    @ApiOperation(value = "test1")
    public String test1(){
        log.info("cc");
        return "sss";
    }

    //异常
    @RequestMapping("/excp")
    public String testException(){
        int i = 10 / 0;
        Sequence WORKER = new Sequence();
        System.out.println(WORKER.nextId());

        return "sss";
    }

    public static void main(String[] args) {
        Sequence WORKER = new Sequence();
        System.out.println(WORKER.nextId());
        System.out.println(WORKER);
    }
}
