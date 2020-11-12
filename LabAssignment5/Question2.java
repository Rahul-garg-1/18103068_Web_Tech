package com.company;

public class Main extends Thread {

    static int maxDivisorCount = 0;
    static int resWithMaxDivisorCount = 0;        
    int start;
    
    Main(int start) {
        this.start = start;
    }
    
    public void run() {
        int maxDivisors;
        System.out.println(this + " testing range " + start + " to " + (this.start+10000-1));
        for(int i = start; i < this.start+10000; i++) {
            maxDivisors = 0;
            for(int j = 1; j <= i; j++) {
                if (i%j == 0) {
                    maxDivisors++;
                }
            }
            if(maxDivisors > maxDivisorCount) {

                synchronized(this) {
                    maxDivisorCount = maxDivisors;
                    resWithMaxDivisorCount = i;
                }
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        Main thread1 = new Main(1);
        Main thread2 = new Main(10001);
        Main thread3 = new Main(20001);
        Main thread4 = new Main(30001);
        Main thread5 = new Main(40001);
        Main thread6 = new Main(50001);
        Main thread7 = new Main(60001);
        Main thread8 = new Main(70001);
        Main thread9 = new Main(80001);
        Main thread10 = new Main(90001);
        long startingTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        long endingTime = System.currentTimeMillis();
        System.out.println("\nThe largest number of divisors for numbers between 1 and 100000 is " + maxDivisorCount);
        System.out.println("An integer with that max divisors is " + resWithMaxDivisorCount);
        System.out.println("Total time elapsed: " + (endingTime - startingTime) + " milliseconds.");
    }
}