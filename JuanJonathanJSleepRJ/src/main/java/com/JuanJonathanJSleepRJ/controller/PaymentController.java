package com.JuanJonathanJSleepRJ.controller;

import com.JuanJonathanJSleepRJ.dbjson.JsonAutowired;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.text.*;

import org.springframework.web.bind.annotation.*;

import com.JuanJonathanJSleepRJ.*;
import com.JuanJonathanJSleepRJ.Invoice.PaymentStatus;
import com.JuanJonathanJSleepRJ.dbjson.*;

/**
 * Payment Controller Class -
 * Contains methods related to Payment, such as create, accept, cancel, etc.
 * @author juanjonathan67
 * @version 1.0.0
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{

    /**
	 * {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} filled with all available {@link com.JuanJonathanJSleepRJ.Payment}
	 */
    @JsonAutowired(value = Payment.class, filepath = "json/payment.json")
    public static JsonTable<Payment> paymentTable;

    /**
	 * Implementation of {@link com.JuanJonathanJSleepRJ.controller.BasicGetController#getJsonTable()}
	 * @return Return {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} of {@link com.JuanJonathanJSleepRJ.Payment}
	 */
    @Override
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    
    /**
     * Method used to create a new {@link com.JuanJonathanJSleepRJ.Payment}
     * @param buyerId The room's buyer Id
     * @param renterId The room's renter Id
     * @param roomId The room's Id
     * @param from Start date of the room's booking
     * @param to End date of the room's booking
     * @return Returns {@link com.JuanJonathanJSleepRJ.Payment} if it is successfully created
     */
    @PostMapping("/create")
    public Payment create(
        @RequestParam int buyerId,
        @RequestParam int renterId,
        @RequestParam int roomId,
        @RequestParam String from,
        @RequestParam String to
    ){
        Account foundacc = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
        Room foundroom = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromDate = sdf.parse(from);
            Date toDate = sdf.parse(to);
            long duration = toDate.getTime() - fromDate.getTime();
            double totalPrice = foundroom.price.price * (TimeUnit.MILLISECONDS.toDays(duration));
            if(foundacc != null && foundroom != null && totalPrice <= foundacc.balance && Invoice.availability(fromDate, toDate, foundroom)){
                Payment pay = new Payment(buyerId, renterId, roomId);
                foundacc.balance -= totalPrice;
                pay.status = PaymentStatus.WAITING;
                Invoice.makeBooking(fromDate, toDate, foundroom);
                paymentTable.add(pay);
                return pay;
            }else{
                return null;
            }
        } catch (ParseException p) {
            p.printStackTrace();
        }
        return null;
    }

    /**
     * Method used to accept a {@link com.JuanJonathanJSleepRJ.Payment}
     * @param id Id of payment to be accepted
     * @return Returns true if {@link com.JuanJonathanJSleepRJ.Payment} is successfully accepted
     */
    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id){
        Payment paymentFound = Algorithm.<Payment>find(paymentTable, payment -> payment.id == id);
        if (paymentFound != null && paymentFound.status == Invoice.PaymentStatus.WAITING) {
            paymentFound.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Method used to cancel a {@link com.JuanJonathanJSleepRJ.Payment}
     * @param id Id of payment to be cancelled
     * @return Returns true if {@link com.JuanJonathanJSleepRJ.Payment} is successfully cancelled
     */
    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id){
        
        Payment paymentFound = Algorithm.<Payment>find(paymentTable, payment -> payment.id == id);
        Account accountFound = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == paymentFound.buyerId);
        Room roomFound = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == paymentFound.getRoomId());
        
        if (paymentFound != null && paymentFound.status == Invoice.PaymentStatus.WAITING) {
            paymentFound.status = Invoice.PaymentStatus.FAILED;
            accountFound.balance += roomFound.price.price;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method used to submit a {@link com.JuanJonathanJSleepRJ.Payment}
     * @param id Id of payment to be cancelled
     * @return Returns true if {@link com.JuanJonathanJSleepRJ.Payment} is successfully submitted
     */
    @PostMapping("/{id}/submit")
    public boolean submit(
        @RequestParam int id
    ){
        return false;
    }

    /**
     * Method to get all available {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable}
     * @return Return List of {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable}
     */
    @GetMapping("/getAllPayment")
    List<Payment> getAllPayment(){
        return Algorithm.<Payment>collect(paymentTable, pred -> true);
    }

    /**
     * Method to get all available {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable} which was booked by the account specified that has not been completed
     * @param id Id of the buyer/booker
     * @return Return List of {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable} which was booked by the account specified that has not been completed
     */
    @GetMapping("/{id}/getBookingPayment")
    List<Payment> getBookingPayment(@PathVariable int id){
        return Algorithm.<Payment>collect(paymentTable, payment -> payment.buyerId == id && 
        payment.status == PaymentStatus.WAITING);
    }

    /**
     * Method to get all available {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable} which was rented by the account specified that has not been completed
     * @param id Id of the renter
     * @return Return List of {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable} which was rented by the account specified that has not been completed
     */
    @GetMapping("/{id}/getRentingPayment")
    List<Payment> getRentingPayment(@PathVariable int id){
        return Algorithm.<Payment>collect(paymentTable, payment -> payment.renterId == id && 
        payment.status == PaymentStatus.WAITING);
    }

    /**
     * Method to get all available {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable} that has been completed
     * @param id Id of the account
     * @return Return List of {@link com.JuanJonathanJSleepRJ.Payment} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable} that has been completed
     */
    @GetMapping("/{id}/getCompletedPayment")
    List<Payment> getCompletedPayment(@PathVariable int id){
        return Algorithm.<Payment>collect(paymentTable, payment -> 
        (payment.renterId == id || payment.buyerId == id) && 
        (payment.status == PaymentStatus.SUCCESS || payment.status == PaymentStatus.FAILED));
    }
}
