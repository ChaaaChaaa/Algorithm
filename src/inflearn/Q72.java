package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;

    Lecture(int money, int time) {
        this.money = money; //강연료
        this.date = date;
    }

    @Override
    public int compareTo(Lecture lecture) {
        return lecture.date - this.date; //내림차순으로 정렬
    }
}

public class Q72 {
    static int n, max = Integer.MIN_VALUE;

    public int q72(ArrayList<Lecture> lectureArrayList) {
        int ans = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); //큰값을 우선으로 뽑아냄
        Collections.sort(lectureArrayList);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (lectureArrayList.get(j).date < i) {
                    break;
                }
                priorityQueue.offer(lectureArrayList.get(j).money);
            }
            if(!priorityQueue.isEmpty()){
                ans+=priorityQueue.poll();
            }
        }
        return ans;
    }

    public static void main(String[] ags) {
        Q72 q72 = new Q72();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //강연갯수
        ArrayList<Lecture> lectureArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int date = sc.nextInt();
            lectureArrayList.add(new Lecture(money, date));
            if (date > max) {
                max = date;
            }
            System.out.println(q72.q72(lectureArrayList));
        }
    }
}
