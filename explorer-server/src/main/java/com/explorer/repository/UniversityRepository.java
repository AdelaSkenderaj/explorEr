package com.explorer.repository;

import com.explorer.entity.AddressEntity;
import com.explorer.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {
//    List<UniversityEntity> findByCountryId(Long countryId);
}
