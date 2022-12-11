package com.JuanJonathanJSleepRJ.controller;

import org.springframework.web.bind.annotation.*;

import com.JuanJonathanJSleepRJ.dbjson.*;
import com.JuanJonathanJSleepRJ.*;

import java.util.List;

/**
 * Voucher Controller Class -
 * Contains methods related to Voucher, such as create, paginate, filter, etc.
 * @deprecated
 * @author juanjonathan67
 * @version 1.0.0
 */
@RestController
@Deprecated
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>{
    
    @JsonAutowired(value = Voucher.class, filepath = "/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(
        @PathVariable int id
    ){
        Voucher found = Algorithm.<Voucher>find(getJsonTable(), vouc -> vouc.id == id);
        return found.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
        @PathVariable int id,
        @RequestParam double price
    ){
        Voucher found = Algorithm.<Voucher>find(getJsonTable(), vouc -> vouc.id == id);
        return found.canApply(new Price(price));
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
        @RequestParam int page,
        @RequestParam int pageSize
    ){
        return Algorithm.<Voucher>paginate(voucherTable, page, pageSize, vouc -> vouc.isUsed() == false);
    }
}
