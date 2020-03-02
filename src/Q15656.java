import java.util.Arrays;
import java.util.Scanner;

public class Q15656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inputNumArr = new int[n];

        for (int i = 0; i < n; i++) {
            inputNumArr[i] = sc.nextInt();
        }

        Arrays.sort(inputNumArr, 0, n);
        NAndM7 nAndM7 = new NAndM7(n, m, inputNumArr);
        System.out.print(nAndM7.backtracking(0));
    }
}

class NAndM7 {
    private int n;
    private int m;
    private int[] inputNumArr;
    private int[] ascArr;


    NAndM7(int n, int m, int[] inputNumArr) {
        this.n = n;
        this.m = m;
        this.inputNumArr = inputNumArr;
        ascArr = new int[n];

    }

    StringBuilder backtracking(int index) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(inputNumArr[ascArr[i]]).append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            ascArr[index] = i;
            ans.append(backtracking(index + 1));
        }
        return ans;
    }


}
