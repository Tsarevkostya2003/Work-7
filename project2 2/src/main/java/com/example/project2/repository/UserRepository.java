package com.example.project2.repository;

import com.example.project2.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long> {
    Optional<UserModel> findByname(String name);
}
