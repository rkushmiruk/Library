package com.ateam.service.impl;

import com.ateam.entity.User;
import com.ateam.repository.UserRepository;
import com.ateam.service.UserService;
import com.ateam.util.GitService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, InitializingBean {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        GitService.logGitTagVersion();
    }
}
