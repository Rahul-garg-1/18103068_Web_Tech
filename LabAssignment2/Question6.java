package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Every hailstone sequence eventually settles on the 4, 2, 1 cycle, no matter what starting value you use.
//        Experiments certainly suggest that they all do. Computers have checked all starting values up to 5 x 2^60,
//        a number that is 19 digits long, and found that the 4, 2, 1 cycle eventually appears. Nobody is still able to
//        prove that this is the case for all sequences. This sequence is also known as the Collatz conjecture.
//        Therefore it is obvious from above that every sequence would hence terminate so the loop would not run
//        infinitely and no check is required.

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        long n = sc.nextLong();
        System.out.print("The hailstone sequence is: " + n );
        if(n != 1)
            System.out.print(", ");
        while(n > 1) {
            if((n&1) == 0)
                n /= 2;
            else
                n = n*3 + 1;
            if(n == 1)
                System.out.print(n);
            else
                System.out.print(n + ", ");
        }
    }
}