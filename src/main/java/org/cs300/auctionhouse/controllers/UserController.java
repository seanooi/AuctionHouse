package org.cs300.auctionhouse.controllers;

import org.cs300.auctionhouse.services.Services;
import org.cs300.auctionhouse.ui.UserPersonalInfo;
import org.cs300.auctionhouse.validators.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	protected Services services;
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String addUserForm(Model model) {
		UserPersonalInfo upi = new UserPersonalInfo();
		model.addAttribute("upi", upi);
		return "user/add";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUserSubmit(@ModelAttribute("upi") UserPersonalInfo upi,
			BindingResult result, SessionStatus status) {
		userValidator.validate(upi, result);
		if (result.hasErrors()) {
			return "user/add";
		} else {
			services.createUser(upi.getUser(), upi.getPersonalInfo());
			return "redirect:success";
		}
	}

	@RequestMapping(value="/user/update", method=RequestMethod.GET)
	public String updateUserForm(Model model) {
		logger.info("/user/update get request");
		return "user/add";
	}

	@RequestMapping(value="/user/update", method=RequestMethod.POST)
	public String updateUserSubmit() {
		logger.info("/user/update post request");
		return "redirect:success";
	}

	@RequestMapping(value="/user/success", method = RequestMethod.GET)
	public String addUserSuccess() {
		return "user/success";
	}
}
