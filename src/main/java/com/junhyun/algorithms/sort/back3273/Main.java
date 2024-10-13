package com.junhyun.algorithms.sort.back3273;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/sort/back3273/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();
        int x = Integer.parseInt(br.readLine());

        bw.write(getSumCount(n, arr, x) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
    public static int getSumCount(int n, int[] arr, int x) {
        int cnt = 0;
        boolean[] exist = new boolean[1000001];

        for(int i=0; i<n; i++) {
            exist[arr[i]] = true;
        }

        for(int i=0; i<n; i++) {
            int pairValue = x - arr[i];
            if(pairValue >= 0 && pairValue <= 1000000 && arr[i] != pairValue) {
                cnt += exist[pairValue] ? 1 : 0;
                exist[arr[i]] = false;
                exist[pairValue] = false;
            }
        }
        return cnt;
    }
}


