package com.sy.spring.cloud.alibaba.generator.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sy
 * @date: 2020/8/15 14:04
 * @description ES配置类
 */
@Configuration
public class ElasticSearchConfig {


    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        //new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9200, "http")));

        return client;
    }


}
