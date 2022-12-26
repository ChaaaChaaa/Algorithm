package forstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time2 implements Comparable<Time2>{
    public int time;
    public char state;

    public Time2(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time2 o) {
        if(this.time == o.time){
            return this.state - o.state;
        }else{
            return this.time - o.time;
        }
    }
}
public class Q9_3 {
    public int solution(ArrayList<Time2> arrayList){
        int ans = Integer.MIN_VALUE;
        Collections.sort(arrayList);
        int cnt = 0;
        for(Time2 time : arrayList){
            if(time.state == 's'){
                cnt++;
            }else{
                cnt--;
            }
            ans = Math.max(ans,cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q9_3 q9_3 = new Q9_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time2> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            arrayList.add(new Time2(startTime,'s'));
            arrayList.add(new Time2(endTime,'e'));
        }
        System.out.println(q9_3.solution(arrayList));
    }
}
