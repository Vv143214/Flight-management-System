package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.UserDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userRepo;

	@Override
	public ResponseEntity<?> createUser(Users newUser) {
		Optional<Users> findUserById = userRepo.findById(newUser.getId());
		try
		{
			if(!findUserById.isPresent())
			{
				userRepo.save(newUser);
				return new ResponseEntity<Users>(newUser, HttpStatus.OK);
			}else
				throw new RecordAlreadyPresentException("User with Id: "+ newUser.getId() + "already exists");
			}catch(RecordAlreadyPresentException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
	}

	@Override
	public Users updateUser(Users updateUser) {
		Optional<Users> findUserById = userRepo.findById(updateUser.getId());
		if(findUserById.isPresent())
		{
			userRepo.save(updateUser);
		}else
			throw new RecordNotFoundException("User with Id: " + updateUser.getId() + " not exist");
		return updateUser;
	}

	@Override
	public String deleteUser(Long userId) {
		// TODO Auto-generated method stub
		Optional<Users> findBookingById = userRepo.findById(userId);
		if(findBookingById.isPresent())
		{
			userRepo.deleteById(userId);
			return "User Deleted Successfully";
		}else
			throw new RecordNotFoundException("User not found for the entered ID");
	}

	@Override
	public Iterable<Users> displayAllUsers() {
	
		return userRepo.findAll();
	}

	@Override
	public ResponseEntity<?> findUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<Users> findById = userRepo.findById(userId);
		try {
			if(findById.isPresent())
			{
				Users findUser = findById.get();
				return new ResponseEntity<Users>(findUser,HttpStatus.OK);
			}else
				throw new RecordNotFoundException("No record found with Id:" + userId);			
		}catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			
		}
	}

	@Override
	public ResponseEntity<Users> signInUser(Users user){
		Users user1= userRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(user1== null) {
			return new ResponseEntity<Users>(user1,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Users>(user1,HttpStatus.OK);
		}
	}
	
	}


