package com.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.customerservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from user where email=:mail",nativeQuery = true)
	public User findByEmail(@Param("mail") String email);
}
