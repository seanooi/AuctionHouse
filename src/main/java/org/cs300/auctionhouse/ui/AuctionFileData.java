package org.cs300.auctionhouse.ui;

import org.cs300.auctionhouse.domain.Auction;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AuctionFileData {

	private Auction auction;
	private CommonsMultipartFile file;

	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
}
