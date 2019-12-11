package y.y.yadmin.module.test.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import y.y.yadmin.annotation.DataSource;
import y.y.yadmin.module.test.dao.TpUserinfoMapper;
import y.y.yadmin.module.test.model.TpUserInfo;
import y.y.yadmin.module.test.service.ITpUserinfoService;

import java.util.List;


@Service
public class TpUserinfoServiceImpl extends ServiceImpl<TpUserinfoMapper, TpUserInfo> {
   /* @Autowired
    private TpUserinfoMapper tpUserinfoMapper;
    @Override
    @DataSource(name = "gjj")
    public void testSelect() {
        List<TpUserInfo> tpUserInfos = tpUserinfoMapper.testSelect();
        System.out.println(tpUserInfos.size());
    }

    @Override
    //@DataSource(name = "gjj")
    //@Transactional
    public void testInsert1() {
        TpUserInfo t = new TpUserInfo();
        t.setBusCode("12312313288888888878987");
        tpUserinfoMapper.insert(t);
        int i = 3/0;
    }

    @Override
    //@DataSource(name = "gdca_mc")
    @Transactional
    public void testInsert2() {
        TpUserInfo t = new TpUserInfo();
        t.setBusCode("123123132gdca888888888888");
        tpUserinfoMapper.insert(t);
        int i = 3/0;
    }*/

    @Autowired
    private TpUserinfoMapper tpUserinfoMapper;

    public void testInsert2() {
        TpUserInfo t = new TpUserInfo();
        t.setBusCode("123123132gdca888888888888");
        tpUserinfoMapper.insert(t);
        //int i = 3/0;
    }
}
