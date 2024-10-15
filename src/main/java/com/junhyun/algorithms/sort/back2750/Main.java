package com.junhyun.algorithms.sort.back2750;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/sort/back2750/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] arrCount = new boolean[2001];
        while(N-- > 0) {
            int num = 1000 + Integer.parseInt(br.readLine());
            arrCount[num] = true;
        }
        for(int i=0; i<2001; i++) {
            if(arrCount[i])
                bw.write((i - 1000)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
