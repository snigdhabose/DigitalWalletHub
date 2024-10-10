package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.models.UserD;

@Component
public interface UserService extends JpaRepository<UserD,Integer> {

}
