package com.quoccuong.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quoccuong.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	//public Customer findBynameLike(String name);
	@Query("select c from Customer c where c.name like %?1%")
	public Customer a(String name);
}
