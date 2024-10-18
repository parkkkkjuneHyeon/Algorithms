package com.junhyun.algorithms.implement.back11279;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back11279/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                Integer n = maxQueue.poll();
                if(n == null) n = 0;
                System.out.println(n);
            }
            else maxQueue.offer(num);
        }
    }
}
