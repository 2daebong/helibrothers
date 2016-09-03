package com.helibrothers.dico.core.service;

import com.helibrothers.dico.core.repository.UserRepository;
import com.helibrothers.dico.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception {

        // Given
        User user = new User();
        user.setId("daebong");
        user.setName("대봉2");

        // When
        String userId = userService.join(user);

        // Then
        assertEquals(user, userRepository.findOne("daebong"));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {

        // Given
        User user1 = new User();
        user1.setId("lee1");
        user1.setName("lee1name");
        User user2 = new User();
        user2.setId("lee1");
        user2.setName("lee1name");

        // When
        userService.join(user1);
        userService.join(user2);

        // Then
        fail("예외가 발생해야 한다.");
    }

}