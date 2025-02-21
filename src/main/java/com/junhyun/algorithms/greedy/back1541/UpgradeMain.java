package com.junhyun.algorithms.greedy.back1541;

import java.io.*;

public class UpgradeMain {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/greedy/back1541/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] subStrs = str.split("-");
        int result = 0;

        for(int i=0; i<subStrs.length; i++) {
            if(i != 0) {
                result -= sum(subStrs[i]);
            }else {
                result += Integer.parseInt(subStrs[i]);
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int sum(String str) {
        String[] subStrs = str.split("[+]");
        int sum = 0;
        for(String s : subStrs)
            sum += Integer.parseInt(s);
        return sum;
    }
}
