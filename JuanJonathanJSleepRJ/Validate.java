package JuanJonathanJSleepRJ;

import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList result = new ArrayList(); 
        if(less){
            for(Price num : list){
                if(num.price <= value){
                    result.add(num.price);
                }
            }
        }else{
            for(Price num : list){
                if(num.price >= value){
                    result.add(num.price);
                }
            }
        }
        return result;
    }
}
