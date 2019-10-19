package fr.esir.jxc.repositories;

import fr.esir.jxc.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import  java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    Page<User> findAll();
}
