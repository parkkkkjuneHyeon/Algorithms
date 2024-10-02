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
        String[][] castle = new String[N][M];

        for(int i = 0; i < N; i++)
            castle[i] = br.readLine().split("");

        System.out.println(checkGuard(castle, N, M));
        br.close();
    }
    public static int checkGuard(String[][] castle, int width, int height) {
        int[] cnt = new int[2];
        int i = 0;
        int j = 0;
        while(i < width) {
            if(castle[i][j].equals("X")){
                i++;
                j = 0;
                continue;
            }else if(j == height-1) {
                cnt[0]++;
                i++;
                j = 0;
                continue;
            }
            j++;
        }
        i = 0;
        j = 0;
        while(i < height) {
            if(castle[j][i].equals("X")){
                i++;
                j = 0;
                continue;
            }else if(j == width-1) {
                cnt[1]++;
                i++;
                j = 0;
                continue;
            }
            j++;
        }

        return Math.max(cnt[0], cnt[1]);
    }
}
