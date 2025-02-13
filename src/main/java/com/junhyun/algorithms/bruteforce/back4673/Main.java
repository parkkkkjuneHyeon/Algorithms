package com.junhyun.algorithms.bruteforce.back4673;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 10000;
        boolean[] isSelfNumArr = new boolean[cnt+1];
        int i = 1;
        while(cnt-- > 0) {
            int d = i;
            int num = i;
            int sum = 0;

            while(num > 0) {
                num = num / 10;
                d = d % 10;
                sum += d;
                d = num;
            }
            sum += i;
            if(sum < isSelfNumArr.length)
                isSelfNumArr[sum] = true;
            i++;
        }
        for(int j=1; j<isSelfNumArr.length; j++) {
            if(!isSelfNumArr[j]) {
                bw.write(j + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
