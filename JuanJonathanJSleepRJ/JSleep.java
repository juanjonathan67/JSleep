package JuanJonathanJSleepRJ;

import java.sql.Date;

public class JSleep
{
    // public static int getHotelID(){
    //     return 0;
    // }

    // public static String getHotelName(){
    //     return "hotel";
    // }

    // public static boolean isDiscount(){
    //     return true;
    // }

    // public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
    //     if(beforeDiscount < afterDiscount){
    //         return 0.0f;
    //     }else{
    //         if(beforeDiscount != 0){
    //             return ((1 - (float)(afterDiscount) / beforeDiscount)) * 100;
    //         }else{
    //             return 0.0f;
    //         }
    //     }
    // }

    // public static int getDiscountedPrice(int price, float discountPercentage){
    //     if(discountPercentage > 100){
    //         discountPercentage = 100;
    //     }
    //     return (int)(price - price * discountPercentage / 100);
    // }

    // public static int getOriginalPrice(int discountedPrice, float discountPercentage){
    //     if(discountPercentage >= 100){
    //         return 0;
    //     }
    //     return (int)(discountedPrice / ((100 - discountPercentage) / 100));
    // }

    // public static float getAdminFeePercentage(){
    //     return 0.05f;
    // }

    // public static int getAdminFee(int price){
    //     return (int)(price * getAdminFeePercentage());
    // }

    // public static int getTotalPrice(int price, int numberOfNight){
    //     return price * numberOfNight + getAdminFee(price * numberOfNight);
    // }
    
    
    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room(1, "hotel", 30, price, Facility.AC, City.BALI, "Bali Street");
        return room;
    }
    

    public static void main(String[] args) {
    	System.out.println("Hello from eclipse!");
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-13");
        Date end2 = Date.valueOf("2022-8-16");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        // Payment testPayment = new Payment(2, 2, 2,2);
        // System.out.println(testPayment.getTime());
        // System.out.println(testPayment.getDuration());
        // Price[] unfilteredArray = new Price[5];
        // for(int i=0;i < unfilteredArray.length;i++){
        // int j = 5000;
        // unfilteredArray[i] = new Price((i+1)*j);
        // } System.out.println("Price List");
        // for(int i=0;i < unfilteredArray.length;i++){
        // System.out.println(unfilteredArray[i].price);
        // } System.out.println("Below 12000.0");
        // System.out.println(Validate.filter(unfilteredArray, 12000,true));
        // System.out.println("Above 10000.0");
        // System.out.println(Validate.filter(unfilteredArray, 10000,false));
        // Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        // Price testPrice = new Price(100000, 20000);
        // Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
        // Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        // Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        // Rating testRating = new Rating();
        // System.out.println(testComplain.toString());
        // System.out.println(testRoom.toString());
        // System.out.println(testAccount.toString());
        // System.out.println(testPrice.toString());
        // System.out.println(testRating.toString());
        // Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        // Invoice testInvoice = new Invoice(2,2,2, "");
        // System.out.println(testRoom.print());
        // System.out.println(testInvoice.print());
        // Room test = createRoom();
        // System.out.println(test.name);
        // System.out.println(test.size);
        // System.out.println(test.price.price);
        // System.out.println(test.facility);
        // System.out.println("Hotel ID : " + JSleep.getHotelID());
        // System.out.println("Hotel name : " + JSleep.getHotelName());
        // System.out.println("Discount? : " + JSleep.isDiscount());
        // System.out.println("Discount % : " + JSleep.getDiscountPercentage(1000, 900) + "%");
        // System.out.println("Discounted Price : " + JSleep.getDiscountedPrice(1000, 20.0f));
        // System.out.println("Original Price : " + JSleep.getOriginalPrice(900, 10.0f));
        // System.out.println("Admin Fee % : " + JSleep.getAdminFeePercentage() + "%");
        // System.out.println("Admin Fee : " + JSleep.getAdminFee(10000));
        // System.out.println("Total Fee : " + JSleep.getTotalPrice(10000, 2));
    }
}
