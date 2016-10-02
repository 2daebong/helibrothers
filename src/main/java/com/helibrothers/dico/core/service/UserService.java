package com.helibrothers.dico.core.service;

import com.helibrothers.dico.core.repository.UserRepository;
import com.helibrothers.dico.domain.User;
import com.helibrothers.dico.exception.InvalidUserInfoException;
import org.apache.commons.lang3.StringUtils;
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
        User findUser = userRepository.findByName(user.getId());
        if (findUser != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findOne(String userId) {
        User user = userRepository.findOne(userId);

        return user;
    }

    public String getUserIdFromEmail(String userEmail) {
        String[] parsedStr = StringUtils.split(userEmail, "@");

        return parsedStr[0];
    }

}
