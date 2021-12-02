package com.dazzler.rxjava;

public class Main1 {
    public static void main(String[] args) {
        Thread thread = new Thread( Main1::runit    //We can do this when there is a signature match of the two methods.
                                                    //Since Runnable interface's run method and runit both return void
                                                    //We can thus directly use method reference
        );
    }
    public static void runit(){

    }
}
