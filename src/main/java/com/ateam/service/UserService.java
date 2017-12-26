package com.ateam.service;

import org.springframework.retry.annotation.EnableRetry;

import com.ateam.entity.User;

@EnableRetry
public interface UserService extends GenericService<User> {

}
