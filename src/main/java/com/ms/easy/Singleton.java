package com.ms.easy;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static volatile Singleton instance;

    private Singleton(){
        if (instance != null){
            throw new RuntimeException("Instance already exists");
        }
    }

    protected Object readResolve(){
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static Singleton getInstance() {
        if (instance == null){
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
