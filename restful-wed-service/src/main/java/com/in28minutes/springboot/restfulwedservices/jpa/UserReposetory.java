package com.in28minutes.springboot.restfulwedservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.restfulwedservices.user.User;

public interface UserReposetory extends JpaRepository<User, Integer> {

}
