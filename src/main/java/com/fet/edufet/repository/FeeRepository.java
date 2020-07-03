package com.fet.edufet.repository;

import com.fet.edufet.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeRepository extends JpaRepository<Fee,Integer> {
    Optional<Fee> findFeeByStudent_REGNO(Integer Id);
}
