package com.example.async.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author 彬
 * @Date 2019/7/11
 */
@Repository
public interface UserRepository extends JpaRepository<User1,Integer> {

}
