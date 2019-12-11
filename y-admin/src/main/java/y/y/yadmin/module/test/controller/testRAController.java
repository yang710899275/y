package y.y.yadmin.module.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import y.y.yadmin.module.test.model.ra.CusCertinfo;
import y.y.yadmin.module.test.service.ra.CusCertinfoServiceImpl;

import java.util.Date;

@RestController
public class testRAController {
    @Autowired
    CusCertinfoServiceImpl cusCertinfoService;

    @RequestMapping("/testmybatis3oracle")
    @ResponseBody
    public String testmybatis3oracle(String name){
        System.out.println(name);
        CusCertinfo cusCertinfo = new CusCertinfo();
        cusCertinfo.setCusinfoid("12345678123456781234567812345678");
        cusCertinfo.setCerttypeid("12345678123456781234567812345678");
        cusCertinfo.setDpid("12345678123456781234567812345678");
        cusCertinfo.setCainfoid("12345678123456781234567812345678");
        cusCertinfo.setRainofid("12345678123456781234567812345678");
        cusCertinfo.setTemplateid("12345678123456781234567812345678");
        cusCertinfo.setOnlinetime(0);
        cusCertinfo.setHandseltime(0);
        cusCertinfo.setApplytype("1");
        cusCertinfo.setStatus("1");
        cusCertinfo.setCreatedate(new Date());
        cusCertinfo.setLastmodifydate(new Date());
        cusCertinfoService.save(cusCertinfo);
        return "ss2";
    }
}
