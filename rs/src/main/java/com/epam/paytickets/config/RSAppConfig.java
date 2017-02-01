package com.epam.paytickets.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"com.epam.paytickets"})
@Import(AppConfig.class)
public class RSAppConfig {
}
