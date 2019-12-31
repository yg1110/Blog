package com.boot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.Repository.UserRepository;
import com.boot.dto.Member;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Member createAccount(Member member) {
		Member account = new Member();
		account.setId(member.getId());
		account.setPwd(passwordEncoder.encode(member.getPwd()));
		account.setName(member.getName());
		account.setAuth(member.getAuth());
		return userRepository.save(account);
 	}
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Optional<Member> Byusername = userRepository.findById(id);
		Member account = Byusername.orElseThrow(()->new UsernameNotFoundException(id));
		return new User(account.getId(), account.getPwd(), authorities());
	}

	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}