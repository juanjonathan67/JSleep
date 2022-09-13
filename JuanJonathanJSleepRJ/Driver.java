package JuanJonathanJSleepRJ;


/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    /**
     * Constructor for objects of class JSleep
     */
    public Driver(){
    }

    public int getHotelID(){
        return 0;
    }

    public String getHotelName(){
        return "Hotel";
    }

    public boolean isDiscount(){
        return true;
    }

    public float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount > 0){
            if(beforeDiscount < afterDiscount){
                return 0.0f;
            }else{
                return ((1 - (float)(afterDiscount) / beforeDiscount)) * 100;
            }
        }else{
            return 0.0f;
        }
    }

    public float getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return (price - price * 100);
        }else{
            return (price - price * discountPercentage);
        }
    }

    public void main(String[] args) {
        Driver dr = new Driver();
        System.out.println("Hotel ID : " + dr.getHotelID());
        System.out.println("Hotel name : " + dr.getHotelName());
        System.out.println("Discount? : " + dr.isDiscount());
        System.out.println("Discount % : " + dr.getDiscountPercentage(1000, 900) + "%");
    }
}
