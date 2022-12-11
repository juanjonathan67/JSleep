package com.JuanJonathanJSleepRJ;

/**
 * Threading Object Class - 
 * Class to handle threads
 * @deprecated
 * @author juanjonathan67
 * @version 1.0.0
 */
@Deprecated
public class ThreadingObject extends Thread{
    public ThreadingObject(String name) {
        super(name);
        start();
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}
