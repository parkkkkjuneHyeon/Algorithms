package com.junhyun.algorithms.implement.back1927;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back1927/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                Integer min = minQueue.poll();
                min = min == null ? 0 : min;
                sb.append(min + "\n");
                continue;
            }
            minQueue.add(num);
        }
        System.out.println(sb);
    }

}
