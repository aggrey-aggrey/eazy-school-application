package com.aggrey.eazy.school.hafifu.repository;

import com.aggrey.eazy.school.hafifu.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person readByEmail(String email);

    void findByEmail(String email);
}
