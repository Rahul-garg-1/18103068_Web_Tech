package com.company;

public class Main {

    public static void main(String[] args) {

        int sum = 0;
        int ans = 1;
        for(int i=1;i<Integer.MAX_VALUE;i++) {
            sum += i;
            if(sum == i*i){
                ans = Math.max(ans , i);
            }
        }
        System.out.println("Answer is: " + ans);
    }
}
