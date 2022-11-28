package com.vasili_zlobin.lesson5;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    private static final CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
    private static final CountDownLatch latchStart = new CountDownLatch(CARS_COUNT);
    private static final CountDownLatch latchFinish = new CountDownLatch(CARS_COUNT);
    private static boolean hasWinner = false;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        latchStart.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        latchFinish.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static CountDownLatch getLatchStart() {
        return latchStart;
    }

    public static CyclicBarrier getBarrier() {
        return barrier;
    }

    public static CountDownLatch getLatchFinish() {
        return latchFinish;
    }

    public static synchronized void checkWinner(String name) {
         if (!hasWinner) {
             hasWinner = true;
             System.out.printf("%s - ПОБЕДИТЕЛЬ!!!%n", name);
         }
    }
}
