package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    public int height,weight;
    Body(int height, int weight){
        this.height =height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body body) {
        return body.height - this.height;
    }
}
public class Q69 {
    public int q69(ArrayList<Body> arr, int n){
        int cnt=0;
        Collections.sort(arr);
        int max=Integer.MIN_VALUE;
        for(Body body : arr){
            if(body.weight > max){
                max = body.weight;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Q69 q69 = new Q69();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int height=sc.nextInt();
            int weight = sc.nextInt();
            arr.add(new Body(height,weight));
        }
        System.out.println(q69.q69(arr,n));
    }
}
