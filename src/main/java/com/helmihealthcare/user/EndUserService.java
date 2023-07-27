package com.helmihealthcare.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public void updateUser(Long id, EndUser user) {
		Optional<EndUser> userRep = userRepo.findById(id);
		if(userRep.isPresent()){
			EndUser oldUser = userRep.get();
			if(user.getAddress() != null){
				oldUser.setAddress(user.getAddress());
			}
			if(user.getEmail() != null){
				oldUser.setEmail(user.getEmail());
			}
			if(user.getName() != null){
				oldUser.setName(user.getEmail());
			}
			if(user.getPhoneNumber() != null){
				oldUser.setPhoneNumber(user.getPhoneNumber());
			}
			if(user.getVerificationId() != null){
				oldUser.setVerificationId(user.getVerificationId());
			}
			userRepo.save(oldUser);
		}
	}

	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
	
	

}
