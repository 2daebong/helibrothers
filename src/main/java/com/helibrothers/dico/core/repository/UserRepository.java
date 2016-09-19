package com.helibrothers.dico.core.repository;

import com.helibrothers.dico.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
public interface UserRepository extends JpaRepository<User, String>{

    User findByName(String name);
}
