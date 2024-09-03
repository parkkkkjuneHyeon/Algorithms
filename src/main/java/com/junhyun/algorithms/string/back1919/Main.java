package com.junhyun.algorithms.string.back1919;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("/Users/User/IdeaProjects/algorithms/src/main/java/com/junhyun/algorithms/string/back1919/question.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int answer = checkAnagram(str1, str2);

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int checkAnagram(String str1, String str2) {
        int[] visitedStr1 = checkNumberOfAlphabet(str1);
        int[] visitedStr2 = checkNumberOfAlphabet(str2);
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(visitedStr1[i] - visitedStr2[i]);
        }
        return cnt;
    }

    public static int[] checkNumberOfAlphabet(String str) {
        int[] arr = new int['z' - 'a' + 1];
        int len = str.length();

        for (int i = 0; i < len; i++) {
            int idx = str.charAt(i) - 'a';
            arr[idx]++;
        }
        return arr;
    }
}
