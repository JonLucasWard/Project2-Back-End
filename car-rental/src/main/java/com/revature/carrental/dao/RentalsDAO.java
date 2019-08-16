package com.revature.carrental.dao;

import com.revature.carrental.model.Rentals;

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
import org.springframework.stereotype.Service;

import com.revature.carrental.repository.RentalsRepository;

@Service
public class RentalsDAO  {
	
	@Autowired
	RentalsRepository rentalsRepository;
	
	/*
	 * SAVE rentals
	 */
	
	public Rentals save(Rentals rentals) {
		return rentalsRepository.save(rentals);
		
	}
	
	
	/*
	 * SEARCH ALL rentals
	 */

	public List<Rentals> findAll() {
		return rentalsRepository.findAll(new Specification<Rentals>() {
			@Override
			public Predicate toPredicate(Root<Rentals> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		});
	}
	
	/*
	 * GET RENTALS LIST BY QUERY
	 */
	
	public List<Rentals> findByCriteria(Rentals rentals, Pageable pageable, Integer y, Integer z){
		Page page = rentalsRepository.findAll(new Specification<Rentals>() {
            @Override
        	public Predicate toPredicate(Root<Rentals> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            	List<Predicate> predicates = new ArrayList<>();
                if(rentals.getUserid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("userid"), rentals.getUserid())));
                }
                if(rentals.getCarid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("carid"), rentals.getCarid())));
                }
                if(rentals.getTransactionid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("transactionid"), rentals.getTransactionid())));
                }
                if(rentals.getApproved()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("approved"), rentals.getApproved())));
                }
                if(rentals.getDaterented()!=null) {
                	if(y == 1) {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("daterented"), rentals.getDaterented())));
                	} else if (y == 2) {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("daterented"), rentals.getDaterented())));
                	} else {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("daterented"), rentals.getDaterented())));
                	}
                }
                if(rentals.getDescription()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("description"), "%"+rentals.getDescription()+"%")));
                }
                if(rentals.getExpectedreturn()!=null) {
                	if(z == 1) {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("expectedreturn"), rentals.getExpectedreturn())));
                	} else if (z == 2) {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("expectedreturn"), rentals.getExpectedreturn())));
                	} else {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("expectedreturn"), rentals.getDaterented())));
                	}
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
		
		page.getTotalElements();
		page.getTotalPages();
		return page.getContent();
	}
	
	/*
	 * GET A RENTAL BY ID
	 */
	
	public Rentals findOne(Long rentalid) {
		return rentalsRepository.findOne(rentalid);
	}
	
	/*
	 * GET ALL RENTALS BY CARID
	 */
	
	public ArrayList<Rentals> findAll(Long carid) {
		return rentalsRepository.findAllBycarid(carid);
	}
	
	/*
	 * DELETE rentals
	 */
	
	public void delete(Rentals rentals) {
		rentalsRepository.delete(rentals);
	}


}