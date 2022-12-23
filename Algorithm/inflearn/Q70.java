package inflearn;

import java.lang.reflect.Array;
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
    public int compareTo(Time time){
        if(this.end == time.end){
            return this.start - time.start;
        }
        else{
            return this.end- time.end;
        }
    }
}
public class Q70 {
    public int q70(ArrayList<Time> arr, int n){
        int cnt=0;
        Collections.sort(arr);
        int endTime=0;
        for(Time time : arr){
            if(time.start >= endTime){
                cnt++;
                endTime = time.end;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Q70 q70 = new Q70();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            int start=sc.nextInt();
            int end= sc.nextInt();
            arrayList.add(new Time(start,end));
        }
        System.out.println(q70.q70(arrayList,n));
    }
}
