package JuanJonathanJSleepRJ;

public class Price
{
    double price;
    double rebate;
    int discount;
    
    public Price(double price){
        this.price = price;
        this.rebate = 0;
        this.discount = 0;
    }

    public Price(double price, int discount){
        this.price = price;
        this.rebate = 0;
        this.discount = discount;
    }

    public Price(double price, double rebate){
        this.price = price;
        this.rebate = 0;
        this.rebate = rebate;
    }

    private double getDiscountedPrice(){
        if (discount > 100){
            discount = 100;
        }
        return price * (1 - (discount / 100));
    }

    private double getRebatedPrice(){
        if(rebate > price){
            rebate = price;
        }
        return price - rebate;
    }
}
