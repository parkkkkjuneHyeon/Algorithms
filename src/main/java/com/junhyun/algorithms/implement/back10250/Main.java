package com.junhyun.algorithms.implement.back10250;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back10250/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int roomFloor = N % H == 0  ? H : N % H;
            int roomNumber = N % H == 0 ? N / H : (N / H) + 1;

            System.out.printf("%d%02d\n", roomFloor, roomNumber);
        }
    }
}
