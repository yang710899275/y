package y.y.yadmin.aop;

import config.properties.DruidProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import y.y.yadmin.annotation.DataSource;
import y.y.yadmin.config.DataSourceContextHolder;

import java.lang.reflect.Method;

@Aspect
@Component
public class MutiDataSourceAop implements Ordered {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DruidProperties druidProperties;

    @Pointcut(value = "@annotation(y.y.yadmin.annotation.DataSource)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        MethodSignature methodSignature;
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        methodSignature = (MethodSignature) signature;

        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        DataSource datasource = currentMethod.getAnnotation(DataSource.class);
        if (datasource != null) {
            DataSourceContextHolder.setDataSourceType(datasource.name());
            log.debug("设置数据源为：" + datasource.name());
        } else {
            DataSourceContextHolder.setDataSourceType(druidProperties.getDataSourceName());
            log.debug("设置数据源为：dataSourceCurrent");
        }

        try {
            return point.proceed();
        }finally {
            log.debug("清空数据源信息！");
            DataSourceContextHolder.clear();
        }
    }

    /**
     * aop的顺序要早于spring的事务
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
