package com.helmihealthcare.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndUserService {
	
	@Autowired
	private EndUserRepository userRepo;

	public List<EndUser> getAllUsers() {
		List<EndUser> userList = new ArrayList<>();
		userRepo.findAll().forEach(userList::add);
		return userList;
	}

	public EndUser getUserById(Long id) {
		return userRepo.findById(id).get();
	}

	public void addUser(EndUser user) {
		userRepo.save(user);
	}

	public void updateUser(EndUser user) {
		userRepo.save(user);
	}

	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
	
	

}
