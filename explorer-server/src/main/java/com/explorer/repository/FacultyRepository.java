package com.explorer.repository;

import com.explorer.entity.AddressEntity;
import com.explorer.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
    List<FacultyEntity> findByUniversityId(Long universityId);
}
