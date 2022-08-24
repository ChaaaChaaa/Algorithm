package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class WeddingTime implements Comparable<WeddingTime> {
    public int time;
    public char state; //이시간에 간건지 온건지 s인지 e인지

    WeddingTime(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(WeddingTime time) {
        if (this.time == time.time) {
            return this.state - time.state; //상황에서 알파벳으로 정렬해라
        } else {
            return this.time - time.time;
        }
    }
}

public class Q71 {
    public int q71(ArrayList<WeddingTime> timeArrayList) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(timeArrayList);//시간상 오름차순, 시간이 같으면 알파벳순
        int cnt = 0;
        for (WeddingTime weddingTime : timeArrayList) {
            if (weddingTime.state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        Q71 q71 = new Q71();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<WeddingTime> timeArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            timeArrayList.add(new WeddingTime(startTime, 's'));
            timeArrayList.add(new WeddingTime(endTime, 'e'));
        }
        System.out.println(q71.q71(timeArrayList));
    }
}