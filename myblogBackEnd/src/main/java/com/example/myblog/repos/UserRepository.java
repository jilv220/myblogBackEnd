package com.example.myblog.repos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.myblog.models.User;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.userName = ?1")
    User findUserByUserName(String userName);

    @Transactional
    @Modifying
    @Query(value = "DELETE from User")
    int clearAllUser();
}
