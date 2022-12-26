package forstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    public int h,w;
    Body(int h, int w){
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}
public class Q9_1 {
    public int solution(ArrayList<Body> arr, int n){
        int cnt=0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body body : arr){
            if(body.w > max){
                max =body.w;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Q9_1 q9_1 = new Q9_1();
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<Body> arr = new ArrayList<Body>();
        for(int i=0; i<n; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(q9_1.solution(arr,n));
    }
}
