package y.y.yadmin.module.test.service;

import com.baomidou.mybatisplus.service.IService;
import y.y.yadmin.module.test.model.TpUserInfo;

public interface ITpUserinfoService extends IService<TpUserInfo> {
     void testSelect();

     void testInsert1();

     void testInsert2();
}
