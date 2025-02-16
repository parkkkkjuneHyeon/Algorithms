package com.junhyun.algorithms.greedy.back1931;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[][] getMeetingTime(int N, BufferedReader br) throws IOException {
        StringTokenizer st;
        int[][] times = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        return times;
    }
    public static int getCountMeetingTime(int[][] times, int N) {
        int cnt = 1;
        int[] currentTime = times[0];

        for(int i=1; i<N; i++) {
            if(currentTime[1] <= times[i][0]) {
                currentTime = times[i];
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/greedy/back1931/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] times = getMeetingTime(N, br);
        int cnt = getCountMeetingTime(times, N);

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
