package com.example.demo.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class QuartzConfig {


    @Bean
    public JobDetail quartzJobDetail() {
        return JobBuilder.newJob(QuartzJobs.class)
                .withIdentity("quartzJobs").storeDurably().build();
    }

    @Bean
    public Trigger quartzTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(quartzJobDetail())
                .withIdentity("quartzTaskService").withSchedule(cronScheduleBuilder).build();
    }

}


