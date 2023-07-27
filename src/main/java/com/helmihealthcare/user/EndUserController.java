package com.helmihealthcare.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndUserController {

	@Autowired
	private EndUserService userService;
	
	@RequestMapping("/Users")
	List<EndUser> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/User/{id}")
	EndUser getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Users")
	void addUser(@RequestBody EndUser user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/User/{id}")
	void updateUeser(@PathVariable Long id, @RequestBody EndUser user) {
		userService.updateUser(id, user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/User/{id}")
	void deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
	}
	
}
