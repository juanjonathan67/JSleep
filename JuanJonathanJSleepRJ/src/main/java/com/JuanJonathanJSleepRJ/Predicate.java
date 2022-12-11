package com.JuanJonathanJSleepRJ;

/**
 * Predicate Interface - Contains abstract method of predicate statement.
 * @author  juanjonathan67
 * @version 1.0.0
 */
public interface Predicate<T> {
    /**
     * Abstract method of predicate statement.
     * @param arg Arguments of the implemented method
     * @return Returns boolean of the predicate statement
     */
    public abstract boolean predicate(T arg);
}