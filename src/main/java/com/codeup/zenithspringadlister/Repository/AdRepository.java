package com.codeup.zenithspringadlister.Repository;

import com.codeup.zenithspringadlister.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {


    // adding this eliminates the need to make an Optional in the Controller Classes
    Ad findById(long id);
}
