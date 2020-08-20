package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static final int INF = 1000000;

    public static class NegativeWeightCycleException extends RuntimeException {
        @Override
        public String toString() {
            return ("Negative Cycle exist in the graph");
        }
    }

    public static int[][] allPairShortestPath(int[][] distanceMatrix, int s, int e, int n) {

        int[][] distance = new int[n][n];
        int[][] path = new int[n][n];

        for (int i=0; i < n; i++) {
            for (int j=0; j< n; j++){
                distance[i][j] = distanceMatrix[i][j];
                if (distanceMatrix[i][j] != INF && i != j) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }

        for(int k=0; k < n; k++){
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                    if(distance[i][k] == INF || distance[k][j] == INF) {
                        continue;
                    }
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < distance.length; i++) {
            if(distance[i][i] < 0) {
                throw new NegativeWeightCycleException();
            }
        }

        printPath(path, s, e);
        return distance;
    }

    public static void printPath(int[][] path, int start, int end) {
        if(start < 0 || end < 0 || start >= path.length || end >= path.length) {
            throw new IllegalArgumentException();
        }
        int src = start;
        int des = end;

        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(end);
        do {
            end = path[start][end];
            if (end == -1) {
                System.out.println("No path exists between " + src + " to " + des);
                System.out.println();
                return;
            }
            stack.addFirst(end);
        } while (end != start);

        System.out.println("The actual path between " + src + " to " + des + " is:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pollFirst());
            if(stack.size()!=1){
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args){

        System.out.println("Enter the no of vertices: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                graph[i][j]=INF;
            }
        }

        for(int i=0; i < n; i++){
            graph[i][i] = 0;
        }

        System.out.println("Enter the no of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter the starting and ending vertices with respective weights: ");
        for(int i=0; i < edges; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            graph[x][y] = w;
        }

        System.out.println("Enter the starting and ending vertex for shortest path: ");
        int src = sc.nextInt();
        int end = sc.nextInt();
        int[][] distance = allPairShortestPath(graph,src,end,n);
        System.out.println("The minimum Distance matrix is: ");
        for (int[] ints : distance) {
            for (int j = 0; j < distance.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }

    }
}
