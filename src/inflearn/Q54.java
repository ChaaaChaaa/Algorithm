package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Q54 {
    public int count(int[] arr, int midDistance){ //유효한지 안한지
        int cnt=1; //한마리 배치했다.
        int endposition = arr[0]; //제일 왼쪽좌표에 : 많이 배치하기위해
        for(int i=1; i<arr.length; i++){ //0번엔 배치해서 1부터 시작
            if(arr[i] - endposition >=midDistance){ //이지점 - 바로 전에 배치한 마굿간의 좌표
                //arr에 말을 배치할수있다.
                cnt++; //말한마리 늘리고고                endposition = arr[i];
            }
        }
        return cnt;
    }
    public int q54(int n, int c, int[] arr){
        int ans=0;
        Arrays.sort(arr);
        int lt=1;
        int rt=arr[n-1];

        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr,mid)>=c){
                ans=mid;
                lt=mid+1;
            }
            else{
                rt = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Q54 q54 = new Q54();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(q54.q54(n,c,arr));
    }
}
