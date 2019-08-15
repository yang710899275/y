package y.y.yadmin.config;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 多数据源配置
 */
/*@Configuration
*//*@ConditionalOnProperty(prefix = "guns.muti-datasource", name = "open", havingValue = "false", matchIfMissing = true)*//*
@EnableTransactionManagement
@MapperScan(basePackages = {"y.y.yadmin.module.*.dao"})*/
public class SingleDataSourceConfig {

   /* *//**
     * mybatis-plus分页插件
     *//*
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    *//**
     * 乐观锁mybatis插件
     *//*
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
*/
}

