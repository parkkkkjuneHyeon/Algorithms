package com.junhyun.algorithms.bruteforce.back1065;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/junhyun/algorithms/bruteforce/back1065/question.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int hansu = getHansu(N);
        bw.write(hansu+"");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int getHansu(int N) {
        int hansuCnt = 0;
        for(int i=1; i<=N; i++) {
            if(isHansu(i)) {
                hansuCnt++;
            }
        }
        return hansuCnt;
    }

    //한수는 100 미만은 다 한수임 근데 아예 모른다는 가정하에 작성.
    private static boolean isHansu(int num) {
        int[] numArr = new int[4];
        int i = numArr.length;

        do {
            i--;
            numArr[i] = num % 10;
            num = num / 10;
        }
        while(num > 0);

        if(i >= 2) return true;

        int d = numArr[numArr.length-2] - numArr[numArr.length-1];

        for(int j=numArr.length-3; j>=i; j--) {
            if(!(numArr[j] == numArr[j+1] + d))
               return false;
        }

        return true;
    }

}
