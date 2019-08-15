package y.y.yadmin.module.test.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import y.y.yadmin.module.test.model.TpUserInfo;

import java.util.List;

public interface TpUserinfoMapper extends BaseMapper<TpUserInfo> {
    List<TpUserInfo> testSelect();
}
