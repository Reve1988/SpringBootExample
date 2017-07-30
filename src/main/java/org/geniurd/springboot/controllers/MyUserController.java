package org.geniurd.springboot.controllers;

import org.geniurd.springboot.model.MyUser;
import org.geniurd.springboot.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyUserController {
	private MyUserService myUserService;

	@Autowired
	public MyUserController(
			MyUserService myUserService) {
		this.myUserService = myUserService;
	}

	@RequestMapping(value = "/user/show", method = RequestMethod.GET)
	public List<MyUser> getAll() {
		return myUserService.getAll();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public MyUser get(@PathVariable Long id) {
		return myUserService.get(id);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public MyUser post(@ModelAttribute MyUser myUser) {
		return myUserService.saveOrUpdate(myUser);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		myUserService.delete(id);
		return "OK";
	}
}
