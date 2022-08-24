package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point1 implements Comparable<Point1>{
    public int x;
    public int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point1 o){
        if(this.x == o.x){
            return this.y - o.y;
        }
        else{
            return this.x - o.x;
        }
    }
}

public class Q51 {
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point1> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point1(x,y));
        }
        Collections.sort(arr);
        for(Point1 o : arr){
            System.out.println(o.x+" "+o.y);
        }
    }
}
