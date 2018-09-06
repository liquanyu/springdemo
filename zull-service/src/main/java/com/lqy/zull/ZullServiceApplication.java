package com.lqy.zull;

import com.lqy.zull.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZullServiceApplication {

	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZullServiceApplication.class, args);
	}
}
