package com.saven.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet row, int rowNum) throws SQLException {
		User user = new User();
		user.setUserName(row.getString("user_name"));
		user.setPassword(row.getString("password"));
		user.setMail(row.getString("mail"));
		return user;
	}

}
