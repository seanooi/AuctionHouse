package org.cs300.auctionhouse.security;

import org.cs300.auctionhouse.domain.User;
import org.cs300.auctionhouse.services.Services;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	  Services services;
	  
	  public void setServices(Services value) {
		  services = value;
	  }
	  
	  UserAssembler userAssembler;
	  
	  public void setUserAssembler(UserAssembler value) {
		  userAssembler = value;
	  }

	  @Transactional(readOnly = true)
	  public UserDetails loadUserByUsername(String username)
	      throws UsernameNotFoundException, DataAccessException {

	    User userEntity = services.findByName(username);
	    if (userEntity == null)
	      throw new UsernameNotFoundException("user not found");

	    return userAssembler.buildUserFromUserEntity(userEntity);
	  }
}
