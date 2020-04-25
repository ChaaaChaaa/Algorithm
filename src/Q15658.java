import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15658 {
    private static final int OPERATORS_TYPE = 4;
    private static final int NEXT_ELEMENT = 1;
    private static final int FIRST_ELEMENT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] inputArr = new int[n];
        int[] operators = new int[OPERATORS_TYPE];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < OPERATORS_TYPE; i++) {
            operators[i] = Integer.parseInt(st2.nextToken());
        }

        InsertOperator2 insertOperator = new InsertOperator2(n, operators, inputArr);
        insertOperator.dfs(NEXT_ELEMENT, inputArr[FIRST_ELEMENT]);
        System.out.println(insertOperator.print());
    }
}

class InsertOperator2 {
    private int minValue = Integer.MAX_VALUE;
    private int maxValue = Integer.MIN_VALUE;
    private int n;
    private int[] operators;
    private int[] inputArr;

    private static final int PLUS = 0;
    private static final int MINUS = 1;
    private static final int MULTIPLICATION = 2;
    private static final int DIVISION = 3;
    private static final int NEXT_ELEMENT = 1;

    private StringBuilder sb = new StringBuilder();


    InsertOperator2(int n, int[] operators, int[] inputArr) {
        this.n = n;
        this.operators = operators;
        this.inputArr = inputArr;
    }

    private void compareNum(int sum) {
        maxValue = Math.max(maxValue, sum);
        minValue = Math.min(minValue, sum);
    }

    int dfs(int index, int sum) {
        if (index == n) {
            compareNum(sum);
            return 0;
        }

        if (operators[PLUS] > 0) {
            operators[PLUS]--;
            dfs(index + NEXT_ELEMENT, sum + inputArr[index]);
            operators[PLUS]++;
        }

        if (operators[MINUS] > 0) {
            operators[MINUS]--;
            dfs(index + NEXT_ELEMENT, sum - inputArr[index]);
            operators[MINUS]++;
        }

        if (operators[MULTIPLICATION] > 0) {
            operators[MULTIPLICATION]--;
            dfs(index + NEXT_ELEMENT, sum * inputArr[index]);
            operators[MULTIPLICATION]++;
        }

        if (operators[DIVISION] > 0) {
            operators[DIVISION]--;
            dfs(index + NEXT_ELEMENT, sum / inputArr[index]);
            operators[DIVISION]++;
        }

        return 0;
    }

    StringBuilder print() {
        sb.append(maxValue).append("\n");
        sb.append(minValue).append("\n");

        return sb;
    }

}
