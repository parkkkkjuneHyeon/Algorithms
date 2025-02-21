package com.junhyun.algorithms.greedy.back1541;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/greedy/back1541/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String question = br.readLine();
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Character> plusAndMinus = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int len = question.length();

        for(int i=0; i<len; i++) {
            char ch = question.charAt(i);
            if(ch == '+') {
                plusAndMinus.add(ch);
                numbers.offer(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
            else if(ch == '-') {
                plusAndMinus.add(ch);
                numbers.offer(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
            else sb.append(ch);

        }
        numbers.offer(Integer.parseInt(sb.toString()));

        int result = execute(numbers, plusAndMinus);

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int execute(Queue<Integer> numbers, Queue<Character> plusAndMinus) {
        int result = numbers.poll();
        int pmLen = plusAndMinus.size();
        int minusFlag = 1;

        for(int i=0; i<pmLen; i++) {
            char ch = plusAndMinus.poll();
            char afterCh = !plusAndMinus.isEmpty() ? plusAndMinus.peek() : '?';
            if(ch == '-' && afterCh == '+') {
                minusFlag *= -1;
            }
            switch (ch) {
                case '+':
                    int num = numbers.poll();
                    if(minusFlag == -1) num = num * -1;
                    result += num;
                    break;
                case '-':
                    result += numbers.poll() * -1;
                    break;
            }
            if (ch == '+' && afterCh == '-') minusFlag = 1;
        }
        return result;
    }
}
