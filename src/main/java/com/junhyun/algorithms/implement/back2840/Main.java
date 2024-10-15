package com.junhyun.algorithms.implement.back2840;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back2840/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //바퀴 칸 수
        int K = Integer.parseInt(st.nextToken()); //바퀴 돌리는 횟수
        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int curIndex = 0;
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            //칸을 이동한 횟수
            int S = Integer.parseInt(st.nextToken());
            char alphabet = st.nextToken().charAt(0);
            //현재 인덱스에서 이동한 칸 수(N보다 수가 클 수도 있음)를 뺌
            //-값은 결국 뒤에서부터 시작하는 수이기 때문에 N을 더해줌
            //하지만 S가 현재 인덱스보다 작을 수 있음 그래서 N에 대한 나머지를 처리
            int nextIndex = ((curIndex - S) % N + N) % N;
            if(wheel[nextIndex] == '?') wheel[nextIndex] = alphabet;
            else if (wheel[nextIndex] != alphabet) {
                System.out.println("!");
                return;
            }
            curIndex = nextIndex;
        }

        //알파벳을 중복으로 사용하고 있는지 체크 각각 배열요소에 같은 알파벳이 있는지 체크해서 처리
        boolean[] isAlphabet = new boolean[26];
        for(int i=0; i<N; i++) {
            if(wheel[i] == '?') continue;
            if(isAlphabet[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            isAlphabet[wheel[i] - 'A'] = true;
        }
        for(int i=0; i<N; i++) {
            System.out.print(wheel[(curIndex + i) % N]);
        }

    }
}
