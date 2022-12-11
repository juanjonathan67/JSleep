package com.JuanJonathanJSleepRJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Algorithm Class -
 * Class used to perform basic algorithms to a specified list of objects.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Algorithm {
    private Algorithm(){
        ;
    }

    /**
     * Method to check the existance of the value parameter in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param value Value to be checked
     * @return Return true of the value exists in atleast one object in the array 
     */
    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    /**
     * Method to check the existance of the value parameter in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param value Value to be checked
     * @return Return true of the value exists in atleast one object in the array 
     */
    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    /**
     * Method to check the existance of the value parameter in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param value Value to be checked
     * @return Return true of the value exists in atleast one object in the array 
     */
    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    /**
     * Method to check the existance of the value parameter in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return true if the predicate is true in atleast one object in the array 
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    /**
     * Method to check the existance of the value parameter in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return true if the predicate is true in atleast one object in the array 
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    /**
     * Method to check the existance of the value parameter in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}}
     * @return Return true if the predicate is true in atleast one object in the array 
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current))
                return true;
        }
        return false;
    }

    /**
     * Method to count the objects which the value exists/predicate is true in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param value Value to be checked
     * @return Return the number of objects where the value exists
     */
    public static <T> int count(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    /**
     * Method to count the objects which the value exists/predicate is true in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param value Value to be checked
     * @return Return the number of objects where the value exists
     */
    public static <T> int count(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    /**
     * Method to count the objects which the value exists/predicate is true in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param value Value to be checked
     * @return Return the number of objects where the value exists
     */
    public static <T> int count(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    /**
     * Method to count the objects which the value exists/predicate is true in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the number of objects where the predicate is true
     */
    public static <T> int count(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    /**
     * Method to count the objects which the value exists/predicate is true in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the number of objects where the predicate is true
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    /**
     * Method to count the objects which the value exists/predicate is true in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the number of objects where the predicate is true
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int count = 0;
        while(iterator.hasNext()){
            if(pred.predicate(iterator.next()))
                count++;
        }
        return count;
    }

    /**
     * Method to find the object which the value exists/predicate is true in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param value Value to be checked
     * @return Return the object which the value is found
     */
    public static <T> T find(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    /**
     * Method to find the object which the value exists/predicate is true in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param value Value to be checked
     * @return Return the object which the value is found
     */
    public static <T> T find(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    /**
     * Method to find the object which the value exists/predicate is true in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param value Value to be checked
     * @return Return the object which the value is found
     */
    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    /**
     * Method to find the object which the value exists/predicate is true in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the object which the predicate is true
     */
    public static <T> T find(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    /**
     * Method to find the object which the value exists/predicate is true in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the object which the predicate is true
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    /**
     * Method to find the object which the value exists/predicate is true in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the object which the predicate is true
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current))
                return current;
        }
        return null;
    }

    /**
     * Method to get Objects where the value exists/predicate is true in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param value Value to be checked
     * @return Return the List filled with objects where the value exists
     */
    public static <T> List<T> collect(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    /**
     * Method to get Objects where the value exists/predicate is true in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param value Value to be checked
     * @return Return the List filled with objects where the value exists
     */
    public static <T> List<T> collect(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    /**
     * Method to get Objects where the value exists/predicate is true in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param value Value to be checked
     * @return Return the List filled with objects where the value exists
     */
    public static <T> List<T> collect(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    /**
     * Method to get Objects where the value exists/predicate is true in the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the List filled with objects where the predicate is true
     */
    public static <T> List<T> collect(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    /**
     * Method to get Objects where the value exists/predicate is true in the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the List filled with objects where the predicate is true
     */
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    /**
     * Method to get Objects where the value exists/predicate is true in the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the List filled with objects where the predicate is true
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
        List<T> lst = new ArrayList<T>();
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current))
                lst.add(current);
        }
        return lst;
    }

    /**
     * Method to paginate Objects based on page number and pageSize int the ArrayList
     * @param <T> Generic type
     * @param array Array of type ArrayList to be checked
     * @param page Page number (starts at 0)
     * @param pageSize Page size per page
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the List of the paginated objects where the predicate is true
     */
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return paginate(it, page, pageSize, pred);
    }

    /**
     * Method to paginate Objects based on page number and pageSize int the Iterable
     * @param <T> Generic type
     * @param iterable Array of type Iterable to be checked
     * @param page Page number (starts at 0)
     * @param pageSize Page size per page
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the List of the paginated objects where the predicate is true
     */
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }

    /**
     * Method to paginate Objects based on page number and pageSize int the Iterator
     * @param <T> Generic type
     * @param iterator Array of type Iterator to be checked
     * @param page Page number (starts at 0)
     * @param pageSize Page size per page
     * @param pred Predicate statement implemented from {@link com.JuanJonathanJSleepRJ.Predicate}
     * @return Return the List of the paginated objects where the predicate is true
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);
        // skip first occurrences of element
        while (iterator.hasNext() && occurences < startingIdx) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                ++occurences;
        }
        // get the next occurrences of element
        while (iterator.hasNext() && pageList.size() < pageSize) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                pageList.add(obj);
        }
        return pageList;
    }
}
