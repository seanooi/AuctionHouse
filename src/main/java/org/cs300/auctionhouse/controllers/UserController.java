package org.cs300.auctionhouse.controllers;

import org.cs300.auctionhouse.services.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	protected Services services;

	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public void addUserForm() {
		logger.info("adduser?");
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public String addUserSubmit() {
		logger.info("user added!");
		boolean success = false;
		try {
			//TODO: add user here!
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (success) return "addSuccess";
		else return "addFailure";
	}
}
