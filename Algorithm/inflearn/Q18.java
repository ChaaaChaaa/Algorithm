package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Q18 {
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> q18(int num, int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int temp = arr[i];
            int res = 0;
            while (temp > 0) {
                int remainder = temp % 10;
                res = res * 10 + remainder;
                temp = temp / 10;
            }
            if (isPrime(res)) {
                ans.add(res);
            }
        }
        return ans;
    }

    public void main(String[] args) {
        Q18 q18 = new Q18();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q18.q18(num, arr)) {
            System.out.print(x + " ");
        }
    }
}
