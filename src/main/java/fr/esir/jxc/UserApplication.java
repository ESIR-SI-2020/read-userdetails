package fr.esir.jxc;

import fr.esir.jxc.models.*;
import fr.esir.jxc.services.UserService;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();

        Address address0 = new Address("postalCode0", "street0", 0, "complement0");
        Address address1 = new Address("postalCode1", "street1", 1, "complement1");
        Address address2 = new Address("postalCode2", "street2", 2, "complement2");

        User user0 = new User("0", "user0", "user0@mail.com", "http://www.photo.com/0.png", "bio0", address0, Arrays.asList("1", "2"));
        User user1 = new User("1", "user1", "user1@mail.com", "http://www.photo.com/1.png", "bio1", address1, Arrays.asList("0", "2"));
        User user2 = new User("2", "user2", "user2@mail.com", "http://www.photo.com/2.png", "bio2", address2, Arrays.asList("0", "1"));

        userService.save(user0);

        Page<User> user = userService.findByUsername("user0", new PageRequest(0, 10));

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

        user.forEach(x -> System.out.println(x));
    }

    //useful for debug, print elastic search details
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("--ElasticSearch--");
    }
}
