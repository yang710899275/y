package y.y.yadmin.module.test.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import y.y.yadmin.annotation.DataSource;
import y.y.yadmin.module.test.dao.TpUserinfoMapper;
import y.y.yadmin.module.test.model.TpUserInfo;
import y.y.yadmin.module.test.service.ITpUserinfoService;

import java.util.List;

@Service
public class TpUserinfoServiceImpl extends ServiceImpl<TpUserinfoMapper, TpUserInfo>  implements ITpUserinfoService {
    @Autowired
    private TpUserinfoMapper tpUserinfoMapper;

    @Override
    @DataSource(name = "gjj")
    public void testSelect() {
        List<TpUserInfo> tpUserInfos = tpUserinfoMapper.testSelect();
        System.out.println(tpUserInfos.size());
    }

    @Override
    @DataSource(name = "gjj")
    public void testInsert1() {
        TpUserInfo t = new TpUserInfo();
        t.setId("1234567");
        t.setBusCode("123123132");
        tpUserinfoMapper.insert(t);
    }

    @Override
    @DataSource(name = "gdca_mc")
    public void testInsert2() {
        TpUserInfo t = new TpUserInfo();
        t.setId("1234567");
        t.setBusCode("123123132");
        tpUserinfoMapper.insert(t);
    }
}
