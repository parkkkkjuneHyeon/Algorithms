package com.junhyun.algorithms.implement.back1730;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back1730/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] order = br.readLine().toCharArray();
        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizontal = new boolean[N][N];
        StringBuilder board = new StringBuilder();

        int r = 0;
        int c = 0;
        for(int i=0; i<order.length; i++) {
            if(order[i] == 'D') {
                if(r == N-1) continue;
                passVertical[r][c] = passVertical[r+1][c] = true;
                r++;
            }
            else if(order[i] == 'U') {
                if(r <= 0) continue;
                passVertical[r][c] = passVertical[r-1][c] = true;
                r--;
            }
            else if(order[i] == 'R') {
                if(c == N-1) continue;
                passHorizontal[r][c] = passHorizontal[r][c+1] = true;
                c++;
            }
            else if(order[i] == 'L') {
                if(c <= 0) continue;
                passHorizontal[r][c] = passHorizontal[r][c-1] = true;
                c--;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(passVertical[i][j] && passHorizontal[i][j]) {
                    board.append('+');
                }
                else if(passVertical[i][j]) {
                    board.append('|');
                }
                else if(passHorizontal[i][j]) {
                    board.append('-');
                }else {
                    board.append('.');
                }
            }
            board.append('\n');
        }
        System.out.println(board);
    }
}
