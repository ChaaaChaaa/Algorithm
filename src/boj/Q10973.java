package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int[] permutationsArr = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            permutationsArr[i] = Integer.parseInt(st.nextToken());
        }

        PrevPermutations prevPermutations = new PrevPermutations(permutationsArr);
        System.out.print(prevPermutations.printPrevPermutations());

    }
}

class PrevPermutations {
    private int[] permutationsArr;
    private int size;

    PrevPermutations(int[] permutationsArr) {
        this.permutationsArr = permutationsArr;
        size = permutationsArr.length - 1;
    }

    StringBuilder printPrevPermutations() {
        StringBuilder sb = new StringBuilder();

        if (flagPrevPermutations()) {
            for (int element : permutationsArr) {
                sb.append(element).append(" ");
            }
            sb.append("\n");
            return sb;
        } else {
            sb.append("-1");
            return sb;
        }
    }

    private boolean flagPrevPermutations() {
        int i = size;
        while (i > 0 && permutationsArr[i - 1] <= permutationsArr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = size;
        while (permutationsArr[j] >= permutationsArr[i - 1]) {
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
        int temp = permutationsArr[i];
        permutationsArr[i] = permutationsArr[j];
        permutationsArr[j] = temp;
    }
}
