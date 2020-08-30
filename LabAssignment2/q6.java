package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        long n = sc.nextLong();
        System.out.print("The hailstone sequence is: " + n + ", ");
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
