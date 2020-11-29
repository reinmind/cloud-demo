package com.reinmind;

import com.reinmind.entities.Overview;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@Slf4j
public class RestConsumer {

    public static Logger logger = LoggerFactory.getLogger(RestConsumer.class);
    public static void main(String[] args) {
        SpringApplication.run(RestConsumer.class,args);
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @Bean
    CommandLineRunner run(RestTemplate restTemplate){
        return args -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setBasicAuth("guest","guest");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);
            ResponseEntity<Overview> overviewResponseEntity = restTemplate.exchange("http://localhost:15672/api/overview", HttpMethod.GET, entity, Overview.class);
            System.out.println(overviewResponseEntity);
        };
    }
}
