package com.coderkysu.springboot.hsqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderkysu.springboot.hsqlexample.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
