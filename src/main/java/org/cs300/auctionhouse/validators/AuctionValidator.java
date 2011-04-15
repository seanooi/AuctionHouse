package org.cs300.auctionhouse.validators;

import org.cs300.auctionhouse.domain.Category;
import org.cs300.auctionhouse.ui.AuctionFileData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class AuctionValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return AuctionFileData.class.isAssignableFrom(arg0);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auction.title", "", "Auction title is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auction.description", "", "Auction description is required");
		AuctionFileData afd = (AuctionFileData)target;
		Category category = afd.getAuction().getCategory();
		if (category.getIdCategory() == 0) {
			//must select valid category
			errors.rejectValue("auction.category", "", "You must select a category.");
		}
		CommonsMultipartFile file = afd.getFile();
		String fileName = file.getOriginalFilename().toLowerCase();
		if (!(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png") || fileName.endsWith(".gif"))) {
			//incorrect file type
			errors.rejectValue("file", "", "The file you selected is not supported.\nPNG, JPG, and GIF formats only.");
		}
	}

}
