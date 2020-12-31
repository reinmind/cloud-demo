package com.reinmind.beans;

import com.itextpdf.text.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ITextConfig {

    @Bean
    public Document docuemnt(){
        return new Document();
    }
}
