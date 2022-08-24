package inflearn;

import java.util.Scanner;

public class Q45 {
    public int[] q45(int n, int[] arr){
        for(int i=0; i<n-1; i++){
            int index = i; //앞에꺼, 가장작은 숫자의 index(위치) 저장
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[index]){
                    index = j; //교체
                }
            }
            int current = arr[i];
            arr[i] = arr[index];
            arr[index] = current;
        }
        return arr;
    }

    public static void main(String[] args){
        Q45 q45 = new Q45();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : q45.q45(n,arr)){
            System.out.print(x+" ");
        }
    }

}
