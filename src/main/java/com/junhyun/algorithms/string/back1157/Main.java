package com.junhyun.algorithms.string.back1157;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/User/IdeaProjects/algorithms/src/main/java/com/junhyun/algorithms/string/back1157/question.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toLowerCase();
        char alphabet = getMostUsedAlphabet(str);

        bw.write(alphabet);
        bw.flush();
        br.close();
        bw.close();
    }
    public static char getMostUsedAlphabet(String str) {
        int [] cnt = countAlphabets(str);
        int len = cnt.length;
        int idx = 0;
        boolean isMostUsed = false;

        for(int i=1; i<len; i++) {
            if(cnt[i] > cnt[idx]) {
                isMostUsed = false;
                idx = i;
            }else if(cnt[i] == cnt[idx]) {
                isMostUsed = true;
            }
        }

        return isMostUsed ? '?' : (char)('A' + idx);
    }

    public static int[] countAlphabets(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            counts[ch - 'a']++;
        }
        return counts;
    }
}
