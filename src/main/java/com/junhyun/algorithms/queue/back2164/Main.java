package com.junhyun.algorithms.queue.back2164;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/queue/back2164/question.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i <= N; i++) {
            q.add(i);
        }

        while(N-- > 1) {
            q.removeFirst();
            Integer num = q.pollFirst();
            q.addLast(num);
        }
        Integer lastNum = q.peek();
        System.out.println(lastNum);
    }

}
