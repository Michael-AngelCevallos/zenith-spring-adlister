package com.codeup.zenithspringadlister.Repository;


import com.codeup.zenithspringadlister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

        User findById(long id);

}
