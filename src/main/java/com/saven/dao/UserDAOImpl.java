package com.saven.dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saven.model.GapsIndex;
import com.saven.model.GapsIndexRowMapper;
import com.saven.model.User;
import com.saven.model.UserRowMapper;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT user_name, password, mail FROM entpperf_user_details";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<User> rowMapper = new UserRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	@Override
	public User getUserById(String userName) {
		String sql = "SELECT user_name, password, mail FROM entpperf_user_details WHERE user_name = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, userName);
		return user;
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean userExists(String userName, String mail) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<GapsIndex> getLatestGaps() {
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String tableName = "20180507_tfp_gaps_index";
		String sql = "select minute, flavor, feed, recv, miss, fill from "
				+ tableName +" order by minute desc limit 10";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<GapsIndex> rowMapper = new GapsIndexRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
}
