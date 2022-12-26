package forstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.time - this.time;
    }
}
public class Q9_4 {
    static int n,max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arrayList){
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arrayList);
        int j=0;
        for(int i=max; i>=1; i--){
            for(; j<n; j++){
                if(arrayList.get(j).time <i){
                    break;
                }
                pq.offer(arrayList.get(j).money);
            }
            if(!pq.isEmpty()){
                ans += pq.poll();
            }            
        }
        return ans;
    }

    public static void main(String[] args) {
        Q9_4 q9_4 = new Q9_4();
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        ArrayList<Lecture> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            arrayList.add(new Lecture(m,d));
            if(d>max){
                max = d;
            }
        }
        System.out.println(q9_4.solution(arrayList));
    }
}
