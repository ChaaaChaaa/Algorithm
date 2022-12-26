package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Q49 {
    public String q49(int n, int [] arr){
        String ans = "U";
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i] == arr[i+1]){
                return "D";
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Q49 q49 = new Q49();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            System.out.println(q49.q49(n,arr));
        }
    }
}
