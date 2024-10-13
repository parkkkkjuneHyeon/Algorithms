package com.junhyun.algorithms.sort.back10989;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/sort/back10989/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[10001];
        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            array[num]++;
        }
        for(int i=0; i<=10000; i++) {
            if(array[i] != 0) {
                while(array[i]-- > 0) {
                    bw.write(i+"\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}


