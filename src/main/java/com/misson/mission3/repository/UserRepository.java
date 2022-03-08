package com.misson.mission3.repository;

import com.misson.mission3.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User ,Long> {
    List<User> findAllByName(String userName);

}
