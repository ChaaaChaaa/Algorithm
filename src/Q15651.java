import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        NAndM3 nAndM3 = new NAndM3(n, m);
        nAndM3.backTracking(0);
        nAndM3.printResult();
    }
}

class NAndM3 {
    private static final int INCREASE_COUNT = 1;
    private int n, m;
    private int[] inputNumList;


    private StringBuilder sb = new StringBuilder();

    NAndM3(int n, int m) {
        this.n = n;
        this.m = m;
        inputNumList = new int[m];
    }

    void backTracking(int index) {

        if (index == m) {
            for (int numSequence : inputNumList) {
                sb.append(numSequence).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int start = 1;start <= n; start++) {
            inputNumList[index] = start;
            backTracking(index + INCREASE_COUNT);
        }

    }

    void printResult() {
        System.out.print(sb);
    }

}
