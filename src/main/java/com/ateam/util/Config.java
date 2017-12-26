package com.ateam.util;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.baeldung.spring.data.es.repository")
@ComponentScan(basePackages = {"com.baeldung.spring.data.es.service"})
public class Config {

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        Settings.Builder elasticsearchSettings =
            Settings.settingsBuilder()
                .put("http.enabled", "false")
                .put("path.home", "PATH_TO_YOUR_ELASTICSEARCH_DIRECTORY");


        return new ElasticsearchTemplate(nodeBuilder()
            .local(true)
            .settings(elasticsearchSettings.build())
            .node()
            .client());
    }
}