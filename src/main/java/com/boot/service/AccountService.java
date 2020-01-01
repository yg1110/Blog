package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.Repository.AccountRepository;
import com.boot.dto.Authority;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.boot.dto.User appUser = accountRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

		List<GrantedAuthority> grantList = new ArrayList<>();
		for (Authority authority : appUser.getAuthority()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantList.add(grantedAuthority);
		}

		UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
		return user;
	}
}