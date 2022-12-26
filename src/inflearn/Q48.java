package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Q48 {
    public int[] q48(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) { //x가 캐시에 있는지 없는지 확인
            System.out.println(Arrays.toString(cache));
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) { //hit
                    index = i; //hit된 지점의 index를 저장
                }
            }
            if (index == -1) { //miss -> 앞으로 땡긴다.
                for (int i = size - 1; i >= 1; i--) { //캐시size 뒤에부터
                    cache[i] = cache[i - 1]; //앞에있는걸 뒤로
                }
            }
            else{ //hit처리
                for(int i=index; i>=1; i--){
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

    public static void main(String[] args) {
        Q48 q48 = new Q48();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q48.q48(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}
