package com.junhyun.algorithms.implement.back10448;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back10448/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] triangleNumbers = new int[50];

        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int triangleCount = getTriangleCount(triangleNumbers, k);
            boolean[] isFounds = checkTriangles(triangleNumbers, triangleCount, k);
            boolean isFound = findTriangleNumber(triangleNumbers, k, triangleCount, isFounds);

            bw.write(isFound ? "1\n" : "0\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int getTriangleCount(int[] triangleNumbers, int k) {
        int triangleCount = 0;
        int num = 0;
        for(int i=1; num<=k; i++) {
            num = i*(i+1)/2;
            triangleNumbers[triangleCount++] = num;
        }
        return triangleCount;
    }

    public static boolean[] checkTriangles(int[] triangleNumbers, int triangleCount, int k) {
        boolean[] isFoundValue = new boolean[1001];

        for(int i=0; i<triangleCount; i++) {
            for(int j=0; j<triangleCount; j++) {
                int num = triangleNumbers[i] + triangleNumbers[j];
                if(num >= k) {
                    break;
                }else {
                    isFoundValue[num] = true;
                }
            }
        }
        return isFoundValue;
    }

    public static boolean findTriangleNumber(int[] triangleNumbers, int k, int triangleCount, boolean[] isFounds) {
        for(int i=0; i<=1000; i++) {
            if(isFounds[i]) {
                for(int j=0; j<triangleCount; j++) {
                    int num = triangleNumbers[j] + i;
                    if(num == k)
                        return true;
                }
            }
        }
        return false;
    }

//    public static boolean findTriangleNumber(int[] triangleNumbers, int k, int triangleCount) {
//        for(int i=0; i<triangleCount; i++) {
//            for(int j=0; j<triangleCount; j++) {
//                for(int z=0; z<triangleCount; z++) {
//                    int triangleNumber = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[z];
//                    if (triangleNumber == k)
//                        return true;
//                }
//            }
//        }
//
//        return false;
//    }

}
