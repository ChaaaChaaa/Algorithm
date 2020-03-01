import java.util.Scanner;

public class Q15652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        NAndM4 nAndM4 = new NAndM4(n, m);
        nAndM4.backTracking(0, 1);
        nAndM4.printResult();
    }
}

class NAndM4 {
    private int n;
    private int m;
    private int[] inputNumArray;
    private StringBuilder sb = new StringBuilder();

    NAndM4(int n, int m) {
        this.n = n;
        this.m = m;
        inputNumArray = new int[m];
    }

    void backTracking(int index, int start) {
        if (index == m) {
            for (int numSequence : inputNumArray) {
                sb.append(numSequence).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            inputNumArray[index] = i;
            backTracking(index + 1, i);
        }


    }

    void printResult() {
        System.out.print(sb);
    }

}
