package com.chainsys.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.demo.dao.UserDao;
import com.chainsys.demo.model.Registration;

@Controller
public class DemoController {
	@Autowired
	UserDao user;

	@RequestMapping("/")

	public String homePage() {

		return "home.jsp";
	}

	@RequestMapping("/register")

	public String register(@RequestParam("username") String name, @RequestParam("mail") String mail,
			@RequestParam("re-password") String password, @RequestParam("password") String repassword, Model model) {
		Registration register = new Registration();

		register.setName(name);
		register.setMail(mail);
		register.setPassword(password);
		register.setRepassword(repassword);
		user.insert(register);

		List<Registration> list = user.read();
		model.addAttribute("view", list);

		return "success.jsp";
	}
	
	@RequestMapping("/login")

	public String register(@RequestParam("mail") String mail, @RequestParam("pass") String password) {
		Registration register = new Registration();

		register.setName(mail);
		register.setMail(password);
		if(user.login(register)==true) {
			return "success.jsp";
		};


		return "login.jsp";
	}

	@RequestMapping("/delete")

	public String delete(@RequestParam("delete") String name, Model model) {
		Registration register = new Registration();

		register.setName(name);
		user.delete(register);
		List<Registration> list = user.read();
		model.addAttribute("view", list);
		return "success.jsp";
	}

	@PostMapping("/update")

	public String update(@RequestParam("username") String name, @RequestParam("mail") String mail,
			@RequestParam("password") String password, Model model) {
		Registration register = new Registration();

		register.setName(name);
		register.setMail(mail);
		register.setPassword(password);
		user.update(register);

		List<Registration> list = user.read();
		model.addAttribute("view", list);

		return "success.jsp";
	}

	@PostMapping("/search")

	public String search(@RequestParam("search") String name, Model model) {
		Registration register = new Registration();

		register.setName(name);
		System.out.println("Searchinggggg"+register.getName());
		user.search(register);

		List<Registration> list = user.search(register);
		model.addAttribute("view", list);

		return "success.jsp";
	}
}
