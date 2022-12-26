package programmers;


import java.util.Arrays;

public class NumberKth {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int PICK_NUMBER_INDEX = 2;
    private static final int ARRANGE_ARRAY_INDEX = -1;

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][START_INDEX];
            int end = commands[i][END_INDEX];
            int findIndex = commands[i][PICK_NUMBER_INDEX];

            int[] selectedNumbers = selectedNumbersToInputArr(array, start, end);

            Arrays.sort(selectedNumbers);
            answer[index++] = selectedNumbers[findIndex +ARRANGE_ARRAY_INDEX];
        }
        return answer;
    }

    private int[] selectedNumbersToInputArr(int[] array, int start, int end) {
        int[] selectedNumbers = new int[end - start + 1];

        int tempIndex = 0;
        for (int j = start +ARRANGE_ARRAY_INDEX; j < end; j++) {
            selectedNumbers[tempIndex] = array[j];
            tempIndex++;
        }
        return selectedNumbers;
    }


    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        NumberKth numberKth = new NumberKth();
        System.out.println(Arrays.toString(numberKth.solution(array, commands)));

    }
}
