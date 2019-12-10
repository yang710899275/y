package y.y.yadmin.module.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import y.y.yadmin.annotation.DataSource;
import y.y.yadmin.module.test.dao.TpUserinfoMapper;
import y.y.yadmin.module.test.model.TpUserInfo;
import y.y.yadmin.module.test.service.ITpUserinfoService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
/*@RestController*/
@Validated
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
     * 事务： 如果两个service 上面加事务 ，则第二个执行事务 不会影响第一个 只会执行其中一个
     * 如果在controller层加上事务 ，则 数据源切换失效
     * @return
     */
    @RequestMapping("/testTpUserInfo")
    @ResponseBody
    @Transactional   //如果这里开启了事务 ，则 数据源切换将没有作用  事务要在数据源切换之后
    public String testTpUserInfo(){
        tpUserinfoService.testInsert1();
        //tpUserinfoService.testInsert2();
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

  @RequestMapping("/testTpUserInfo2")
  @ResponseBody
  public String testTpUserInfo2(){
    tpUserinfoService.testInsert2();
    return "ss";
  }

  @RequestMapping("/testValidate")
  @ResponseBody
  public String testTpUserInfo2(@Valid TpUserInfo tpUserInfo){
    System.out.println(tpUserInfo.toString());
    return "ss";
  }

  @RequestMapping("/testValidate2")
  @ResponseBody
  public String testTpUserInfo2(@NotNull(message = "name不能为空") String name){
    System.out.println(name);
    return "ss2";
  }
}
