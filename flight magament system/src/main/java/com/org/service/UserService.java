package com.org.service;

import org.springframework.http.ResponseEntity;
import com.org.model.Users;

public interface UserService {
	public ResponseEntity<?> createUser(Users newUser);
	public Users updateUser(Users newUser);
	public String deleteUser(Long userId);
	public Iterable<Users> displayAllUsers();
	public ResponseEntity<?> findUserById(Long userId);	
	public ResponseEntity<Users> signInUser(Users user);

}

	


