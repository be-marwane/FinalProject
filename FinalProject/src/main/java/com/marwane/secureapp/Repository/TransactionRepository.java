package com.marwane.secureapp.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marwane.secureapp.Model.Transaction;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}