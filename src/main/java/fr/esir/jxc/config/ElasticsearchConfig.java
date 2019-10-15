package fr.esir.jxc.config;

import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.context.annotation.Bean;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "fr.esir.jxc.repositories")
public class ElasticsearchConfig {

    @Value("${elasticsearch.home:C:/Programmes/elasticsearch-5.6.0}")
    private String elasticsearchHome;

    @Value("${elasticsearch.clustername:pocket-cluster}")
    private String clusterName;

    @Value("${elasticsearch.host:127.0.0.1}")
    private String clusterHost;

    @Value("${elasticsearch.port:9300}")
    private int clusterPort;

    @Bean
    public Client client() throws Exception{
        Settings settings = Settings.builder()
                .put("path.home", elasticsearchHome)
                .put("cluster.name", clusterName)
                .build();
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        return transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(clusterHost), clusterPort));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception{
        return new ElasticsearchTemplate(client());
    }
}
