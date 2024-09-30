package com.junhyun.algorithms.string.back13223;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/string/back13223/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] currentTime = br.readLine().split(":");
        String[] workingTime = br.readLine().split(":");

        bw.write(checkWorkTime(currentTime, workingTime));
        bw.flush();
        bw.close();
        br.close();
    }
    public static String checkWorkTime(String[] currentTime, String[] workingTime) {
        int currentSecond = getSecond(currentTime);
        int workingSecond = getSecond(workingTime);
        int answerSecond = workingSecond - currentSecond <= 0
                ? (workingSecond - currentSecond) + getSecond(new String[]{"24", "0", "0"})
                : workingSecond - currentSecond;

        String hours = String.valueOf(answerSecond / 3600).length() == 1
                ? "0" + answerSecond / 3600
                : String.valueOf(answerSecond / 3600);
        
        String minutes = String.valueOf(answerSecond % 3600 / 60).length() == 1
                ? "0" + answerSecond % 3600 / 60
                : String.valueOf(answerSecond % 3600 / 60);

        String seconds = String.valueOf(answerSecond % 60).length() == 1
                ? "0" + answerSecond % 60
                : String.valueOf(answerSecond % 60 );

        return hours + ":" + minutes + ":" + seconds;
    }
    public static int getSecond(String[] str) {
        int hours = Integer.parseInt(str[0]);
        int minute = Integer.parseInt(str[1]);
        int second = Integer.parseInt(str[2]);

        return hours * 3600 + minute * 60 + second;
    }
}
