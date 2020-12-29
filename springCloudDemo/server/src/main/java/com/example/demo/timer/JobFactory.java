package com.example.demo.timer;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: tangdy
 * @Date: 2020/12/28 11:37
 * @Vision: 1.0
 */
@Component
public class JobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object o = super.createJobInstance(bundle);
        autowireCapableBeanFactory.autowireBean(o);
        return o;
    }
}
