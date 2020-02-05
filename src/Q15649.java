import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        NAndM1 nAndM1 = new NAndM1(n, m);

        nAndM1.backTracking(0);
        nAndM1.printResult();

    }
}

class NAndM1 {
    private static final int INCREASE_COUNT = 1;
    private int n, m;
    private int[] inputNumList;
    private boolean[] checkList;

    private StringBuilder sb = new StringBuilder();

    NAndM1(int n, int m) {
        this.n = n;
        this.m = m;
        inputNumList = new int[m];
        checkList = new boolean[n + 1];
    }

    void backTracking(int index) {
        if (index == m) {
            for (int numSequence : inputNumList) {

                sb.append(numSequence).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!checkList[i]) {
                checkList[i] = true;
                inputNumList[index] = i;
                backTracking(index + INCREASE_COUNT);
                checkList[i] = false;
            }
        }
    }

    void printResult() {
        System.out.print(sb);
    }
}
