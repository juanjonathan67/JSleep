package com.JuanJonathanJSleepRJ.dbjson;

import java.util.HashMap;

public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>(); 
    
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

    public boolean equals(Object other){
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other){
        return other.id == id;
    }

    public int compareTo(Serializable other){
        return Integer.compare(this.id, other.id);
    }

    public static <T> Integer setClosingID(Class<T> cl, int id){
        return mapCounter.put(cl, id);
    }

    public static <T> Integer getClosingID(Class<T> cl){
        return mapCounter.get(cl);
    }
}
