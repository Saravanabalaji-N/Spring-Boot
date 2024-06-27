package com.chainsys.demo.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.demo.model.Registration;

public class MapperDetails implements RowMapper<Registration>{

	@Override
	public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
		Registration register=new Registration();
		String name=rs.getString("username");
		String mail=rs.getString("user_mail");
		String pass1=rs.getString("password1");
		String pass2=rs.getString("rePassword");
		
		register.setName(name);
		register.setMail(mail);
		register.setPassword(pass1);
		register.setRepassword(pass2);
		return register;
	}

	
}
