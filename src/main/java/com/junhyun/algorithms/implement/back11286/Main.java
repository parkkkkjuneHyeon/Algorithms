package com.junhyun.algorithms.implement.back11286;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back11286/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                Integer p1 = plusQueue.peek();
                Integer p2 = minusQueue.peek();
                p1 = p1 == null ? Integer.MAX_VALUE : p1;
                p2 = p2 == null ? Integer.MAX_VALUE : p2;
                if(p1 == Integer.MAX_VALUE && p2 == Integer.MAX_VALUE){
                    sb.append(0 + "\n");
                }
                else if(isP1MinValue(p1, p2)) {
                    p1 = plusQueue.poll();
                    sb.append(p1 + "\n");
                }else if (!isP1MinValue(p1, p2)) {
                    p2 = minusQueue.poll();
                    sb.append(p2 + "\n");
                }
                continue;
            }

            if(num < 0) minusQueue.offer(num);
            else plusQueue.offer(num);
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean isP1MinValue(int p1, int p2) {
        int absP1 = Math.abs(p1);
        int absP2 = Math.abs(p2);

        if(absP1 < absP2)
            return true;
        else if (absP1 > absP2)
            return false;
        else {
            if (p1 < p2)
                return true;
            else
                return false;
        }
    }
}
//
//        -1
//        1
//        0
//        -1
//        -1
//        1
//        1
//        -2
//        2
//        0