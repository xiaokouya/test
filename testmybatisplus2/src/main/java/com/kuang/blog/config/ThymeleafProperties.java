package com.kuang.blog.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {
    private final static Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;
    private final static String DEFAULT_PREFIX = "classpath:/templates";
    private final static String DEFAULT_SUFFIX = ".html";
}
