package com.hexmeet.Utility;

public class Pause {
    public static void sleep(int second){
        try{
            Thread.sleep(1000 * second);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
