
package com.org.dao;

	import org.springframework.data.repository.CrudRepository;

	import com.org.model.Users;

	public interface UserDao extends CrudRepository<Users, Long> {

		//User findByusernameAndpassword(String username, String password);

		//User findByUserNameAndPassword(String username, String password);

		Users findByUsernameAndPassword(String username, String password);



	}


