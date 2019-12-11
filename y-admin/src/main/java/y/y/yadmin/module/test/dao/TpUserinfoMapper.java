package y.y.yadmin.module.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import y.y.yadmin.module.test.model.TpUserInfo;

import java.util.List;

public interface TpUserinfoMapper extends BaseMapper<TpUserInfo> {
    List<TpUserInfo> testSelect();
}
