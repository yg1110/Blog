//package com.boot.service;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.boot.dto.USER;
//
//@Service
//public class AccountService implements UserDetailsService{
//	
//	@Autowired
//	private IUserService service;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	static USER account = new USER();
//	
//	public void createAccount(String username, String password) {
//		account.setEmail(username);
//		account.setPwd(passwordEncoder.encode(password));
//		System.out.println(account);
// 	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		createAccount(username, password);
//		USER Byusername = service.findUser(account);
//		if(Byusername==null) {
//			new UsernameNotFoundException(username);
//		}
//		return new User(Byusername.getEmail(), Byusername.getPwd(), authorities());
//	}
//
//	private Collection<? extends GrantedAuthority> authorities() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//	}
//
//}
