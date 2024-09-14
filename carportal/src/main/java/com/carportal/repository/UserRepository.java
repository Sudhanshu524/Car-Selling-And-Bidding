package com.carportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carportal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
User findByUsername(String username);
	
	List<User> findByFullName(String search);
	List<User> findByFullNameContaining(String search);
	/* List<User> findByUserNameContaining(String search); */
	
	@Query(value = "SELECT COUNT(username) FROM user WHERE username = ?1", nativeQuery = true)
	String register(String username);

}
