package com.dilip.springboot.myFirstApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username,String password) {
		Boolean isValidUsername =username.equalsIgnoreCase("Root");
		Boolean isValidPassword =password.equalsIgnoreCase("ROOT");
		return isValidUsername && isValidPassword;
		
	}
	

}
