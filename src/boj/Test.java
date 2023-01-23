package boj;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int [] arr = {1,1,3,3,0,1,1};
        Test test = new Test();
        System.out.println(Arrays.toString(test.solution(arr)));
    }
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        stack.push(arr[0]);

        for(int i=1; i<arr.length; i++){
            while(!stack.isEmpty()&&stack.peek() == arr[i]){
                //System.out.println(stack.peek());
                list.add(stack.peek());
                stack.pop();
            }
            if(!stack.isEmpty()&&stack.peek() != arr[i]){
                list.add(arr[i]);
            }

            stack.push(arr[i]);
        }


        int[] answer = new int[list.size()];

        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
}