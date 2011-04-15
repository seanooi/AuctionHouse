package org.cs300.auctionhouse.validators;

import org.cs300.auctionhouse.ui.AuctionFileData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AuctionValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return AuctionFileData.class.isAssignableFrom(arg0);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auction.title",
				"required.title", "Auction title is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"auction.description", "required.description",
				"Auction description is required");
		AuctionFileData afd = (AuctionFileData)target;
		
	}

}
