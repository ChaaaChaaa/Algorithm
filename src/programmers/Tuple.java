package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Tuple {

    private static final String PARENTHESIS = "},\\{";
    private static final String COMMA = ",";
    private static final int FIRST_RIGHT_PARENTHESIS = 0;
    private static final int FIRST_LEFT_PARENTHESIS = 2;
    private static final int FIRST_ARRAY_ELEMENT = 0;
    private static final int LAST_RIGHT_PARENTHESIS = 0;
    private static final int LAST_LEFT_PARENTHESIS = 2;

    public int[] solution(String s) {

        String[] sArr = s.split(PARENTHESIS);
        sArr[FIRST_ARRAY_ELEMENT] = sArr[FIRST_ARRAY_ELEMENT].substring(FIRST_LEFT_PARENTHESIS);

        int arraySize = sArr.length - 1;

        sArr[arraySize] = sArr[arraySize].substring(LAST_RIGHT_PARENTHESIS, sArr[arraySize].length() - LAST_LEFT_PARENTHESIS);

        System.out.println("1 : ");
        test(sArr);
        Arrays.sort(sArr, (s1, s2) -> s1.length() - s2.length());
        System.out.println("2 : ");
        test(sArr);
        int[] answer = new int[sArr.length];
        int index = 0;

        Set<String> hashSet = new HashSet<>();
        for (String str : sArr) {

            String strArr[] = str.split(COMMA);
            for (String ansValue : strArr) {
                if (hashSet.add(ansValue)) {
                    answer[index] = Integer.parseInt(ansValue);
                    index++;
                }
            }
        }
        return answer;
    }

    private void test( String[] sArr){
        for(String element : sArr){
            System.out.print(element+" ");
        }
        System.out.println();
    }




    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";


        Tuple tuple = new Tuple();

        for (int element : tuple.solution(s)) {
            System.out.print(element + " ");
        }


        // System.out.println( );
    }

}


