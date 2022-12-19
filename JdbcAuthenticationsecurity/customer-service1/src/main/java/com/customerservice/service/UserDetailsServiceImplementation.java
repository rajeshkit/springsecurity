package com.customerservice.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customerservice.entity.User;
import com.customerservice.repository.CustomerRepository;
import com.customerservice.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserDetailsServiceImplementation 
implements UserDetailsService{
	
	Logger log=LoggerFactory.getLogger(UserDetailsServiceImplementation.class);
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		System.out.println("User Object found is"+user);
				log.info("User details imp service called and executing loadUserByUsername(String email)");
	
		System.out.println("User Object found is"+user);
		log.info("User Object found is"+user);
		if(user == null)
		{
			throw new UsernameNotFoundException("Email not exists in the DB, Kindly Register");
		}
		
		log.info("User Object found is"+user);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String password = encoder.encode(user.getPassword());
//        System.out.println("Converted Password");
		UserDetails us=org.springframework.security.core.userdetails.User
				.withUsername(user.getEmail())
				
				.password(user.getPassword())
				
				.roles("user")
				.build();
		
		return us;
	}

}
