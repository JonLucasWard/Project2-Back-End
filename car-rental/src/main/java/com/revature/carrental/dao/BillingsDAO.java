package com.revature.carrental.dao;

import com.revature.carrental.model.Billings;

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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.carrental.repository.BillingsRepository;
@CrossOrigin
@Service
public class BillingsDAO  {
	
	@Autowired
	BillingsRepository billingsRepository;
	
	/*
	 * SAVE BILLINGS
	 */
	
	public Billings save(Billings billings) {
		return billingsRepository.save(billings);
		
	}
	
	
	/*
	 * SEARCH ALL BILLINGS
	 */
	
	public List<Billings> findAll() {
		return billingsRepository.findAll(new Specification<Billings>() {
			@Override
			public Predicate toPredicate(Root<Billings> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		});
	}
	
	/*
	 * SEARCH ALL BILLINGS BY QUERY
	 */
	public List<Billings> findByCriteria(Billings billings, Pageable pageable, Integer y){
		Page page = billingsRepository.findAll(new Specification<Billings>() {
            @Override
        	public Predicate toPredicate(Root<Billings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(billings.getBillingid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("billingid"), billings.getBillingid())));
                }
                if(billings.getCardno()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("cardno"), "%"+billings.getCardno()+"%")));
                }
                if(billings.getExpdate()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("expdate"), "%"+billings.getExpdate()+"%")));
                }
                if(billings.getNameoncard()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nameoncard"), "%"+billings.getNameoncard()+"%")));
                }
                if(billings.getCvv()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("cvv"), billings.getCvv())));
                }
                if(billings.getTransactionid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("transactionid"), billings.getTransactionid())));
                }
                if(billings.getUserid()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("userid"), billings.getUserid())));
                }
                if(billings.getAmount()!=null) {
                	if(y == 1) {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("amount"), billings.getAmount())));
                	} else if (y == 2) {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), billings.getAmount())));
                	} else {
                		predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("amount"), billings.getAmount())));
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
	 * GET A BILL BY ID
	 */
	
	public Billings findOne(Long billingid) {
		return billingsRepository.findOne(billingid);
	}
	
	/*
	 * DELETE BILLINGS
	 */
	
	public void delete(Billings billings) {
		billingsRepository.delete(billings);
	}


}