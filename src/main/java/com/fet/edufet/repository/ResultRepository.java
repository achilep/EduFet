package com.fet.edufet.repository;

import com.fet.edufet.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer> {
    List<Result> findAllByStudent_REGNO(Integer id);
    List<Result> findAllByOrderByStudent_CLASSAsc();
}
