package com.explorer.repository;

import com.explorer.entity.AddressEntity;
import com.explorer.entity.RegisteredEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredRepository extends JpaRepository<RegisteredEntity, Long> {
}
