package com.JuanJonathanJSleepRJ.controller;

import com.JuanJonathanJSleepRJ.dbjson.JsonAutowired;

import java.util.Date;
import java.text.*;

import javax.xml.crypto.Data;

import org.springframework.web.bind.annotation.*;

import com.JuanJonathanJSleepRJ.*;
import com.JuanJonathanJSleepRJ.Invoice.PaymentStatus;
import com.JuanJonathanJSleepRJ.dbjson.*;

@RestController

@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value = Payment.class, filepath = "json/payment.json")
    public static JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

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
            if(foundacc != null && foundroom != null && foundroom.price.price <= foundacc.balance && Invoice.availability(fromDate, toDate, foundroom)){
                Payment pay = new Payment(buyerId, renterId, roomId);
                foundacc.balance -= foundroom.price.price;
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

    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id){
        Payment paymentFound = Algorithm.<Payment>find(paymentTable, payment -> payment.id == id);
        if (paymentFound != null && Invoice.PaymentStatus.WAITING.toString().equals("WAITING")) {
            paymentFound.status = Invoice.PaymentStatus.SUCCESS;

            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id){
        
        Payment paymentFound = Algorithm.<Payment>find(paymentTable,payment -> payment.id == id);
        Account accountFound = Algorithm.<Account>find(AccountController.accountTable,prod -> prod.id == paymentFound.buyerId);
        Room roomFound = Algorithm.<Room>find(RoomController.roomTable,pred -> pred.id == paymentFound.getRoomId());

        if (paymentFound != null && Invoice.PaymentStatus.WAITING.toString().equals("WAITING")) {
            paymentFound.status = Invoice.PaymentStatus.FAILED;
            accountFound.balance += roomFound.price.price;
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/{id}/submit")
    public boolean submit(
        @RequestParam int id
    ){
        return false;
    }
}
