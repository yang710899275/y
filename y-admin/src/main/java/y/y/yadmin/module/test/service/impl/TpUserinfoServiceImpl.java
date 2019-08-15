package y.y.yadmin.module.test.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import y.y.yadmin.module.test.dao.TpUserinfoMapper;
import y.y.yadmin.module.test.model.TpUserInfo;
import y.y.yadmin.module.test.service.ITpUserinfoService;
@Service
public class TpUserinfoServiceImpl extends ServiceImpl<TpUserinfoMapper, TpUserInfo>  implements ITpUserinfoService {
}
