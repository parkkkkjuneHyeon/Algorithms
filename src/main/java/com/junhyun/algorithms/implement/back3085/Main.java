package com.junhyun.algorithms.implement.back3085;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back3085/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for(int i=0; i<N; i++)
            board[i] = br.readLine().toCharArray();

        System.out.println(checkCountCandy(board));

    }
    public static int checkCountCandy(char[][] board) {
        int N = board.length;
        int cnt = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(j < N-1 && board[i][j] != board[i][j+1]) {
                    swapCandy(board, i, j, i, j+1);
                    cnt = Math.max(cnt, Math.max(maxRowCandy(board), maxColumnCandy(board)));
                    swapCandy(board, i, j, i, j+1);
                }
                if(i < N-1 && board[i][j] != board[i+1][j]) {
                    swapCandy(board, i, j, i+1, j);
                    cnt = Math.max(cnt, Math.max(maxRowCandy(board), maxColumnCandy(board)));
                    swapCandy(board, i, j, i+1, j);
                }
            }
        }

        return cnt;
    }
    public static void swapCandy(char[][] board, int r1, int c1, int r2, int c2) {
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    public static int maxRowCandy(char[][] board) {
        int N = board.length;
        int maxRow = 0;
        for(int i=0; i<N; i++) {
            int cnt = 0;
            char currentCandy = board[i][0];
            for(int j=0; j<N; j++) {
                if(currentCandy == board[i][j]) cnt++;
                else {
                    cnt = 1;
                    currentCandy = board[i][j];
                }
                maxRow = Math.max(maxRow, cnt);
            }
        }

        return maxRow;
    }
    public static int maxColumnCandy(char[][] board) {
        int N = board.length;
        int maxColumn = 0;

        for(int i=0; i<N; i++) {
            int cnt = 0;
            char currentCandy = board[0][i];
            for(int j=0; j<N; j++) {
                if(currentCandy == board[j][i]) cnt++;
                else {
                    cnt = 1;
                    currentCandy = board[j][i];
                }
                maxColumn = Math.max(maxColumn, cnt);
            }
        }

        return maxColumn;
    }
}
