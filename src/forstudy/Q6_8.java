package forstudy;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_8 {
    public int soultion(int n,int m, int[] arr){
        int ans=0;
        Arrays.sort(arr);
        int lt=0, rt=n-1;
        while (lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[mid]==m){
                ans=mid+1;
                break;
            }
            if(arr[mid]>m){
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q6_8 q6_8 = new Q6_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(q6_8.soultion(n,m,arr));
    }
}
