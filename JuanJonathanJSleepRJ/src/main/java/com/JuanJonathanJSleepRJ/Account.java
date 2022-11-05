package com.JuanJonathanJSleepRJ;

import java.util.regex.*;;

public class Account extends Serializable{
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    
    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher2 = pattern2.matcher(password);
        return matcher.find() && matcher2.find();
    }

    public String toString(){
        return "Name : " + this.name + "\nEmail : " + this.email 
        + "\nPassword : " + this.password;
    }
}
