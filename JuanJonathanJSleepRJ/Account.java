package JuanJonathanJSleepRJ;

public class Account extends Serializable implements FileParser
{
    public String name;
    public String email;
    public String password;
    
    public Object write(){
        return null;
    }
    
    public boolean read(String a){
        return false;
    }
    
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
