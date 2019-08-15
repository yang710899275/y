package y.y.yadmin.module.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import y.y.yadmin.module.test.dao.TpUserinfoMapper;
import y.y.yadmin.module.test.model.TpUserInfo;
import y.y.yadmin.module.test.service.ITpUserinfoService;

import java.util.List;

@RestController
public class testJdbcTemplates {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ITpUserinfoService tpUserinfoService;
    @Autowired
    private TpUserinfoMapper tpUserinfoMapper;

    @RequestMapping("/testJdbc")
    private String test(){
        jdbcTemplate.execute("select * from sys_dict");
        return "ss";
    }

    @RequestMapping("/testTpUserInfo")
    private String testTpUserInfo(){
        List<TpUserInfo> tpUserInfos = tpUserinfoMapper.selectByMap(null);
        System.out.println(tpUserInfos.size());
        List<TpUserInfo> tpUserInfos1 = tpUserinfoMapper.testSelect();
        System.out.println(tpUserInfos1.size());
        return "ss";
    }
}
