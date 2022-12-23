package boj;

import java.util.Scanner;

public class Q10972 {
    private static final int START = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countNum = sc.nextInt();
        int[] permutationList = new int[countNum];

        for (int i = START; i < countNum; i++) {
            permutationList[i] = sc.nextInt();
        }
        NextPermutation nextPermutation = new NextPermutation(permutationList);
        nextPermutation.printPermutation();
    }
}

class NextPermutation {
    private static final String BLANK = " ";
    private static final int PREV = -1;
    private static final int ZERO = 0;
    private int[] permutationList;
    private int size;

    NextPermutation(int[] permutationList) {
        this.permutationList = permutationList;
        size = permutationList.length;

    }

    void printPermutation() {
        if (flagNextPermutation()) {
            for (int element : permutationList) {
                System.out.print(element + BLANK);
            }
        } else {
            System.out.println("-1");
        }

    }

    private boolean flagNextPermutation() {
        int i = size - 1;
        while (i > ZERO && permutationList[i + PREV] >= permutationList[i]) {
            i -= 1;
        }

        if (i <= ZERO) {
            return false;
        }

        int j = size - 1;
        while (permutationList[j] <= permutationList[i + PREV]) {
            j -= 1;
        }

        swap(i + PREV, j);

        j = size - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private void swap(int i, int j) {
        int temp = permutationList[i];
        permutationList[i] = permutationList[j];
        permutationList[j] = temp;
    }
}


