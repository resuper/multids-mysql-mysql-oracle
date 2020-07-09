package com.resuper.mutlds.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.resuper.mutlds.mapper.mapper3", sqlSessionTemplateRef  = "secondary3SqlSessionTemplate")
public class DataSource3Config {
    @Bean(name = "secondary3DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary3")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "secondary3SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("secondary3DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/UserMapper3.xml"));
        return bean.getObject();
    }

    @Bean(name = "secondary3TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("secondary3DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondary3SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("secondary3SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    }
