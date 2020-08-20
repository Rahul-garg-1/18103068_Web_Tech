package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean Anagrams(char[] s1, char[] s2){

        int[] count = new int[256];
        Arrays.fill(count , 0);
        int i;
        for (i = 0; i < Math.min(s1.length ,s2.length); i++) {
            count[s1[i]]++;
            count[s2[i]]--;
        }
        if (s1.length != s2.length)
            return false;

        for (i = 0; i < 256; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1;
        String s2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        s1 = sc.next();
        System.out.println("Enter the second string: ");
        s2 = sc.next();

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        if(Anagrams(a,b)){
           System.out.println("The given two strings are anagrams of each other");
        }
        else{
            System.out.println("The given two strings are not anagrams of each other");
        }
    }
}
