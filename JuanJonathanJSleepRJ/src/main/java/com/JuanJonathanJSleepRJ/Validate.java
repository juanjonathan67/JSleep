package com.JuanJonathanJSleepRJ;

import java.util.ArrayList;

/**
 * Validate Class -
 * Contains method to filter price
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Validate
{
    /**
     * Method for filtering ArrayList of price
     * @param list ArrayList of price
     * @param value Value to be filtered
     * @param less Boolean to filter more or less
     * @return Returns ArrayList of filtered price
     */
    public static ArrayList filter (Price[] list, int value, boolean less){
        ArrayList<Double> filteredPrice = new ArrayList<>();
        if(less == true) {
            for (Price iterator : list) {
                if(iterator.price <= value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        else{
            for (Price iterator : list) {
                if(iterator.price > value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        return filteredPrice;
    }
}
