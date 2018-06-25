package com.spring.boot.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.boot.hibernate.model.User;
import com.spring.boot.hibernate.repository.UserDao;

@Controller
public class UserController {

	@Autowired
	private UserDao _userDao;

	@RequestMapping(value = "/")
	public String viewWelcomePage(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam long id) {
		try {
			User user = new User();
			user.setId(id);
			_userDao.delete(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/save")
	public String create(Model model, @ModelAttribute("user") User user) {
		System.out.println("save");
		try {
			_userDao.save(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:/";
	}

}
