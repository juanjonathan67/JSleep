package com.JuanJonathanJSleepRJ.controller;

import com.JuanJonathanJSleepRJ.*;
import com.JuanJonathanJSleepRJ.dbjson.*;

import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.*;

/**
 * Account Controller Class -
 * Contains methods related to Account, such as login, register, etc.
 * @author juanjonathan67
 * @version 1.0.0
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>{
	
	/**
     * REGEX used to verify eligibility of password. Checks if password is at least 8 characters long, has atleast 1 uppercase and 1 lowercase alphabet, and at least 1 number.
     */
	public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
	/**
     * REGEX used to verify eligibility of email. Checks for Alphanumeric characters before '@', Alphabets after '@' seperated with a '.' without another '.' at the last character.
     */
	public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
	/**
	 * Compile REGEX of password to Pattern Object
	 */
	public static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	/**
	 * Compile REGEX of email to Pattern Object
	 */
	public static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	
	/**
	 * {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} filled with all available {@link com.JuanJonathanJSleepRJ.Account}
	 */
	@JsonAutowired(value = Account.class, filepath = "json/account.json")
	public static JsonTable<Account> accountTable;

	/**
	 * Method to check request mapping
	 * @return account page
	 */
	@GetMapping
	String index(){
		return "account page";
	}	
	
	/**
	 * Implementation of {@link com.JuanJonathanJSleepRJ.controller.BasicGetController#getJsonTable()}
	 * @return Return {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} of {@link com.JuanJonathanJSleepRJ.Account}
	 */
	@Override
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}
	
	/**
	 * Method to control process of login (Finds {@link com.JuanJonathanJSleepRJ.Account} from {@link com.JuanJonathanJSleepRJ.controller.AccountController#accountTable} with matching email and password).
	 * @param email Email used to login
	 * @param password Password used to login
	 * @return Return {@link com.JuanJonathanJSleepRJ.Account} if login is successful
	 */
	@PostMapping("/login")
	Account login(
		@RequestParam String email, 
		@RequestParam String password
	) {
		Account found = Algorithm.<Account>find(getJsonTable(), acc -> acc.email.equals(email));
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

	
	/**
	 * Method to control process of registering a new {@link com.JuanJonathanJSleepRJ.Account}.
	 * Checks if email and password meet the REGEX.
	 * @param name Name to register
	 * @param email Email to register
	 * @param password Password to register
	 * @return Returns {@link com.JuanJonathanJSleepRJ.Account} if register is successful
	 */
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
		if(Algorithm.<Account>exists(getJsonTable(), acc -> acc.email.equals(email) && acc.name.equals(name) && acc.password.equals(password))){
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
			getJsonTable().add(temp);
			return temp;
		}
		else {
			return null;
		}
	}

	/**
	 * Method to register the {@link com.JuanJonathanJSleepRJ.Renter} of an {@link com.JuanJonathanJSleepRJ.Account}
	 * @param id Id of the account
	 * @param username Name of the renter
	 * @param address Address of the renter
	 * @param phoneNumber Phone number of the renter
	 * @return Returns {@link com.JuanJonathanJSleepRJ.Renter} if register is successful
	 */
	@PostMapping("/{id}/registerRenter")
	Renter registerRenter(
		@PathVariable int id, 
		@RequestParam String username, 
		@RequestParam String address, 
		@RequestParam String phoneNumber
	){
		Account found = Algorithm.<Account>find(getJsonTable(), acc -> acc.id == id);
		if(found.renter == null){
			found.renter = new Renter(username, phoneNumber, address);
			if(found.renter.validate())
				return null;
			return found.renter;
		}else{
			return null;
		}
	}

	/**
	 * Method used to top up an account's {@link com.JuanJonathanJSleepRJ.Account#balance}
	 * @param id Id of account
	 * @param balance Balance to be added
	 * @return Returns true if top up is successful
	 */
	@PostMapping("/{id}/topUp")
	boolean topUp(
		@PathVariable int id, 
		@RequestParam double balance
	){
		Account found = Algorithm.<Account>find(accountTable, acc -> acc.id == id);
		if(found != null){
			found.balance += balance;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Method used to get {@link com.JuanJonathanJSleepRJ.Account} by Id from {@link com.JuanJonathanJSleepRJ.controller.AccountController#accountTable}
	 * @param id Id to be searched
	 * @return Returns {@link com.JuanJonathanJSleepRJ.Account} with matching Id
	 */
	@GetMapping("/{id}/getAccount")
	Account getAccount(@PathVariable int id){
		return Algorithm.<Account>find(accountTable, acc -> acc.id == id);
	}

	/**
	 * Method used to get {@link com.JuanJonathanJSleepRJ.Renter} by Id from {@link com.JuanJonathanJSleepRJ.controller.AccountController#accountTable}
	 * @param id Id to be searched
	 * @return Returns {@link com.JuanJonathanJSleepRJ.Renter} with matching Id
	 */
	@GetMapping("/{id}/getRenter")
	Renter getRenter(@PathVariable int id){
		Account found = Algorithm.<Account>find(accountTable, acc -> acc.renter.id == id);
		return found.renter;
	}
}
