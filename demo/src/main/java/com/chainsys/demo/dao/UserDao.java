package com.chainsys.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.demo.mapper.MapperDetails;
import com.chainsys.demo.model.Registration;

@Repository
public class UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(Registration register) {
		String query = "insert into Registration(username,user_mail,password1,repassword) values (?,?,?,?)";
		Object[] params = { register.getName(), register.getMail(), register.getPassword(), register.getRepassword() };
		int rows = jdbcTemplate.update(query, params);

	}
	
	public boolean login(Registration register) {
		System.out.println("im here");
		String command = "SELECT * FROM Registration where user_mail=? and password1";

		Registration rows = jdbcTemplate.queryForObject(command, new MapperDetails(), register.getMail(), register.getPassword());

		System.out.println("inserting....");
		return true;

	}

	public List<Registration> read() {

		String command = "SELECT username,user_Mail,password1,rePassword FROM Registration";

		List<Registration> list = jdbcTemplate.query(command, new MapperDetails());

		System.out.println("inserting....");
		return list;
	}
	
	public void delete(Registration register) {
		String query = "DELETE FROM Registration WHERE username=?";
		
		int rows = jdbcTemplate.update(query, register.getName());

	}

	public void update(Registration register) {
		String query = "UPDATE Registration SET user_Mail=?,password1=? WHERE username=? ";
		Object[] params = {  register.getMail(), register.getPassword(), register.getName()};
		int rows = jdbcTemplate.update(query, params);

	}
	
	public List<Registration> search(Registration register) {

		String command = "SELECT username,user_Mail,password1,rePassword FROM Registration where username=?";

		List<Registration> list = jdbcTemplate.query(command, new MapperDetails(),register.getName());

		System.out.println("search....");
		return list;
	}

}
