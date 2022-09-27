package JuanJonathanJSleepRJ;

public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    /*
    public Voucher(String name, int code, Type type, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }
    */

    public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean canApply(Price price){
        if((price.price > this.minimum) && (this.used == false)){
            return true;
        }else{
            return false;
        }
    }

    public double apply(Price price){
        this.used = true;
        if(this.type == Type.DISCOUNT){
            if(this.cut > 100){
                this.cut = 100;
            }
            return price.price * (1 - this.cut / 100);
        }else{ // when REBATE
            if(this.cut > price.price){
                this.cut = price.price;
            }
            return price.price - this.cut;
        }
    }

    public boolean isUsed(){
        return this.used;
    }
}
