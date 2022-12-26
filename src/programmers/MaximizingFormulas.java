package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MaximizingFormulas {
    static String[] operators = {"+", "-", "*"};
    static boolean[] visit;
    static int[] procedureOperators;
    static LinkedList<String> linkedList;
    static long max = 0;

    public static void main(String[] args){
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        visit = new boolean[3];
        procedureOperators = new int[3];
        String[] inputOperators = expression.split("");
        linkedList = new LinkedList<>();
        String number = "";

        for (int i = 0; i < inputOperators.length; i++) {
            if (inputOperators[i].equals("*") || inputOperators[i].equals("+") ||
                    inputOperators[i].equals("-")) {
                linkedList.add(number);
                linkedList.add(inputOperators[i]);
                number = "";
                // 0 :100, 1:-, 2:200, 3:*, 4:300
            } else {
                number += inputOperators[i];
            }
        }
        linkedList.add(number);
        dfs(0);
        return max;
    }

    private static void dfs(int index) {
        if (index == 3) {
            makeNewList();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visit[i]) {
                visit[i] = true;
                procedureOperators[index] = i;
                //0 : 0, 1:1, 2:2
                //0 : 0, 1:2, 2:1
                dfs(index + 1);
                visit[i] = false;
            }
        }
    }

    private static void makeNewList() {
        LinkedList<String> copyList = new LinkedList<>();
        copyList.addAll(linkedList);

        for (int i = 0; i < 3; i++) {
            String operator = operators[procedureOperators[i]];
            //i=0 : +
            for (int j = 0; j < copyList.size(); j++) {
                if (copyList.get(j).equals(operator)) {
                    Long getCalResult = calculator(operator, copyList.get(j - 1), copyList.get(j + 1));
                    copyList.remove(j - 1);
                    copyList.remove(j - 1);
                    copyList.remove(j - 1);
                    copyList.add(j - 1, getCalResult + "");
                    j = j - 1;
                }
            }
        }

        long k = Long.parseLong(copyList.get(0));
        max = Math.max(max, Math.abs(k));
    }

    private static Long calculator(String operator, String a, String b) {
        if (operator.equals("*")) {
            return Long.parseLong(a) * Long.parseLong(b);
        } else if (operator.equals("+")) {
            return Long.parseLong(a) + Long.parseLong(b);
        } else {
            return Long.parseLong(a) - Long.parseLong(b);
        }
    }
}
