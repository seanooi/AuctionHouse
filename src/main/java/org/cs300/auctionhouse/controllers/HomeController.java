package org.cs300.auctionhouse.controllers;

import java.util.List;

import org.cs300.auctionhouse.domain.*;
import org.cs300.auctionhouse.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//Spring will inject the services here we hope
	@Autowired
	protected Services services;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		List<Auction> auctions = services.getAllAuctions();
		model.addAttribute("auctions", auctions);
		return "home";
	}
	
}

