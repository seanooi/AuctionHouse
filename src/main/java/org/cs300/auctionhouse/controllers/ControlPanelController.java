package org.cs300.auctionhouse.controllers;

import java.util.List;

import org.cs300.auctionhouse.domain.Auction;
import org.cs300.auctionhouse.services.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControlPanelController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	protected Services services;
	
	@RequestMapping(value="/control/panel", method=RequestMethod.GET)
	public void controlPanelForm(Model model) {
		logger.info("control panel get");
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Auction> auctions = services.getUserSales(currentUser);
		List<Auction> bids = services.getUserBids(currentUser);
		model.addAttribute("auctions", auctions);
		model.addAttribute("bids", bids);
	}
	
	@RequestMapping(value="/control/panel", method=RequestMethod.POST)
	public void controlPanelSubmit() {
		logger.info("control panel post");
	}
}
