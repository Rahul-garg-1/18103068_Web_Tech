package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the paragraph: ");
        String str = sc.nextLine();

        System.out.println("Enter the count of words you want to replace from the paragraph: ");
        int n = sc.nextInt();
        Vector<String> v = new Vector<String>();
        System.out.println("Enter the words you want to replace: ");
        for(int i=0;i<n;i++){
            v.add(sc.next());
        }

        String replacedString = str;
        for (String s : v) {
            StringBuilder replace = new StringBuilder();
            replace.append("*".repeat(Math.max(0, s.length() - 1)));
            replace.insert(0, s.charAt(0));
            replacedString = replacedString.replace(s, replace.toString());
        }

        System.out.println("The replaced paragraph is: ");
        System.out.println(replacedString);

    }
}
