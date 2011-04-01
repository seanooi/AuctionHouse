package org.cs300.auctionhouse.controllers;

import org.cs300.auctionhouse.domain.Auction;
import org.cs300.auctionhouse.services.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuctionController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//Spring will inject the services here we hope
	@Autowired
	protected Services services;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/auction", method=RequestMethod.GET)
	public String home(@RequestParam("id")int id, Model model) {
		logger.info("auction get request");
		Auction auction = services.getAuctionByID(id);
		model.addAttribute("auction", auction);
		return "home";
	}
	
}

