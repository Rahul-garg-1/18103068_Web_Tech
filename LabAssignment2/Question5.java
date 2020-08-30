package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void union(int[] arr1,int[] arr2,int n1,int n2){

        int[] mp = new int[11];
        Arrays.fill(mp, 0);
        System.out.print("Union of the two sets is: [");
        while(n1>0||n2>0){
            if(n1>0 && mp[arr1[n1-1]]==0){
                mp[arr1[n1-1]]++;
            }
            if(n2>0 && mp[arr2[n2-1]]==0){
                mp[arr2[n2-1]]++;
            }
            n1--;
            n2--;
        }
        for(int i=0;i<11;i++){
            if(mp[i] != 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("]");

    }

    public static void intersection(int[] arr1,int[] arr2,int n1,int n2){

        System.out.print("Intersection of the two sets is: [");
        int[] mp = new int[11];
        Arrays.fill(mp,0);
        for(int i=0;i<n1;i++)
            mp[arr1[i]]++;
        for(int i=0;i<n2;i++){
            if(mp[arr2[i]]>0) {
                mp[arr2[i]] = 0;
                System.out.print(arr2[i] + ", ");
            }
        }
        System.out.println("]");

    }

    public static void complement(int[] arr1, int[] arr2, int n1, int n2){

        System.out.print("Complement of set1 is: [");
        int[] mp = new int[11];
        Arrays.fill(mp,0);
        for(int i=0;i<n1;i++)
            mp[arr1[i]]++;
        for(int i=0;i<11;i++){
            if(mp[i]==0)
                System.out.print(i+ ", ");
        }
        System.out.println("]");

        System.out.print("Complement of set2 is: [");
        int[] mp1 = new int[11];
        Arrays.fill(mp1,0);
        for(int i=0;i<n2;i++)
            mp1[arr2[i]]++;
        for(int i=0;i<11;i++){
            if(mp1[i]==0)
                System.out.print(i+ ", ");
        }
        System.out.println("]");

    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("Universal set is: {0,1,2,3,4,5,6,7,8,9,10}");

        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();

        System.out.println("Enter size of array1: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of array1: ");
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
            while (arr1[i] < 0 || arr1[i] > 10) {
                System.out.println("Please enter a valid number between 0 and 10: ");
                arr1[i] = sc.nextInt();
            }
            s1.add(arr1[i]);
        }

        System.out.println("Enter size of array2: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter elements of array2: ");
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
            while (arr2[i] < 0 || arr2[i] > 10) {
                System.out.println("Please enter a valid number between 0 and 10 only: ");
                arr2[i] = sc.nextInt();
            }
            s2.add(arr2[i]);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        long start = System.nanoTime();
        System.out.println("\n");
        System.out.println("Using arrays: ");

        union(arr1,arr2,n1,n2);
        intersection(arr1,arr2,n1,n2);
        complement(arr1,arr2,n1,n2);

        System.out.println();
        long end = System.nanoTime();
        long elapsed = (end-start);
        System.out.println("Execution time in case of arrays is: "+elapsed+"ns");

        start = System.nanoTime();
        System.out.println("\n");
        System.out.println("Using Sets: ");

        Set<Integer> union1 = new HashSet<Integer>(s1);
        union1.addAll(s2);
        System.out.print("Union of the two sets is: ");
        System.out.println(union1);


        Set<Integer> intersection1= new HashSet<Integer>(s1);
        intersection1.retainAll(s2);
        System.out.print("Intersection of the two sets is: ");
        System.out.println(intersection1);


        Set<Integer> universal = new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        universal.removeAll(s1);
        System.out.print("Complement of set1: ");
        System.out.println(universal);

        universal.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        universal.removeAll(s2);
        System.out.print("Complement of set2: ");
        System.out.println(universal);

        end = System.nanoTime();
        elapsed = end-start;
        System.out.println();
        System.out.println("Execution time in case of sets is: "+elapsed + "ns");
    }
}
