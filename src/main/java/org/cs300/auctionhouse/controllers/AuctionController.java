package org.cs300.auctionhouse.controllers;

import java.util.List;

import org.cs300.auctionhouse.domain.Auction;
import org.cs300.auctionhouse.domain.Bid;
import org.cs300.auctionhouse.services.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AuctionController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	// Spring will inject the services here we hope
	@Autowired
	protected Services services;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/auction", method = RequestMethod.GET)
	public String auction(@RequestParam("id") int id, Model model) {
		logger.info("auction get request");
		Auction auction = services.getAuctionByID(id);
		Bid newbid = new Bid();
		model.addAttribute("auction", auction);
		model.addAttribute("newbid", newbid);
		return "auction/auction";
	}

	@RequestMapping(value = "/auction", method = RequestMethod.POST)
	public String bid(@ModelAttribute("auction") Auction auction,
			@ModelAttribute("bid") Bid bid, Model model) {
		logger.info("auction post request");
		// FIXME:need to get currently logged in user and place bid if:
		// current user is authenticated and != to auction owner and bid is valid
		return "redirect:auction/bidsuccess";
	}

	@RequestMapping(value = "/auction/add", method = RequestMethod.GET)
	public String addAuctionForm(Model model) {
		// FIXME:form for listing new auction
		return "auction/add";
	}

	@RequestMapping(value = "/auction/add", method = RequestMethod.POST)
	public String addAuctionSubmit(Model model) {
		// FIXME:persist new form to the db
		return "redirect:auction/addsuccess";
	}
}
