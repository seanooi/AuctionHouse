package org.cs300.auctionhouse.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControlPanelController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value="/control/panel", method=RequestMethod.GET)
	public void controlPanelForm() {
		logger.info("control panel get");
	}
	
	@RequestMapping(value="/control/panel", method=RequestMethod.POST)
	public void controlPanelSubmit() {
		logger.info("control panel post");
	}
}
