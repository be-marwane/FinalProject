package com.marwane.secureapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marwane.secureapp.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
