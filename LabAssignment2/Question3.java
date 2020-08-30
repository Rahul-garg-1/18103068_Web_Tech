package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string to be sorted: ");
        String s = sc.nextLine();

        char[] arr = s.toCharArray();
        for(int i=0; i < arr.length; i++) {
            for(int j=i+1; j < arr.length; j++) {
                if((int)arr[j] < (int)arr[i]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        s = new String(arr);
        System.out.println("The sorted string is: " + s);
    }
}
