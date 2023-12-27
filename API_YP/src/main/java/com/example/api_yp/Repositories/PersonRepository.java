package com.example.api_yp.Repositories;

import com.example.api_yp.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findUserByUsername (String username);
}
