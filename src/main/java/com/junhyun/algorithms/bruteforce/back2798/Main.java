package com.junhyun.algorithms.bruteforce.back2798;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("src/main/java/com/junhyun/algorithms/bruteforce/back2798/question.txt");
        BufferedReader br = new BufferedReader(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] cards = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        int backJack = getMaxNumber(cards, n, m);

        bw.write(backJack + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int getMaxNumber(int[] cards, int n, int m) {
        return getMaxNumberCard(cards, n, m);
    }

    private static int getMaxNumberCard(int[] cards, int n, int m) {
        int max = 0;
        for(int i=0; i < n; i++) {
            for(int j=i+1; j < n; j++){
                for(int k=j+1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= m && sum <= 300000)
                        max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}
