package com.junhyun.algorithms.dynamicprogramming.back10158;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/array/back10158/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] board = br.readLine().split(" ");
        String[] position = br.readLine().split(" ");
        int w = Integer.parseInt(board[0]);
        int h = Integer.parseInt(board[1]);
        int p = Integer.parseInt(position[0]);
        int q = Integer.parseInt(position[1]);
        int times = Integer.parseInt(br.readLine());
        int[] answer = new int[2];

        answer[0] = ((p + times) / w) % 2 == 0
                ? (p + times) % w
                : w - ((p + times) % w);

        answer[1] = ((q + times) / h) % 2 == 0
                ? (q + times) % h
                : h - ((q + times) % h);

        bw.write(answer[0] + " " + answer[1]);
        bw.flush();
        br.close();
        bw.close();
    }
}
