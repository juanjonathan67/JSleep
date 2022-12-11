package com.JuanJonathanJSleepRJ;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

/**
 * Voucher Class -
 * Contains common voucher attributes.
 * Has basic method of checking the eligibility of voucher.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Voucher extends Serializable
{
    /**
     * {@link com.JuanJonathanJSleepRJ.Type} of voucher
     */
    public Type type;
    /**
     * How much the voucher will cut
     */
    public double cut;
    /**
     * Name of voucher
     */
    public String name;
    /**
     * Code of voucher
     */
    public int code;
    /**
     * Minimum price to be cut
     */
    public double minimum;
    /**
     * Boolean if the voucher is used
     */
    private boolean used;
    
    /**
     * Constructor to create a new voucher
     * @param name Name of voucher
     * @param code Code of voucher
     * @param type {@link com.JuanJonathanJSleepRJ.Type} of voucher
     * @param used Boolean if the voucher is used
     * @param minimum Minimum price to be cut
     * @param cut How much the voucher will cut
     */
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * Method to check if the voucher can be used
     * @param price {@link com.JuanJonathanJSleepRJ.Price} to be cut
     * @return Return boolean if the voucher can be used
     */
    public boolean canApply(Price price){
        if((price.price > this.minimum) && (this.used == false)){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Method to apply voucher to a price
     * @param price {@link com.JuanJonathanJSleepRJ.Price} to be cut
     * @return Return final price
     */
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

    /**
     * Getter method to get the voucher's status
     * @return Return boolean voucher's status
     */
    public boolean isUsed(){
        return this.used;
    }
}
