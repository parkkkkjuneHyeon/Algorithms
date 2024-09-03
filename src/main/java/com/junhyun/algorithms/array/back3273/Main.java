package com.junhyun.algorithms.array.back3273;


import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)throws IOException {
        File file = new File("/Users/User/IdeaProjects/algorithms/src/main/java/com/junhyun/algorithms/array/back3273/question.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        int[] array = Arrays
                .stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        boolean[] visited = new boolean[1000001];
        for (int i = 0; i < array.length; i++) {
            visited[array[i]] = true;
        }

        int x = getNumberOfTwin(visited, Integer.parseInt(br.readLine()));

        bw.write(x + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int getNumberOfTwin(boolean[] visited, int x) {
        int cnt = 0;
        //두번씩 쌍을 찾기 되는 문제가 생김 그래서 한번 더 찾을 경우를 빼고 두번 찾을 경우도 빼기 위해서
        //(x-1)/2
        for( int i=0; i <= (x-1)/2; i++) {
            if( i<= 1000000 && x-i <= 1000000) {
                //각 번호가 존재하면 true이고 각 쌍이 존재하면 true이고 1을 증가 시킴.
                cnt += visited[i] && visited[x-i] ? 1 : 0;
            }
        }
        return cnt;
    }

}
