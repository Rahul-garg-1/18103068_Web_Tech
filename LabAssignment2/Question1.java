package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        According to unicode system in Java, This is a dictionary order,
//        in which the characters are compared,
//        A < B < C < ... Y < Z < a < b < ... y < z

        Scanner sc = new Scanner(System.in);
        String s1;
        String s2;
        System.out.println("Enter string 1: ");
        s1 = sc.nextLine();
        System.out.println("Enter string 2: ");
        s2 = sc.nextLine();

        int i;
        boolean flag = false;
        for(i=0;i<s1.length();++i) {
            if( i==s2.length() || (int)s1.charAt(i)>(int)s2.charAt(i) ) {
                System.out.println("string 1 is greater than string 2");
                flag = true;
                break;
            }
            else if((int)s1.charAt(i)==(int)s2.charAt(i))
                continue;
            else {
                System.out.println("string 1 is lesser than string 2");
                flag = true;
                break;
            }
        }

        if(i <= s2.length() && !flag) {
            if(s1.length()==s2.length())
                System.out.println("string 1 is equal to string 2");
            else
                System.out.println("string 1 is lesser than string 2");
        }

    }
}
