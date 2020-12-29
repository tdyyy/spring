package com.example.demo.config;

import org.aspectj.lang.annotation.AfterThrowing;
import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 9:35
 * @Vision: 1.0
 */
@Configuration
public class QuartzConfigration {

    @Autowired
    private JobFactory jobFactory;
    @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean(){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        try{
            factoryBean.setOverwriteExistingJobs(true);
            factoryBean.setQuartzProperties(getQuartzProperties());
            factoryBean.setJobFactory(jobFactory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return factoryBean;
    }
    @Bean
    public Properties getQuartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean(name = "schduler")
    public Scheduler getScheduler(){
        return getSchedulerFactoryBean().getScheduler();
    }
}
