package com.reinmind.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zx
 */
@Configuration
public class JSONConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();

//      config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        config.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);

        //添加 application/json 到SupportMediaTypes
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(MediaType.APPLICATION_JSON);

        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
        super.configureMessageConverters(converters);
    }
}
