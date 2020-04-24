import java.util.Scanner;

public class Q14225_Bitmask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] inputArr = new int[n];


        for (int i = 0; i < n; i++) {
            inputArr[i] = sc.nextInt();
        }

        SumOfPartialSequence2 sequence = new SumOfPartialSequence2(inputArr, n);
        sequence.bitmask();
    }
}

class SumOfPartialSequence2 {
    private int[] inputArr;
    private int n;
    private boolean[] check = new boolean[20 * 100000 + 10];

    SumOfPartialSequence2(int[] inputArr, int n) {
        this.inputArr = inputArr;
        this.n = n;
    }

    void bitmask() {
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;

            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) != 0) {

                    sum += inputArr[k];
                }
            }
            check[sum] = true;
        }
        flagInNumber();
    }

    private void flagInNumber() {
        for (int i = 0; ; i++) {
            if (check[i] == false) {
                System.out.println(i);
                break;
            }
        }

    }
}
