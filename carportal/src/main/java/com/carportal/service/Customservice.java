//Service for Login Security

package com.carportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carportal.entity.User;
import com.carportal.repository.UserRepository;
import com.carportal.security.ApplicationUserDetail;
@Service
public class Customservice implements UserDetailsService {
    @Autowired
	UserRepository DaoUser;
    User user;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user = DaoUser.findByUsername(username);
		if(user==null) {
			System.out.println("User name is Invalid");
			throw new UsernameNotFoundException(username + " Not Found");
		}
		return new ApplicationUserDetail(user);
	}

}
