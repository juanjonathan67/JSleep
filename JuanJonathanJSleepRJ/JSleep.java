package JuanJonathanJSleepRJ;


public class JSleep
{
    public float discountPercentage;
    public int discountedPrice;
    public static int totalPrice;
    public int originalPrice;

    public JSleep(){
    }

    public static int getHotelID(){
        return 0;
    }

    public static String getHotelName(){
        return "Hotel";
    }

    public static boolean isDiscount(){
        return true;
    }

    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount < afterDiscount){
            return 0.0f;
        }else{
            if(beforeDiscount != 0){
                return ((1 - (float)(afterDiscount) / beforeDiscount)) * 100;
            }else{
                return 0.0f;
            }
        }
    }

    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            discountPercentage = 100;
        }
        return (int)(price - price * discountPercentage / 100);
    }

    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        if(discountPercentage >= 100){
            return 0;
        }
        return (int)(discountedPrice / ((100 - discountPercentage) / 100));
    }

    public static float getAdminFeePercentage(){
        return 0.05f;
    }

    public static int getAdminFee(int price){
        return (int)(price * getAdminFeePercentage());
    }

    public static int getTotalPrice(int price, int numberOfNight){
        totalPrice = price * numberOfNight;
        totalPrice += getAdminFee(totalPrice);
        return totalPrice;
    }

    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room("hotel", 30, price, Facility.AC);
        return room;
    }

    public static void main(String[] args) {
        JSleep js = new JSleep();
        Room test = js.createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
        // System.out.println(js.discountPercentage(5000, 3000));
        // System.out.println("Hotel ID : " + js.getHotelID());
        // System.out.println("Hotel name : " + js.getHotelName());
        // System.out.println("Discount? : " + js.isDiscount());
        // js.discountPercentage = js.getDiscountPercentage(0, 1);
        // System.out.println("Discount % : " + js.discountPercentage + "%");
        // js.discountedPrice = js.getDiscountedPrice(1000, 120.0f);
        // System.out.println("Discounted Price : " + js.discountedPrice);
        // js.originalPrice = js.getOriginalPrice(100, 100.0f);
        // System.out.println("Original Price : " + js.originalPrice);
        // System.out.println("Admin Fee % : " + js.getAdminFeePercentage() + "%");
        // System.out.println("Admin Fee : " + js.getAdminFee(10000));
        // System.out.println("Total Fee : " + js.getTotalPrice(0, 2));
    }
}
