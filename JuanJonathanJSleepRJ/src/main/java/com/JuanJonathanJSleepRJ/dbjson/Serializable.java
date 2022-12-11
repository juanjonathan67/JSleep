package com.JuanJonathanJSleepRJ.dbjson;

import java.util.HashMap;

/**
 * Serializable Class -
 * Class used to serialize Object
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Serializable implements Comparable<Serializable>
{
    /**
     * Id of object
     */
    public final int id;
    /**
     * Hashmap store a class and it's id
     */
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>(); 
    
    /**
     * Constructor for giving an object's id
     */
    protected Serializable(){
        Integer serial = mapCounter.get(this.getClass());
        if(serial == null){
            serial = 0;
        }else{
            serial++;
        }
        mapCounter.put(this.getClass(), serial);
        this.id = serial;
    }

    /**
     * Check if there is any duplicate objects
     * @param other Object to be checked
     * @return Return boolean if a duplicate Object exists
     */
    public boolean equals(Object other){
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    /**
     * Check if there is any duplicate objects
     * @param other {@link com.JuanJonathanJSleepRJ.dbjson.Serializable} to be checked
     * @return Return boolean if a duplicate exists
     */
    public boolean equals(Serializable other){
        return other.id == id;
    }

    /**
     * Compare 2 serialized id
     * @param other {@link com.JuanJonathanJSleepRJ.dbjson.Serializable} to be checked
     * @return Return the compare results
     */
    public int compareTo(Serializable other){
        return Integer.compare(this.id, other.id);
    }


    /**
     * Method to set HashMap key and values
     * @param <T> Generic type
     * @param cl Class of HashMap key
     * @param id Id of HashMap value
     * @return Return value of HashMap
     */
    public static <T> Integer setClosingID(Class<T> cl, int id){
        return mapCounter.put(cl, id);
    }

    /**
     * Method to get HashMap value of a certain key
     * @param <T> Generic type
     * @param cl Class of HashMap key
     * @return Return value of HashMap
     */
    public static <T> Integer getClosingID(Class<T> cl){
        return mapCounter.get(cl);
    }
}
