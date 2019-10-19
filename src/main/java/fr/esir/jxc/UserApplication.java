package fr.esir.jxc;

import fr.esir.jxc.models.Address;
import fr.esir.jxc.models.User;
import fr.esir.jxc.services.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;


@SpringBootApplication
@Slf4j
public class UserApplication implements CommandLineRunner{

    @Autowired
    private ElasticsearchOperations esOperation;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfos();

    }

    /**
     * A method that display information about the ElasticSearch database
     */
    private void printElasticSearchInfos() {

        log.info("--- ElasticSearchInfos : Start ---");
        Client client = esOperation.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            log.info(k + " = " + v);
        });
        log.info("--- ElasticSearchInfos : End ---");
    }
}
