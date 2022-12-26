package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class SortFileName {
    private static final String PATTERN_MATCHING_NUMBER = "[0-9]";

    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String firstFileName, String secondFileName) {
                String firstHead = firstFileName.split(PATTERN_MATCHING_NUMBER)[0];
                String secondHead = secondFileName.split(PATTERN_MATCHING_NUMBER)[0];



                int result = firstHead.toLowerCase().compareTo(secondHead.toLowerCase());

                if (result == 0) {
                    result = findNum(firstFileName, firstHead) - findNum(secondFileName, secondHead);
                }

                return result;
            }
        });

        return files;
    }

    private int findNum(String fileName, String head) {
        String getNumber = fileName.replace(head, "");
        StringBuilder sb = new StringBuilder();
        for (char element : getNumber.toCharArray()) {
            if (isNumber(element) && isNumberLessThanFive(sb)) {
                sb.append(element);
            } else {
                break;
            }
        }
        int result = Integer.parseInt(sb.toString());
        return result;
    }

    private boolean isNumber(char element) {
        return Character.isDigit(element);
    }

    private boolean isNumberLessThanFive(StringBuilder sb) {
        return sb.length() < 5;
    }


    public static void main(String[] args) {
        SortFileName sortFileName = new SortFileName();
        String[] files = {
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
        };
        //"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        for (String element : sortFileName.solution(files)) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
