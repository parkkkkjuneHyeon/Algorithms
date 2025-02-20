package com.junhyun.algorithms.implement.back2817;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static ArrayList<Staff> getStaffInfo(BufferedReader br, int N, int X) throws IOException {
        ArrayList<Staff> staffList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] staffInfo = br.readLine().split(" ");
            String staff = staffInfo[0];
            int vote = Integer.parseInt(staffInfo[1]);
            if(vote > X) {
                staffList.add(new Staff(staff, vote));
            }
        }

        staffList.sort((o1, o2) -> {
            if (o1.getName().compareTo(o2.getName()) == 0) {
                return 0;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else {
                return 1;
            }
        });

        return staffList;
    }

    private static ArrayList<Score> getStaffVotePoints(List<Staff> staffList) {
        ArrayList<Score> scores = new ArrayList<>();
        int staffLen = staffList.size();
        for(int i=0; i<staffLen; i++) {
            int vote = staffList.get(i).getVote();
            for(int j=1; j<=14; j++) {
                scores.add(new Score(i, vote / j));
            }
        }

        Collections.sort(scores);

        return scores;
    }

    public static void main(String[] args)throws IOException {
        File file = new File("src/main/java/com/junhyun/algorithms/implement/back2817/question.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Math.round(Integer.parseInt(br.readLine()) * 0.05f);
        int N = Integer.parseInt(br.readLine());
        List<Staff> staffList = ALPSVote(br, N, X);
        staffList.forEach(staff -> {
            try {
                bw.write(staff + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        br.close();
        bw.flush();
        bw.close();
    }
    public static List<Staff> ALPSVote(BufferedReader br, int N, int X) throws IOException {
        ArrayList<Staff> staffInfo = getStaffInfo(br, N, X);
        ArrayList<Score> scores = getStaffVotePoints(staffInfo);

        IntStream.range(0, 14).forEach(i -> {
            int idx = scores.get(i).getIdx();
            staffInfo.get(idx).addPoint();
        });

        return staffInfo;
    }

    public static class Staff {
        private String name;
        private int point;
        private int vote;

        public Staff(String name, int vote) {
            this.name = name;
            this.point = 0;
            this.vote = vote;
        }
        public void addPoint() {
            this.point++;
        }
        public int getPoint() {
            return this.point;
        }
        public String getName() {
            return this.name;
        }
        public int getVote() {
            return this.vote;
        }

        @Override
        public String toString() {
            return "%s %d".formatted(this.name, this.point);
        }
    }

    public static class Score implements Comparable<Score> {
        private int idx;
        private int vote;

        public Score(int idx, int vote) {
            this.idx = idx;
            this.vote = vote;
        }

        public int getIdx() {
            return this.idx;
        }
        public int getVote() {
            return this.vote;
        }
        @Override
        public int compareTo(Score o) {
            return o.getVote() - this.getVote();
        }
        @Override
        public String toString() {
            return "%s %d".formatted(this.idx, this.vote);
        }
    }
}

