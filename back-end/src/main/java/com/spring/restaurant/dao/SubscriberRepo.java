package com.spring.restaurant.dao;

import org.springframework.stereotype.Repository;

import com.spring.restaurant.model.Subscriber;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber,Long> {
	
	List<Subscriber> findByEmail(String email);

}
 