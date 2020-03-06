import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q10974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] permutationArr = new int[count];

        for (int i = 1; i <= count; i++) {
            permutationArr[i - 1] = i;
        }

        WholePermutation wholePermutation = new WholePermutation(permutationArr);
        wholePermutation.printWholePermutation();

    }
}

class WholePermutation {
    private int[] permutationArr;
    private int size;

    WholePermutation(int[] permutationArr) {
        this.permutationArr = permutationArr;
        size = permutationArr.length - 1;
    }

    void printWholePermutation() {
        do {
            for (int i = 0; i <= size; i++) {
                System.out.print(permutationArr[i] + " ");
            }
            System.out.println();


        } while (flagWholePermutation());
    }

    private boolean flagWholePermutation() {
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
