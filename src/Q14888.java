import java.util.Scanner;

public class Q14888 {
    private static final int OPERATORS_TYPE = 4;
    private static final int NEXT_ELEMENT = 1;
    private static final int FIRST_ELEMENT = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] inputArr = new int[n];
        int[] operators = new int[OPERATORS_TYPE];


        for (int i = 0; i < n; i++) {
            inputArr[i] = sc.nextInt();
        }

        for (int i = 0; i < OPERATORS_TYPE; i++) {
            operators[i] = sc.nextInt();
        }

        InsertOperator insertOperator = new InsertOperator(n, operators, inputArr);
        insertOperator.dfs(NEXT_ELEMENT, inputArr[FIRST_ELEMENT]);
        insertOperator.print();
    }
}

class InsertOperator {
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


    InsertOperator(int n, int[] operators, int[] inputArr) {
        this.n = n;
        this.operators = operators;
        this.inputArr = inputArr;
    }

    private void compareNum(int sum) {
        maxValue = Math.max(maxValue, sum);
        minValue = Math.min(minValue, sum);
    }

    void dfs(int index, int sum) {
        if (index == n) {
            compareNum(sum);
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
    }

    void print() {
        System.out.println(maxValue);
        System.out.println(minValue);
    }

}
