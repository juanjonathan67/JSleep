package JuanJonathanJSleepRJ;

/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    public float discountPercentage;
    public int discountedPrice;
    public int totalPrice;
    public int originalPrice;

    public JSleep(){
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

    public int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return (int)(price - price);
        }else{
            return (int)(price - price * discountPercentage / 100);
        }
    }

    public int getOriginalPrice(int discountedPrice, float discountPercentage){
        if(discountPercentage > 100){
            return (int)(discountedPrice + discountedPrice);
        }else{
            return (int)(discountedPrice * ((discountPercentage / 100) + 1));
        }
    }

    public float getAdminFeePercentage(){
        return 0.05f;
    }

    public int getAdminFee(int price){
        return (int)(price * this.getAdminFeePercentage());
    }

    public int getTotalPrice(int price, int numberOfNight){
        this.totalPrice = price * numberOfNight;
        this.totalPrice += this.getAdminFee(this.totalPrice);
        return this.totalPrice;
    }

    public static void main(String[] args) {
        JSleep js = new JSleep();
        System.out.println("Hotel ID : " + js.getHotelID());
        System.out.println("Hotel name : " + js.getHotelName());
        System.out.println("Discount? : " + js.isDiscount());
        js.discountPercentage = js.getDiscountPercentage(1000, 900);
        System.out.println("Discount % : " + js.discountPercentage + "%");
        js.discountedPrice = js.getDiscountedPrice(5000, js.discountPercentage);
        System.out.println("Discounted Price : " + js.discountedPrice);
        js.originalPrice = js.getOriginalPrice(js.discountedPrice, js.discountPercentage);
        System.out.println("Original Price : " + js.originalPrice);
        System.out.println("Admin Fee % : " + js.getAdminFeePercentage() + "%");
        System.out.println("Admin Fee : " + js.getAdminFee(5000));
        System.out.println("Total Fee : " + js.getTotalPrice(5000, 2));
    }
}
