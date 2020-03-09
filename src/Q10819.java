import java.util.Arrays;
import java.util.Scanner;

public class Q10819 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] permutationArr = new int[count];

        for (int i = 0; i < count; i++) {
            permutationArr[i] = sc.nextInt();
        }

        Arrays.sort(permutationArr);
        MaximumGap maximumGap = new MaximumGap(permutationArr);
        maximumGap.printWholePermutation();

    }
}

class MaximumGap {
    private int[] permutationArr;
    private int size;

    MaximumGap(int[] permutationArr) {
        this.permutationArr = permutationArr;
        size = permutationArr.length - 1;
    }

    void printWholePermutation() {
        int max = 0;
        // int max = Integer.MIN_VALUE;

        do {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += Math.abs(permutationArr[i] - permutationArr[i + 1]);
            }

            if (sum > max) {
                max = sum;
            }
//            max = Math.max(max, sum);
        } while (flagNextPermutation());
        System.out.println(max);
    }

    private boolean flagNextPermutation() {
        int i = size;
        while (i > 0 && permutationArr[i - 1] >= permutationArr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }


        int j = size;
        while (permutationArr[j] <= permutationArr[i - 1]) {
            j--;
        }
        swap(i - 1, j);

        j = size;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    private void swap(int i, int j) {
        int temp = permutationArr[i];
        permutationArr[i] = permutationArr[j];
        permutationArr[j] = temp;
    }
}
