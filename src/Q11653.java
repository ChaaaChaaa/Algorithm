
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q11653 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        br.close();

        IntegerFactorization integerFactorization = new IntegerFactorization(inputNum);

        while (integerFactorization.getInputNum() != 1) {

            integerFactorization.addIntegerFactorization();
        }
        integerFactorization.printIntegerFactorization();
    }
}

class IntegerFactorization {
    private static final String NEW_LINE = "\n";
    private int i = 2;

    private int inputNum;
    private StringBuffer sb = new StringBuffer();

    IntegerFactorization(int inputNum) {
        this.inputNum = inputNum;
    }

    void addIntegerFactorization() {
        if (inputNum % i == 0) {
            sb.append(i).append(NEW_LINE);
            inputNum /= i;
        }
        if (inputNum % i != 0) {
            i++;
        }
    }

    void printIntegerFactorization() {
        System.out.println(sb.toString());
    }

    int getInputNum() {
        return inputNum;
    }
}
