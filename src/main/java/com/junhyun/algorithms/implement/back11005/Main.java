package com.junhyun.algorithms.implement.back11005;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back11005/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        List<Character> arr = getBaseConversion(N, B);
        int len = arr.size();
        for(int i=len-1; i>=0; i--) {
            bw.write(arr.get(i));
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static List<Character> getBaseConversion(int N, int B) {
        List<Character> arr = new ArrayList<>();

        while(N > 0) {
            int num = N % B;
            N /= B;
            if(num < 10) {
                arr.add((char)('0' + num));
            }else {
                arr.add((char)(('A' - 10) + num));
            }
        }
        return arr;
    }
}
