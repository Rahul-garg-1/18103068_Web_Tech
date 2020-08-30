package com.company;

public class Main {

    public static class OverflowException extends RuntimeException{
        @Override
        public String toString() {
            return ("Overflow happened in multiplying");
        }
    }

    public static Boolean isOverflow(int a) {
        if (a == 0)
            return false;

        int result = a * a;
        return a != result / a;
    }
    public static void main(String[] args) {

        int sum = 0;
        int ans = 1;
        for(int i=1;i<Integer.MAX_VALUE;i++) {
            sum += i;
            if(isOverflow(i))
                throw new OverflowException();
            if(sum == i*i){
                ans = Math.max(ans , i);
            }
        }
        System.out.println("Answer is: " + ans);
    }
}
