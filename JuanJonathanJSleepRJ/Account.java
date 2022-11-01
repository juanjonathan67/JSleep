package JuanJonathanJSleepRJ;

public class Account extends Serializable{
    public String name;
    public String email;
    public String password;
    
    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString(){
        return "Name : " + this.name + "\nEmail : " + this.email 
        + "\nPassword : " + this.password;
    }
}
