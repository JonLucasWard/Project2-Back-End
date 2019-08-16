package com.revature.carrental.repository;

import com.revature.carrental.model.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users>{

	Users findOneByUsername(String Username);
	List<Users> findAll();
	
}
