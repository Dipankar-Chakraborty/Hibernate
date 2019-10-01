package com.zensar.services;

import java.util.List;

import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

/**
	 * @author Dipankar Chakraborty
	 * @version 1.0
	 * @creation_date 21st sep 2019 5.29PM
	 * @modification_date 21st sep 2019 5.29PM
	 * @copyright Zensar Technologies. All rights reserved.
	 * @description:It is business service interface. It is used in business layer of application.
	 */

public interface UserService {
	
	void addUser(User user) throws ServiceException;
	void updateUser(User user) throws ServiceException;
	void removeUser(User user) throws ServiceException;
	User findUserByUserName(String username) throws ServiceException;
	List<User> findAllUsers() throws ServiceException;
	boolean validateUser(User user)  throws ServiceException;
}
