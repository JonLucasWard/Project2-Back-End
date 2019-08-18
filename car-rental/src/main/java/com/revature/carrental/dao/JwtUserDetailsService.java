package com.revature.carrental.dao;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.carrental.model.Users;
import com.revature.carrental.repository.UsersRepository;
@CrossOrigin
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsersRepository userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userDao.findOneByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username); 
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
		
	}
}