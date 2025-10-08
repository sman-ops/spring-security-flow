package com.spring.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.restaurant.dao.SubscriberRepo;
import com.spring.restaurant.model.Subscriber;
import com.spring.restaurant.model.SubscriberSecurity;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private SubscriberRepo subscriberRepo;
	
	
	@Autowired
	public CustomUserDetailsService(SubscriberRepo subscriberRepo) {
		this.subscriberRepo = subscriberRepo ;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Subscriber> subscribers = subscriberRepo.findByEmail(username);
		if(subscribers.isEmpty()) {
			throw new UsernameNotFoundException("User email not exist " + username);
			
		}
		
		return new SubscriberSecurity(subscribers.get(0)) ;
	}

}
