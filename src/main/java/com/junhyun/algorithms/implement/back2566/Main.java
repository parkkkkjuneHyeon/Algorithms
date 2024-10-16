package com.junhyun.algorithms.implement.back2566;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back2566/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] answer = new String[2];
        answer[0] = "0";
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<9; j++) {
                int num = Integer.parseInt(st.nextToken());
                int maxNum = Integer.parseInt(answer[0]);
                if(isNumThanMaxValue(num, maxNum)) {
                    answer[0] = String.valueOf(num);
                    answer[1] = (i+1) + " " + (j+1);
                }
            }
        }
        for(int i=0; i<2; i++) {
            bw.write(answer[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean isNumThanMaxValue(int num, int maxNum) {
        if(num >= maxNum)
            return true;
        else
            return false;
    }
}
