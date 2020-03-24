import java.util.Scanner;

public class Q1182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] sequenceArr = new int[N];

        for (int i = 0; i < N; i++) {
            sequenceArr[i] = sc.nextInt();
        }


        SumOfPartialSequence sumOfPartialSequence = new SumOfPartialSequence(N, S, sequenceArr);
        sumOfPartialSequence.bitMask();

    }
}

class SumOfPartialSequence {

    int N;
    int S;
    int[] sequenceArr;

    SumOfPartialSequence(int N, int S, int[] sequenceArr) {
        this.N = N;
        this.S = S;
        this.sequenceArr = sequenceArr;
    }

    int ans = 0;

    void bitMask() {

        for (int i = 1; i < (1 << N); i++) {
            int sum = 0;
            for (int k = 0; k < N; k++) {
                if ((i & (1 << k)) != 0) {

                    sum += sequenceArr[k];
                }
            }

            if (sum == S) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
