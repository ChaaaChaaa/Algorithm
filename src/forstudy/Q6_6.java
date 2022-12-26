package forstudy;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6_6 {
    public ArrayList<Integer> solution(int n, int[] arr) {
       ArrayList<Integer> arrayList = new ArrayList<>();
       int [] temp = arr.clone();
       for(int i=0; i<n; i++){
           if(arr[i] != temp[i]){
               arrayList.add(i+1);
           }
       }
       return arrayList;
    }

    public static void main(String[] args) {
        Q6_6 q6_6 = new Q6_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q6_6.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
