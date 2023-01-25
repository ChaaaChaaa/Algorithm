package boj;

import java.util.Scanner;

public class Q2343 {
   private static int n,m;
    private static int [] arr;
    private static int left,right;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();

         arr = new int[n];
        int sum = 0;

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
            left = Math.max(left,arr[i]);
        }

        right = sum;
        binarySearch();
        System.out.println(left);
    }

    private static void  binarySearch(){
        int mid, sum, count;

        while(left<=right){
            mid = (left+right)/2;
            sum = 0;
            count = 0;

            for(int i=0; i<n; i++){
                if(sum+arr[i] > mid){
                    sum= 0;
                    count++;
                }

                sum += arr[i];
            }

            if(sum > 0){
                count++;
            }

            if(count <= m){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
    }
}
