package org.cs300.auctionhouse.controllers;

import org.cs300.auctionhouse.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImageController {

	@Autowired
	protected Services services;
	
	@RequestMapping(value="/image", method=RequestMethod.GET)
	public void getImage(@RequestParam("id") int id, ModelAndView model) {
		model.addObject(services.getAuctionImage(id));
		//model.addAttribute("image", services.getAuctionImage(id));
		return;
	}
}
