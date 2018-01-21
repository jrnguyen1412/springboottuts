package com.coderkysu.springboot.hsqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderkysu.springboot.hsqlexample.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
