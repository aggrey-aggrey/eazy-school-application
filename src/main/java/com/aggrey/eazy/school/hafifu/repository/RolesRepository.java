package com.aggrey.eazy.school.hafifu.repository;

import com.aggrey.eazy.school.hafifu.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles getByRoleName(String studentRole);
}
