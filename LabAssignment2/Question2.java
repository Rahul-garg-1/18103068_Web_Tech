package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] buckets = new int[21];
        Arrays.fill(buckets, 0);

        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int [] elements = new int[n];
        System.out.println("Enter the elements in range (0-20) only: ");

        for(int i=0;i<n;i++) {
            elements[i] = sc.nextInt();
            while(elements[i]<0 || elements[i]>20){
                System.out.println("Please enter a valid number between 0 and 20 only: ");
                elements[i] = sc.nextInt();
            }
            buckets[elements[i]]++;
        }

        int j=0;
        for(int i=0;i<21;i++) {
            while(buckets[i]-- >0)
                elements[j++] = i;
        }

        System.out.println("The resultant sorted array is: ");
        for(int i=0;i<n;i++)
            System.out.print(elements[i]+" ");

    }
}
