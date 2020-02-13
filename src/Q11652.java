import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Q11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] inputs = new BigInteger[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = new BigInteger(br.readLine());
        }

        br.close();

        Card card = new Card(inputs);

        card.sortArrAscendingOrder();

        for (int i = 0; i < N; i++) {
            card.comparePrevAndPresentCards(i);
        }
        card.compareLastElementToOthers();
        card.printArr();
    }
}

class Card {
    private BigInteger[] inputs;

    private BigInteger preNumber;

    Card(BigInteger[] inputs) {
        this.inputs = inputs;
        preNumber = inputs[0];
    }

    void sortArrAscendingOrder() {
        Arrays.sort(inputs);
    }

    private int numberCounts = 0;
    private BigInteger withMostNumber = BigInteger.ZERO;
    private int withMostNumberCounts = 0;

    void comparePrevAndPresentCards(int i) {

        if (!preNumber.equals(inputs[i])) {
            compareTheMostNumCount();

            numberCounts = 1;
            preNumber = inputs[i];
        } else {
            numberCounts++;
        }
    }

    private void compareTheMostNumCount() {
        if (numberCounts > withMostNumberCounts) {
            withMostNumberCounts = numberCounts;
            withMostNumber = preNumber;

        }
    }

    void compareLastElementToOthers() {
        compareTheMostNumCount();
    }

    void printArr() {
        System.out.println(withMostNumber);
    }

}
