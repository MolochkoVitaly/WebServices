package com.epam.paytickets.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig.class)
@ComponentScan(basePackages={"com.epam.paytickets"})
public class WSAppConfig {

}
