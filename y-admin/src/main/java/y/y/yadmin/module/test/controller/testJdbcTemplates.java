package y.y.yadmin.module.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import y.y.yadmin.annotation.DataSource;
import y.y.yadmin.module.test.dao.TpUserinfoMapper;
import y.y.yadmin.module.test.model.TpUserInfo;
import y.y.yadmin.module.test.service.ITpUserinfoService;

import java.util.List;

@Controller
/*@RestController*/
public class testJdbcTemplates {
  /*  @Autowired
    private JdbcTemplate jdbcTemplate;*/
    @Autowired
    private ITpUserinfoService tpUserinfoService;
    @Autowired
    private TpUserinfoMapper tpUserinfoMapper;

  /*  @RequestMapping("/testJdbc")
    private String test(){
        jdbcTemplate.execute("select * from sys_dict");
        return "ss";
    }*/

    /**
     * 两个都执行了事务
     * @return
     */
    @RequestMapping("/testTpUserInfo")
    @ResponseBody
    @Transactional
    public String testTpUserInfo(){
        tpUserinfoService.testInsert1();
        tpUserinfoService.testInsert2();
       /* TpUserInfo t = new TpUserInfo();
        t.setId("1234567");
        t.setBusCode("123123132");*/
       /* tpUserinfoMapper.insert(t);

        tpUserinfoService.testSelect();*/
        /*    int a = 3/0;*/
     /*   List<TpUserInfo> tpUserInfos = tpUserinfoMapper.selectByMap(null);
        System.out.println(tpUserInfos.size());*/

        return "ss";
    }
}
