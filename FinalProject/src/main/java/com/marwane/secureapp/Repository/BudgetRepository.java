package com.marwane.secureapp.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marwane.secureapp.Model.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {
	
	@Query("select b from Budget b where b.administrator = :user")
    List<Budget> findUsers(@Param("user") Long user);
}