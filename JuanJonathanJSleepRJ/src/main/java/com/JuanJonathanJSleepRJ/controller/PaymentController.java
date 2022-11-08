package com.JuanJonathanJSleepRJ.controller;

import com.JuanJonathanJSleepRJ.dbjson.JsonAutowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JuanJonathanJSleepRJ.*;
import com.JuanJonathanJSleepRJ.dbjson.*;

public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value = Payment.class, filepath = "json/paymen.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/payment/create")
    public Payment create(
        @RequestParam int buyerId,
        @RequestParam int renterId,
        @RequestParam int roomId,
        @RequestParam String from,
        @RequestParam String to
    ){
        return null;
    }

    @PostMapping("/payment/{id}/accept")
    public boolean accept(
        @RequestParam int id
    ){
        return false;
    }

    @PostMapping("/payment/{id}/cancel")
    public boolean cancel(
        @RequestParam int id
    ){
        return false;
    }

    @PostMapping("/payment/{id}/submit")
    public boolean submit(
        @RequestParam int id
    ){
        return false;
    }
}
