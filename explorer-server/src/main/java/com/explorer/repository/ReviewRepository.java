package com.explorer.repository;

import com.explorer.entity.AddressEntity;
import com.explorer.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> getReviewsByUniversityId(Long universityId);
}
