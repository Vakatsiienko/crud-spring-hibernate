package com.jrtest.vaka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Iaroslav
 * @since 06.12.2014 20:28
 */
@Configuration
@ComponentScan(basePackages = "com.jrtest.vaka.dao.*")
@PropertySource("classpath:persistence.properties")
@EnableTransactionManagement
public class PersistenceConfig {
    @Inject
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource;
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            dataSource = new SimpleDriverDataSource(driver,
                    env.getProperty("dataSource.url"),
                    env.getProperty("dataSource.username"),
                    env.getProperty("dataSource.password"));
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cant find driver for url", e);
        }

        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(env.getProperty("persistence.generateDdl", Boolean.class));
        adapter.setShowSql(env.getProperty("persistence.showSql", Boolean.class));
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan(env.getProperty("persistence.basePackages"));
        factory.setDataSource(dataSource());
        Properties props = new Properties();

        props.setProperty("jadira.usertype.autoRegisterUserTypes", "true");
        props.setProperty("jadira.usertype.databaseZone", "jvm");
        props.setProperty("jadira.usertype.javaZone", "jvm");
        factory.setJpaProperties(props);

        factory.afterPropertiesSet();
//        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}
