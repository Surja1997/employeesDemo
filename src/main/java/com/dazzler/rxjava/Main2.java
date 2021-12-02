package com.dazzler.rxjava;


import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
//        createObservableWithJust();
        createObservableUsingCreate();
    }

    public static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        //To start data emission, we need to consume it also

        observable.subscribe(item -> System.out.println(item));

    }

    public static void createObservableFromIterable() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.fromIterable(list);
        //To start data emision, we need to sconsume it also
        observable.subscribe(item -> System.out.println(item));

    }

    public static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(emitter -> {

            //onNext will publish for the subscriber to consume
            //Since rxjava 2 we cannot push any null values to the onNext method
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onNext(null);  // This triggers the on error method

            // onComplete means that emission is now complete
            emitter.onComplete(); //subscriber can now expect onComplete

        });
        observable.subscribe(item -> System.out.println(item), //handling onNext
                error -> System.out.println("there was an error " + error.getLocalizedMessage()), //handling onError
                () -> System.out.println("Completed") //handling onComplete
        );
    }
}
