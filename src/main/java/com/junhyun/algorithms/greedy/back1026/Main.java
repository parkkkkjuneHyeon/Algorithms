package com.junhyun.algorithms.greedy.back1026;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/greedy/back1026/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] strA = br.readLine().split(" ");
        String[] strB = br.readLine().split(" ");
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        IntStream.range(0, N)
                .forEach(i -> {
                    A.add(Integer.parseInt(strA[i]));
                    B.add(Integer.parseInt(strB[i]));
                });

        Collections.sort(A);
        B.sort(Collections.reverseOrder());

        int result = IntStream.range(0, N)
                .map(i -> A.get(i) * B.get(i))
                .sum();

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }
}
