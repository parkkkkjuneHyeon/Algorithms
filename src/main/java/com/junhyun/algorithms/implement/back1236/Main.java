package com.junhyun.algorithms.implement.back1236;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back1236/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] board = br.readLine().split(" ");
        int N = Integer.parseInt(board[0]);
        int M = Integer.parseInt(board[1]);
        boolean[] width = new boolean[N];
        boolean[] height = new boolean[M];
        String[][] castle = new String[N][M];
        for(int i = 0; i < N; i++)
            castle[i] = br.readLine().split("");

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(castle[i][j].equals("X")) {
                    width[i] = true;
                    height[j] = true;
                }
            }
        }
        int needWidth = 0;
        int needHeight = 0;
        for(int i = 0; i < N; i++)
            if(!width[i]) needWidth++;
        for(int i = 0; i < M; i++)
            if(!height[i]) needHeight++;

        System.out.println(Math.max(needWidth, needHeight));
        br.close();
    }
}
