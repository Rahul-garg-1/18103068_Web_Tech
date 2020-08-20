package com.company;

import java.util.Scanner;

public class Main {

    public static boolean areZeroes(int[] count) {
        for(int i=0;i<256;i++) {
            if(count[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1;
        String s2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the parent string: ");
        s1 = sc.next();
        System.out.println("Enter the substring to compare: ");
        s2 = sc.next();

        int m = s1.length();
        int n = s2.length();
        int[] count = new int[256];

        int num = 0;
        if(s1.length()>=s2.length()) {
            for (int i = 0; i < n; i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }

            if (areZeroes(count))
                num++;

            for (int i = n; i < m; i++) {
                count[s1.charAt(i - n) - 'a']--;
                count[s1.charAt(i) - 'a']++;
                if (areZeroes(count))
                    num++;
            }
        }
        System.out.println("The count of the substring occurrences are: "+ num);

    }
}
