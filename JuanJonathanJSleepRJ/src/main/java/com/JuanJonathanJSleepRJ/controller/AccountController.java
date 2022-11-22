package com.JuanJonathanJSleepRJ.controller;

import com.JuanJonathanJSleepRJ.*;
import com.JuanJonathanJSleepRJ.dbjson.*;

import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.*;

@RestController

@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>{
	
	public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";;
	public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";;
	public static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	public static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	
	@JsonAutowired(value = Account.class, filepath = "json/account.json")
	public static JsonTable<Account> accountTable;

	@GetMapping
	String index(){
		return "account page";
	}	
	
	@Override
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}
	
	@PostMapping("/login")
	Account login(
		@RequestParam String email, 
		@RequestParam String password
	) {
		Account found = Algorithm.<Account>find(accountTable, acc -> acc.email.equals(email));
		String generatedPass = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPass = sb.toString();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (found != null && found.password.equals(generatedPass)) {
			return found;
		}else {
        	return null;
		}
	}

	@PostMapping("/register")
	Account register(
		@RequestParam String name, 
		@RequestParam String email, 
		@RequestParam String password
	){
		Matcher mail = REGEX_PATTERN_EMAIL.matcher(email);
		Matcher pass = REGEX_PATTERN_PASSWORD.matcher(password);
		if (name.isBlank()) {
			return null;
		}
		if(Algorithm.<Account>exists(accountTable, acc -> acc.email.equals(email) && acc.name.equals(name) && acc.password.equals(password))){
			return null;
		}
		else if(mail.find() && pass.find()) {
			String generatedPassword = null;
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes());
				byte[] bytes = md.digest();
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < bytes.length; i++) {
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
				generatedPassword = sb.toString();
			}catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Account temp = new Account(name, email, generatedPassword);
			accountTable.add(temp);
			return temp;
		}
		else {
			return null;
		}
	}

	@PostMapping("/{id}/registerRenter")
	Renter registerRenter(
		@PathVariable int id, 
		@RequestParam String username, 
		@RequestParam String address, 
		@RequestParam String phoneNumber
	){
		Account found = Algorithm.<Account>find(getJsonTable(), acc -> acc.id == id && acc.renter == null);
		if(found != null){
			found.renter = new Renter(username, phoneNumber, address);;
			return found.renter;
		}else{
			return null;
		}
	}

	@PostMapping("/{id}/topUp")
	boolean topUp(
		@PathVariable int id, 
		@RequestParam double balance
	){
		Account found = Algorithm.<Account>find(getJsonTable(), acc -> acc.id == id);
		if(found != null){
			found.balance += balance;
			return true;
		}else{
			return false;
		}
	}
}
