package com.saven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saven.dao.UserDAO;
import com.saven.model.GapsIndex;
import com.saven.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO	userDAO;
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	@Override
	public User getUserById(String userName) {
		return userDAO.getUserById(userName);
	}
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);		
	}
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);		
	}
	@Override
	public void deleteUser(String userName) {
		userDAO.deleteUser(userName);		
	}
	@Override
	public List<GapsIndex> getLatestGaps() {
		return userDAO.getLatestGaps();
	}
}
