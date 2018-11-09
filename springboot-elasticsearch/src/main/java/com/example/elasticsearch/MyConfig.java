package com.example.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 创建ES client配置
 * Created by suneee on 2018/7/5.
 */
@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        // 集群设置
        Settings settings = Settings.builder().put("cluster.name", "yhl").build();
        TransportClient client = new PreBuiltTransportClient(settings);

        // 设置node节点
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);

        client.addTransportAddress(address);

        return client;
    }
}
