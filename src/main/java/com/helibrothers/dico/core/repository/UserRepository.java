package com.helibrothers.dico.core.repository;

import com.helibrothers.dico.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{

    User findByName(String name);
}
