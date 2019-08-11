package com.revature.carrental.repository;

import com.revature.carrental.model.Users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long >{

	Users findOneByUsername(String Username);
	
}
