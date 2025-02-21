package com.junhyun.algorithms.greedy.back1715;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/greedy/back1715/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        while (N-- > 0)
            pq.add(Long.parseLong(br.readLine()));

        System.out.println(cardCount(pq));
    }

    public static long cardCount(PriorityQueue<Long> pq) {
        long result = 0;

        while(pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            result += num1 + num2;
            pq.add(num1 + num2);
        }

        return result;
    }
}
