package com.revature.carrental.dao;

import com.revature.carrental.model.Users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.carrental.repository.UsersRepository;

@Service
public class UsersDAO  {
	
	@Autowired
	UsersRepository usersRepository;
	
	/*
	 * SAVE USERS
	 */
	
	public Users save(Users users) {
		return usersRepository.save(users);
		
	}
	
	
	/*
	 * SEARCH ALL USERS
	 */
	public List<Users> findAll() {
		return usersRepository.findAll(new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		});
	}
	
	
	/*
	 * GET A USER BY ID
	 */
	
	public Users findOne(Long userid) {
		return usersRepository.findOne(userid);
	}
	
	/*
	 * GET USER LIST BY QUERY
	 */
	
	public List<Users> findByCriteria(Users users, Pageable pageable){
		Page page = usersRepository.findAll(new Specification<Users>() {
            @Override
        	public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(users.getUserid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("userid"), users.getUserid())));
                }
                if(users.getUsername()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("username"), "%"+users.getUsername()+"%")));
                }
                if(users.getPassword()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("password"), "%"+users.getPassword()+"%")));
                }
                if(users.getFirstname()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("firstname"), "%"+users.getFirstname()+"%")));
                }
                if(users.getLastname()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("lastname"), "%"+users.getLastname()+"%")));
                }
                if(users.getEmail()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("email"), "%"+users.getEmail()+"%")));
                }
                if(users.getPhonenumber()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("phonenumber"), "%"+users.getPhonenumber()+"%")));
                }
                if(users.getRole()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("role"), users.getRole())));
                }
                if(users.getDriverlicense()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("driverlicense"), "%"+users.getDriverlicense()+"%")));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
		
		page.getTotalElements();
		page.getTotalPages();
		return page.getContent();
    }
	
	/*
	 * DELETE USERS
	 */
	
	public void delete(Users users) {
		usersRepository.delete(users);
	}


}
