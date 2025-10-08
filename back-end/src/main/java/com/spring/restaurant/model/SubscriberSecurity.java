package com.spring.restaurant.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SubscriberSecurity implements UserDetails {
	
	private Subscriber subscriber;
	
	
	@Autowired
	public SubscriberSecurity( Subscriber subscribe) {
		this.subscriber = subscribe;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority(subscriber.getRole()));
		return authorityList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return subscriber.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return subscriber.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
