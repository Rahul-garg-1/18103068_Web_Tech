package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question1 {

    public static int replant(char[][] crops_matrix, int current_row, int current_column, int n, int m, int current_cost, int min_cost, String crop_varieties) {

        Set<Character> upLeft = new HashSet<>();
        if(current_row != 0){
            upLeft.add(crops_matrix[current_row-1][current_column]);
        }
        if(current_column != 0){
            upLeft.add(crops_matrix[current_row][current_column-1]);
        }

        Set<Character> downRight = new HashSet<>();
        if(current_row!=n-1){
            downRight.add(crops_matrix[current_row+1][current_column]);
        }
        if(current_column!=m-1){
            downRight.add(crops_matrix[current_row][current_column+1]);
        }

        boolean present_left_up = false;
        if(upLeft.contains(crops_matrix[current_row][current_column])) {
            present_left_up = true;
        }

        char[][] new_crops_matrix = new char[n][m];
        if(downRight.contains(crops_matrix[current_row][current_column])) {

            if(present_left_up){

                for(int k=0; k<26; k++) {
                    if(!upLeft.contains(crop_varieties.charAt(k)) && !downRight.contains(crop_varieties.charAt(k))) {
                        for(int i=0; i<n; i++) {
                            if (m >= 0) System.arraycopy(crops_matrix[i], 0, new_crops_matrix[i], 0, m);
                        }
                        new_crops_matrix[current_row][current_column] = crop_varieties.charAt(k);

                        if(current_column<m-1) {
                            min_cost = Math.min(min_cost, replant(new_crops_matrix, current_row, current_column+1, n, m, current_cost+1, min_cost, crop_varieties));
                        }
                        else if(current_row<n-1) {
                            min_cost = Math.min(min_cost, replant(new_crops_matrix, current_row+1, 0, n, m, current_cost+1, min_cost, crop_varieties));
                        }
                        else {
                            return Math.min(current_cost+1, min_cost);
                        }
                        break;
                    }
                }
            }
            else{

                if(current_column<m-1){
                    min_cost = Math.min(min_cost, replant(crops_matrix, current_row, current_column+1, n, m, current_cost, min_cost, crop_varieties));
                }
                else if(current_row<n-1) {
                    min_cost = Math.min(min_cost, replant(crops_matrix, current_row+1, 0, n, m, current_cost, min_cost, crop_varieties));
                }
                else {
                    return Math.min(current_cost, min_cost);
                }
                for(int k=0; k<26;k++){
                    if(!upLeft.contains(crop_varieties.charAt(k)) && !downRight.contains(crop_varieties.charAt(k))){
                        for(int i=0; i<n; i++) {
                            if (m >= 0) System.arraycopy(crops_matrix[i], 0, new_crops_matrix[i], 0, m);
                        }
                        new_crops_matrix[current_row][current_column] = crop_varieties.charAt(k);
                        if(current_column<m-1) {
                            min_cost = Math.min(min_cost, replant(new_crops_matrix, current_row, current_column+1, n, m, current_cost+1, min_cost, crop_varieties));
                        }
                        else if(current_row<n-1) {
                            min_cost = Math.min(min_cost, replant(new_crops_matrix, current_row+1, 0, n, m, current_cost+1, min_cost, crop_varieties));
                        }
                        else {
                            return Math.min(current_cost+1, min_cost);
                        }
                        break;
                    }
                }

            }
        }
        else{

            if(present_left_up) {

                for(int k=0; k<26;k++){
                    if(!upLeft.contains(crop_varieties.charAt(k)) && !downRight.contains(crop_varieties.charAt(k))){
                        for(int i=0; i<n; i++){
                            if (m >= 0) System.arraycopy(crops_matrix[i], 0, new_crops_matrix[i], 0, m);
                        }
                        new_crops_matrix[current_row][current_column] = crop_varieties.charAt(k);

                        if(current_column<m-1){
                            min_cost = Math.min(min_cost, replant(new_crops_matrix, current_row, current_column+1, n, m, current_cost+1, min_cost, crop_varieties));
                        }
                        else if(current_row<n-1){
                            min_cost = Math.min(min_cost, replant(new_crops_matrix, current_row+1, 0, n, m, current_cost+1, min_cost, crop_varieties));
                        }
                        else{
                            return Math.min(current_cost+1, min_cost);
                        }
                        break;
                    }
                }
            }
            else {

                if(current_column<m-1) {
                    min_cost = Math.min(min_cost, replant(crops_matrix, current_row, current_column+1, n, m, current_cost, min_cost, crop_varieties));
                }
                else if(current_row<n-1) {
                    min_cost = Math.min(min_cost, replant(crops_matrix, current_row+1, 0, n, m, current_cost, min_cost, crop_varieties));
                }
                else {
                    return Math.min(current_cost, min_cost);
                }
            }
        }
        return min_cost;
    }

    public static void main(String[] args){

        int n, m;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dimensions of the farm: ");
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();

        System.out.println("Enter the crop varieties planted in the farm: ");
        String[] crops = new String[n];
        for (int i=0;i<n;i++) {
            crops[i] = in.nextLine().trim();
        }

        char[][] crops_matrix = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++) {
                crops_matrix[i][j] = crops[i].charAt(j);
            }
        }

        String crop_varieties = "abcdefghijklmnopqrstuvwxyz";

        System.out.print("The minimum number of plots to be replanted are: ");
        System.out.println(replant(crops_matrix, 0, 0, n, m, 0, n*m, crop_varieties));
    }
}
