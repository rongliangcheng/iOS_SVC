package com.hexmeet.Utility;

public class Pause {
    public static void stop(double second){
        try{
            Thread.sleep((long)(1000 * second));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
