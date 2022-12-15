package com.aggrey.eazy.school.hafifu.repository;

import com.aggrey.eazy.school.hafifu.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {
}
