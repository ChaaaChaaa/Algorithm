package programmers;


import java.util.Map;

public class PushKeyPad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }


    public static String solution(int[] numbers, String hand) {
        StringBuffer sb = new StringBuffer();
        int rightIndex = 12;
        int leftIndex = 10;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                leftIndex = number;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                rightIndex = number;
            } else {
                int rightLength = getLength(rightIndex, number);
                int leftLength = getLength(leftIndex, number);

                if (leftLength > rightLength) {
                    sb.append("R");
                    rightIndex = number;
                } else if (leftLength < rightLength) {
                    sb.append("L");
                    leftIndex = number;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftIndex = number;
                    } else {
                        sb.append("R");
                        rightIndex = number;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static int getLength(int currentIndex, int centerNumber) {
        if (currentIndex == 0) {
            currentIndex = 11;
        }

        if (centerNumber == 0) {
            centerNumber = 11;
        }

        int indexX = (currentIndex - 1) / 3;
        int indexY = (currentIndex - 1) % 3;

        int centerX = (centerNumber - 1) / 3;
        int centerY = 1;

        int ans = Math.abs(indexX - centerX) + Math.abs(indexY - centerY);

        return ans;
    }
}
