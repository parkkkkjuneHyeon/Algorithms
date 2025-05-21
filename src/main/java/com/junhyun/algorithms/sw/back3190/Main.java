package com.junhyun.algorithms.sw.back3190;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static Snake snake;
    private static int N;
    private static String[][] board;
    private static int K;
    private static int[][] applesLocation;
    private static int L;
    private static HashMap<String, String> snakeDirections;
    private static int[] dX = new int[]{1, 0, -1, 0};
    private static int[] dY = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/sw/back3190/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        snake = new Snake(1, 0, 0, 0);
        // 보드 크기 "A" : 사과 위치 "S" : 뱀 "X" 공간
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = "X";
            }
        }
        // 사과 개수
        K = Integer.parseInt(br.readLine());
        applesLocation = new int[K][2];

        for (int i = 0; i < K; i++) {
            int[] location = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[location[0]-1][location[1]-1] = "A";
            applesLocation[i] = location;
        }

        // 뱀 방향정보
        L = Integer.parseInt(br.readLine());
        snakeDirections = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String[] direction = br.readLine().split(" ");
            snakeDirections.put(direction[0], direction[1]);
        }

        bw.write(""+snakeMove());
        //예상 출력 9
        bw.flush();
        br.close();
        bw.close();
    }

    public static int snakeMove() {
        int d = 0;
        //초당 뱀이 이동
        while(true) {
            snake.addTime();

            snake.addHead(snake.getY() + dY[d],snake.getX() + dX[d]);

            //현재 위치에서 뱀이 보드에서 벗어났는지 아니면 자기 꼬리와 만났는지
            if(isFinish()) {
                return snake.getTime();
            }

            //이동 후 뱀머리가 해당 위치에 사과가 있는경우 길이 추가
            if(isMeetApple()) {
                snake.addLength();
            }else {
                snake.removeTail();
            }
            int time = snake.getTime();
            if(snakeDirections.containsKey(String.valueOf(time))) {
                d = setDirection(d, snakeDirections.get(String.valueOf(time)));
            }
        }
    }

    public static int setDirection(int d, String direction) {

        if(direction.equalsIgnoreCase("D")) {
            d++;
            if(d == dX.length)
                return 0;
        }else {
            d--;
            if(d < 0)
                return 3;
        }
        return d;
    }


    public static boolean isFinish() {
        if(snake.getX() < 0 || snake.getY() < 0
                || snake.getX() >= N || snake.getY() >= N)
            return true;

        else {
            List<int[]> snakeBody = snake.getSnakeBody();
            for(int i=0; i < snakeBody.size()-1; i++) {
                int[] body = snakeBody.get(i);
                int y = body[0];
                int x = body[1];

                if(snake.getX() == x && snake.getY() == y)
                    return true;
            }

            return false;
        }
    }

    public static boolean isMeetApple() {

        if(board[snake.getY()][snake.getX()].equalsIgnoreCase("A")) {
            board[snake.getY()][snake.getX()] = "X";
            return true;
        }

        return false;
    }

    static class Snake {
        private int length;
        private List<int[]> snakeBody;
        private int time;

        public Snake(int length, int x, int y, int time) {
            this.length = length;
            snakeBody = new ArrayList<>();
            snakeBody.add(new int[]{y, x});
            this.time = time;
        }

        public int getLength() {
            return length;
        }

        public void addLength() {
            this.length++;
        }

        public int getX() {
            return snakeBody.get(snakeBody.size()-1)[1];
        }

        public int getY() {
            return snakeBody.get(snakeBody.size()-1)[0];
        }

        public void addHead(int y, int x) {
            snakeBody.add(new int[]{y, x});
        }

        public void removeTail() {
            snakeBody.remove(0);
        }

        public List<int[]> getSnakeBody() {
            return snakeBody;
        }

        public int getTime() {
            return time;
        }

        public void addTime() {
            this.time++;
        }
    }
}

