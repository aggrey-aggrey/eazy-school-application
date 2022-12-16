package com.aggrey.eazy.school.hafifu.repository;

import com.aggrey.eazy.school.hafifu.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}
