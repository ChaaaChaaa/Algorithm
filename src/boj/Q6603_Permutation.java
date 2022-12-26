package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6603_Permutation {
    private static final int FINISH = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int numOfElementsInSet = sc.nextInt();
            if (numOfElementsInSet == FINISH) {
                break;
            }

            int[] numSet = new int[numOfElementsInSet];
            for (int i = 0; i < numOfElementsInSet; i++) {
                numSet[i] = sc.nextInt();
            }
            Lotto lotto = new Lotto(numOfElementsInSet, numSet);

            lotto.exceptPermutationNum();
            lotto.addAnswerInPermutation();
            lotto.sortArrayList();
            lotto.printAnsPermutation();
        }
    }
}

class Lotto {
    private static final String SPACE = " ";
    private static final int PICK_NUMBER = 6;
    private static final int NOT_PICK = 0;
    private static final int PICK = 1;

    private int[] numSet;
    private int[] flagToUsePermutationSet;
    private int numOfElementsInSet;

    Lotto(int numOfElementsInSet, int[] numSet) {
        this.numSet = numSet;
        this.numOfElementsInSet = numOfElementsInSet;
        flagToUsePermutationSet = new int[numOfElementsInSet];
    }

    void exceptPermutationNum() {
        for (int i = 0; i < numOfElementsInSet; i++) {
            if (i < numOfElementsInSet - PICK_NUMBER) {
                flagToUsePermutationSet[i] = NOT_PICK;
            }
            if (i >= numOfElementsInSet - PICK_NUMBER) {
                flagToUsePermutationSet[i] = PICK;
            }
        }
    }

    private ArrayList<ArrayList<Integer>> ansArrList = new ArrayList<>();

    void addAnswerInPermutation() {
        do {
            ArrayList<Integer> curArrList = new ArrayList<>();
            for (int i = 0; i < numOfElementsInSet; i++) {
                if (flagToUsePermutationSet[i] == PICK) {
                    curArrList.add(numSet[i]);
                }
            }
            ansArrList.add(curArrList);
        } while (nextPermutation());
    }

    private boolean nextPermutation() {
        int size = flagToUsePermutationSet.length -1;

        int i = size;

        while (i > 0 && flagToUsePermutationSet[i - 1] >= flagToUsePermutationSet[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = size;
        while (flagToUsePermutationSet[j] <= flagToUsePermutationSet[i - 1]) {
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
        int temp = flagToUsePermutationSet[i];
        flagToUsePermutationSet[i] = flagToUsePermutationSet[j];
        flagToUsePermutationSet[j] = temp;
    }

    void sortArrayList() {
        ansArrList.sort((l1, l2) -> {
            int firstArrList_Size = l1.size();
            int secondArrList_Size = l2.size();
            int i = 0;

            while (i < firstArrList_Size && i < secondArrList_Size) {
                int firstArrList_Element = l1.get(i);
                int secondArrList_Element = l2.get(i);

                if (firstArrList_Element < secondArrList_Element) {
                    return -1;
                } else if (firstArrList_Element > secondArrList_Element) {
                    return 1;
                }
                i++;
            }

            if (i == firstArrList_Size && i != secondArrList_Size) {
                return -1;
            } else if (i != firstArrList_Size && i == secondArrList_Size) {
                return 1;
            }
            return 0;
        });
    }


    void printAnsPermutation() {
        for (ArrayList<Integer> element : ansArrList) {
            for (int x : element) {
                System.out.print(x + SPACE);
            }
            System.out.println();
        }
        System.out.println();
    }

}