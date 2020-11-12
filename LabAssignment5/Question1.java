package com.company;

public class Main extends Thread{

    public void run() {

        for(int i = 1; i <= 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
                if( i%10 == 0) {
                    System.out.println("Printing string after every ten number counting.");
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Main countNumbers = new Main();
        countNumbers.start();
    }
}
