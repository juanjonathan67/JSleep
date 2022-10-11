package JuanJonathanJSleepRJ;

import java.util.HashMap;

public class Serializable
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

    public boolean equals(Object ob){
        if(ob instanceof Serializable){
            Serializable temp = (Serializable) ob;
            if(Integer.valueOf(this.id).compareTo(temp.id) == 0){
                return true;
            }
        }
        return false;
    }

    public boolean equals(Serializable ser){
        if(Integer.valueOf(this.id).compareTo(ser.id) == 0){
            return true;
        }
        return false;
    }

    public int compareTo(Serializable ser){
        return Integer.valueOf(this.id).compareTo(Integer.valueOf(ser.id));
    }

    public static <T> Integer setClosingID(Class<T> cl, int id){
        Integer temp = mapCounter.get(cl);
        mapCounter.put(cl, id);
        return temp;
    }

    public static <T> Integer getClosingID(Class<T> cl){
        if(mapCounter.containsKey(cl)){
            return mapCounter.get(cl);
        }
        return 0;
    }
}
