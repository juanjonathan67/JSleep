package com.JuanJonathanJSleepRJ.controller;

import com.JuanJonathanJSleepRJ.*;
import com.JuanJonathanJSleepRJ.dbjson.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.regex.*;

public class AccountController implements BasicGetController<Account>{
	
	public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";;
	public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";;
	public static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	public static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	
	@JsonAutowired(value = Account.class, filepath = "json/account.json")
	public static JsonTable<Account> accountTable;
	
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}
	
	@PostMapping("/account/login")
	Account login(@RequestParam String email, @RequestParam String password) {
		return Algorithm.<Account>find(getJsonTable(), acc -> acc.email.equals(email));
	}

	@PostMapping("/account/register")
	Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password){
		Account temp = new Account(name, email, password);
		if(name.isBlank() || temp.validate() == false || Algorithm.<Account>exists(getJsonTable(), acc -> acc.email.equals(email))){
			return null;
		}else{
			return temp;
		}
	}

	@PostMapping("/account/{id}/registerRenter")
	Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address, @RequestParam String phoneNumber){
		Renter temp = new Renter(username, phoneNumber, address);
		if(Algorithm.<Account>exists(getJsonTable(), acc -> acc.id == id && acc.renter == null)){
			return temp;
		}else{
			return null;
		}
	}

	@PostMapping("/account/{id}/topUp")
	boolean topUp(@PathVariable int id, @RequestParam double balance){
		Account temp = Algorithm.<Account>find(getJsonTable(), acc -> acc.id == id);
		if(temp != null){
			temp.balance += balance;
			return true;
		}else{
			return false;
		}
	}
}
