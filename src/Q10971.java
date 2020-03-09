import java.util.Scanner;

public class Q10971 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCity = sc.nextInt();

        int[][] travelExpenseEachCity = new int[numOfCity][numOfCity];

        for (int i = 0; i < numOfCity; i++) {
            for (int j = 0; j < numOfCity; j++) {
                travelExpenseEachCity[i][j] = sc.nextInt();
            }
        }

        TravelingSalesmanProblem2 tsp2 = new TravelingSalesmanProblem2(travelExpenseEachCity, numOfCity);

        tsp2.inputNumVisitRoute();
        tsp2.printPermutation();
    }
}

class TravelingSalesmanProblem2 {
    private int[][] travelExpenseEachCity;
    private int[] visitPermutationArr;
    private int size;
    private int numOfCity;


    TravelingSalesmanProblem2(int[][] travelExpenseEachCity, int numOfCity) {
        this.travelExpenseEachCity = travelExpenseEachCity;
        size = numOfCity - 1;
        visitPermutationArr = new int[numOfCity];
        this.numOfCity = numOfCity;
    }

    void inputNumVisitRoute() {
        for (int i = 0; i < numOfCity; i++) {
            visitPermutationArr[i] = i;
        }
    }

    private boolean flagExpenseZero(int i) {
        return travelExpenseEachCity[visitPermutationArr[i]][visitPermutationArr[i + 1]] == 0;
    }

    private boolean flag_MoveLastToFirstCity(boolean flagExpenseZero) {
        return flagExpenseZero && travelExpenseEachCity[visitPermutationArr[size]][visitPermutationArr[0]] != 0;
    }


    void printPermutation() {
        int ans = Integer.MAX_VALUE;
        do {
            boolean flagExpenseZero = true;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                if (flagExpenseZero(i)) {
                    flagExpenseZero = false;
                } else {
                    sum += travelExpenseEachCity[visitPermutationArr[i]][visitPermutationArr[i + 1]];
                }
            }
            if (flag_MoveLastToFirstCity(flagExpenseZero)) {
                sum += travelExpenseEachCity[visitPermutationArr[size]][visitPermutationArr[0]];
                if (ans > sum) {
                    ans = sum;
                }
            }
        } while (nextPermutation());
        System.out.println(ans);
    }


    private boolean nextPermutation() {
        int i = size;
        while (i > 0 && visitPermutationArr[i] <= visitPermutationArr[i - 1]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = size;
        while (visitPermutationArr[i - 1] >= visitPermutationArr[j]) {
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
        int temp = visitPermutationArr[i];
        visitPermutationArr[i] = visitPermutationArr[j];
        visitPermutationArr[j] = temp;
    }
}
