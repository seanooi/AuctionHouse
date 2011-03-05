package org.cs300.auctionhouse.security;

import java.util.ArrayList;
import java.util.Collection;

import org.cs300.auctionhouse.domain.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userAssembler")
public class UserAssembler {
	
	  @Transactional(readOnly = true)
	  User buildUserFromUserEntity(org.cs300.auctionhouse.domain.User userEntity) {

	    String username = userEntity.getUsername();
	    String password = userEntity.getPassword();
	    boolean enabled = userEntity.isEnabled();
	    boolean accountNonExpired = userEntity.isEnabled();
	    boolean credentialsNonExpired = userEntity.isEnabled();
	    boolean accountNonLocked = userEntity.isEnabled();

	    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (Authority auth : userEntity.getAuthorities()) {
	      authorities.add(new GrantedAuthorityImpl(auth.getAuthority()));
	    }

	    User user = new User(username, password, enabled,
	      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    return user;
	  }
}
