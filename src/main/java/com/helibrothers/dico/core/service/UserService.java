package com.helibrothers.dico.core.service;

import com.helibrothers.dico.core.repository.UserRepository;
import com.helibrothers.dico.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByName(user.getName());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findOne(String userId) {
        return userRepository.findOne(userId);
    }
}
