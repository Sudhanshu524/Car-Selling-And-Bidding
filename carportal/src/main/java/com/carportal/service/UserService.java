package com.carportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carportal.entity.User;
import com.carportal.repository.UserRepository;

@Service
public class UserService {
	
	private PasswordEncoder passwordencoder;
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	public UserService(PasswordEncoder encoder) {
		// TODO Auto-generated constructor stub
		this.passwordencoder=encoder;
	}
	
	public String addUser(User user) {
		user.setRole("USER");
		user.setPassword(passwordencoder.encode(user.getPassword()));
		User response = userRepo.save(user);
		if (response == null) {
			return "User Not Added";
		}
		return "User Added";
	}
	
	public void updateUser(User user) {
		userRepo.save(user);
	}
	
	public List<User> listAllUser(){
		List<User> allUsers = userRepo.findAll();
		return allUsers;
	}
	
	public List<User> showUser(String name) {
		// TODO Auto-generated method stub
		return userRepo.findByFullName(name);
	}
	
	public User usersInfo(Integer userId){
		Optional<User> userInfo = userRepo.findById(userId);
		User infoUser = userInfo.get();
		return infoUser;
	}
	
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
	}
	
	public String register(String username) {
		// TODO Auto-generated method stub
		String userRegister = userRepo.register(username);
		return userRegister;
	}
	
	public User login(String username) {
		User userLogin = userRepo.findByUsername(username);
		return userLogin;
	}
	
	public List<User> searchUser(String users){
		return userRepo.findByFullNameContaining(users);
	}
	


}
