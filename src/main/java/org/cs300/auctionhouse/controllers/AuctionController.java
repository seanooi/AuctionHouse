package org.cs300.auctionhouse.controllers;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import org.cs300.auctionhouse.domain.Auction;
import org.cs300.auctionhouse.domain.Bid;
import org.cs300.auctionhouse.domain.Category;
import org.cs300.auctionhouse.domain.User;
import org.cs300.auctionhouse.services.Services;
import org.cs300.auctionhouse.ui.AuctionFileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class AuctionController {

	// Spring will inject the services here we hope
	@Autowired
	protected Services services;

	@RequestMapping(value = "/auction/{id}", method = RequestMethod.GET)
	public String auction(@PathVariable("id") int id, Model model) {
		Auction auction = services.getAuctionByID(id);
		model.addAttribute("auction", auction);
		return "auction/auction";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(services.getCategoryByID(Integer.valueOf(text)));
			}
		});
	}

	@RequestMapping(value = "/auction/add", method = RequestMethod.GET)
	public String addAuctionForm(Model model) {
		AuctionFileData afd = new AuctionFileData();
		List<Category> categories = services.getAllCategories();
		model.addAttribute("afd", afd);
		model.addAttribute("categories", categories);
		return "auction/add";
	}

	@RequestMapping(value = "/auction/add", method = RequestMethod.POST)
	public String addAuctionSubmit(@ModelAttribute("afd") AuctionFileData afd, BindingResult result, SessionStatus status) {
		User user = services.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
		afd.getAuction().setUser(user);
		afd.getAuction().setPicture(afd.getFile().getBytes());
		int id = services.saveNewAuction(afd.getAuction());
		return "redirect:addsuccess?id=" + id;
	}

	@RequestMapping(value = "auction/addsuccess", method = RequestMethod.GET)
	public String auctionSuccess(@RequestParam("id") int id, Model model) {
		model.addAttribute("id", id);
		return "auction/addsuccess";
	}

	@RequestMapping(value = "/auction/{id}/bid", method = RequestMethod.GET)
	public String bidForm(@PathVariable("id") int id, Model model) {
		Bid bid = new Bid();
		model.addAttribute("bid", bid);
		return "auction/bid";
	}

	@RequestMapping(value = "/auction/{id}/bid", method = RequestMethod.POST)
	public String bidSubmit(@PathVariable("id") int id, @ModelAttribute("bid") Bid bid, Model model) {
		bid.setAuction(services.getAuctionByID(id));
		bid.setUser(services.findByName(SecurityContextHolder.getContext().getAuthentication().getName()));
		bid.setTime(new Date());
		services.saveNewBid(bid);
		return "redirect:bidsuccess";
	}

	@RequestMapping(value = "/auction/{id}/bidsuccess", method = RequestMethod.GET)
	public String bidSuccess(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id);
		return "auction/bidsuccess";
	}
}
