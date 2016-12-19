package com.example.dao.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.pool.DruidDataSource;
/**
 * Created by Administrator on 2016/12/14 0014.
 */

@Configuration
@PropertySource({ "classpath:mysql/data_source.properties" })
@MapperScan(basePackages = "com.example.dao.mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {
    @Value("${dw.jdbc.url}")
    private String dbUrl;

    @Value("${dw.jdbc.user}")
    private String dbUser;

    @Value("${dw.jdbc.pass}")
    private String dbPassword;

    //配置初始化大小、最小、最大
    @Value("${dw.jdbc.initialSize}")
    private Integer initialSize;

    @Value("${dw.jdbc.minIdle}")
    private Integer minIdle;

    @Value("${dw.jdbc.maxActive}")
    private Integer maxActive;
    // 配置获取连接等待超时的时间

    @Value("${dw.jdbc.maxWait}")
    private long maxWait;

    // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    @Value("${dw.jdbc.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    // 配置一个连接在池中最小生存的时间，单位是毫秒

    @Value("${dw.jdbc.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    // 配置测试属性

    @Value("${dw.jdbc.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${dw.jdbc.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${dw.jdbc.testOnReturn}")
    private boolean testOnReturn;

    @Primary
    @Bean(name = "DataSource")
    public DataSource dwDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        //配置初始化大小、最小、最大
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        // 配置获取连接等待超时的时间
        dataSource.setMaxWait(maxWait);

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 配置测试属性
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);

        return dataSource;
    }

    @Primary
    @Bean(name = "TransactionManager")
    public DataSourceTransactionManager dwTransactionManager(@Qualifier("DataSource") DataSource dwDataSource) {
        return new DataSourceTransactionManager(dwDataSource);
    }

    @Primary
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory dwSqlSessionFactory(@Qualifier("DataSource") DataSource dwDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dwDataSource);
        return sessionFactory.getObject();
    }
}
