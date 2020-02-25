import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        NAndM2 nAndM2 = new NAndM2(n, m);
        nAndM2.backTracking(0, 1);
        nAndM2.printResult();
    }
}

class NAndM2 {
    private static final int INCREASE_COUNT = 1;
    private int n, m;
    private int[] inputNumList;


    private StringBuilder sb = new StringBuilder();

    NAndM2(int n, int m) {
        this.n = n;
        this.m = m;
        inputNumList = new int[m];
    }

    void backTracking(int index, int start) {
        if (index == m) {
            for (int numSequence : inputNumList) {
                sb.append(numSequence).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            inputNumList[index] = i;
            backTracking(index + INCREASE_COUNT, i + INCREASE_COUNT);
        }
    }

    void printResult() {
        System.out.print(sb);
    }

}
