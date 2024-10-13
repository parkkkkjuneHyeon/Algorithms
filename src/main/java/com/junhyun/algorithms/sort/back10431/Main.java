package com.junhyun.algorithms.sort.back10431;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/sort/back10431/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringTokenizer st = null;
        int P = Integer.parseInt(br.readLine());
        while(br.ready()) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int cnt = countFromSort(st);
            System.out.printf("%d %d\n", T, cnt);
        }

    }
    public static int countFromSort(StringTokenizer st) {
        int[] sorted = new int[20];
        int idx = 0;
        int cnt = 0;
        int student = Integer.parseInt(st.nextToken());
        sorted[idx++] = student;
        while(st.hasMoreTokens()) {
            student = Integer.parseInt(st.nextToken());
            if(sorted[idx-1] > student) {
                int i = idx-1;
                while(sorted[i] > student) {
                    sorted[i+1] = sorted[i];
                    i--;
                    cnt++;
                    if(i == -1) break;
                }
                sorted[i+1] = student;
            }else {
                sorted[idx] = student;
            }
            idx++;
        }
        return cnt;
    }

    public static void getCountFromSortedArray() throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/sort/back10431/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        while(P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[] line = new int[20];
            int[] sorted = new int[20];
            int idx = 0;
            int cnt = 0;
            while (st.hasMoreTokens()) {
                line[idx++] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<20; i++) {
                sorted[i] = line[i];
                for(int j=0; j<i; j++) {
                    if(line[i] < sorted[j]) {
                        for(int k=i; k>j; k--) {
                            sorted[k] = sorted[k-1];
                            cnt++;
                        }
                        sorted[j] = line[i];
                        break;
                    }
                }
            }
            System.out.printf("%d %d\n", T, cnt);
        }
    }
    public static List<List<Integer>> getLines(int P, String[] array) {
        List<List<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            List<Integer> arr = Arrays.stream(array)
                    .map(Integer::parseInt)
                    .toList();
            List<Integer> line = new ArrayList<>(arr);
            line.removeFirst();
            lines.add(line);
        }

        return lines;
    }

    public static void getCounterFromSortedLines(int P, List<List<Integer>> lines) {
        int[] answers = new int[P];
        IntStream.range(0, P).forEach(idx -> {
            List<Integer> answerLine = new ArrayList<>(20);
            List<Integer> line = lines.get(idx);
            answerLine.add(line.get(0));
            for(int i=1; i<20; i++) {
                for(int j=0; j<i; j++) {
                    answerLine.add(line.get(i));
                    if(line.get(i) < answerLine.get(j)) {
                        for(int k=i; k>j; k--) {
                            answerLine.set(k, answerLine.get(k-1));
                            answers[idx]++;
                        }
                        answerLine.set(j, line.get(i));
                        break;
                    }
                }
            }
            System.out.println("%s %s".formatted(idx+1, answers[idx]));
        });
    }
}


