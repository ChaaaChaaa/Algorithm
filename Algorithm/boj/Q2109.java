package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LectureInfo[] lecture = new LectureInfo[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int wage = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lecture[i] = new LectureInfo(day, wage);
        }
        //System.out.println(lecture);
        //(day,wage) :(1,20)->(1,2)-> (3,10)->(2,100)->(2,8)->(20,5)->(10,50)
        Arrays.sort(lecture);
        //(day,wage) :(1,2) ->(1,20)-> (2,8)->(2,100)->(3,10)->(10,50)->(20,5)
        int cost = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            cost += lecture[i].wage;
            queue.add(lecture[i].wage);
            if (queue.size() > lecture[i].day) {
                cost -= queue.poll();
            }
        }

        System.out.println(cost);
    }
}

class LectureInfo implements Comparable<LectureInfo> {
    int day;
    int wage;

    public LectureInfo(int day, int wage) {
        this.day = day;
        this.wage = wage;
    }

    @Override
    public int compareTo(LectureInfo o) {
        if (day == o.day) {
            return Integer.compare(wage, o.wage);
        }
        return Integer.compare(day, o.day);
    }
}
