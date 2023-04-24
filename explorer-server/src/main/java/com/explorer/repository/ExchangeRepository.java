package com.explorer.repository;

import com.explorer.entity.AddressEntity;
import com.explorer.entity.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {
}
