package forstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int start,end;
    Time(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Time o) {
        if(this.end == o.end){
            return this.start - o.start;
        }
        else{
            return this.end - o.end;
        }
    }
}
public class Q9_2 {
    public int solution(ArrayList<Time> arrayList, int n){
        int cnt = 0;
        Collections.sort(arrayList);
        int endTime = 0;
        for(Time time : arrayList){
            if(time.start >= endTime){
                cnt++;
                endTime = time.end;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Q9_2 q9_2 = new Q9_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Time(x,y));
        }
        System.out.println(q9_2.solution(arr,n));
    }
}
