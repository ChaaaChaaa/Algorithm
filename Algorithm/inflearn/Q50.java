package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q50 {
    public ArrayList<Integer> q50(int n, int[] arr){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int [] temp = arr.clone();
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            if(arr[i] != temp[i]){
                arrayList.add(i+1);
            }
        }
        return arrayList;
    }

    public static void main(String[] args){
        Q50 q50 = new Q50();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : q50.q50(n,arr)){
            System.out.print(x+" ");
        }
    }
}
