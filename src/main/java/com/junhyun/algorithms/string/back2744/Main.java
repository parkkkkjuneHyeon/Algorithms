package com.junhyun.algorithms.string.back2744;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/User/IdeaProjects/algorithms/src/main/java/com/junhyun/algorithms/string/back2744/question.txt")));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int len = str.length();
        for(int i=0; i<len; i++) {
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z' ) {
                ch = (char) (ch + 32);
            }else if(ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            sb.append(ch);
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
