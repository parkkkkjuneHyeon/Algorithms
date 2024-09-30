package com.junhyun.algorithms.string.back1543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/User/IdeaProjects/algorithms/src/main/java/com/junhyun/algorithms/string/back1543/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String word = br.readLine();

        String doc = str.replaceAll(word,"");

        bw.write(String.valueOf((str.length()-doc.length())/word.length()));

        br.close();
        bw.flush();
        bw.close();
    }
}
