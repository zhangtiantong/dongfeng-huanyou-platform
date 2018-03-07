package com.navinfo.opentsp.dongfeng;

import com.navinfo.opentsp.dongfeng.common.entity.HyPlatformLogEntity;
import com.navinfo.opentsp.dongfeng.common.entity.HyTerminalLogEntity;
import com.navinfo.opentsp.dongfeng.common.service.impl.OperateLogService;
import com.navinfo.opentsp.dongfeng.common.service.impl.TerminalLogService;
import com.navinfo.opentsp.dongfeng.monitor.entity.HyCarEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by zhangy on 2015/12/31.
 */
@Configuration
@ComponentScan(basePackages = "com.navinfo.opentsp.dongfeng,com.navinfo.opentsp.dongfeng.monitor")
@EnableJpaRepositories(basePackageClasses = {TerminalLogService.class, OperateLogService.class})
@EntityScan(basePackageClasses = {HyTerminalLogEntity.class, HyPlatformLogEntity.class, HyCarEntity.class})
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class Application
{
    
    private static final int EXECUTOR_SERVICE_POOL_SIZE = 5;
    
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        System.out.println("启动完毕。。。。。。");
    }
    
}