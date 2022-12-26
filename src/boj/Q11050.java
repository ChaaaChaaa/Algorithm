package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        BinomialCoefficient binomialCoefficient = new BinomialCoefficient();

        int numerator = binomialCoefficient.factorial_recursive(n);
        int denominator = binomialCoefficient.factorial_recursive(k) * binomialCoefficient.factorial_recursive(n - k);

        int result = numerator / denominator;

        System.out.print(result);
    }
}

class BinomialCoefficient {
    int factorial_recursive(int inputNum) {
        if (inputNum < 1) {
            return 1;
        } else {
            return inputNum * factorial_recursive(inputNum - 1);
        }
    }

    int factorial_noneRecursiveUseFor(int inputNum) {
        int sum = 1;
        for (int i = inputNum; i > 0; i--) {
            sum *= i;
        }
        return sum;
    }

    int factorial_noneRecursiveUseWhile(int inputNum) {
        int sum = 1;
        while (inputNum > 0) {
            sum = sum * inputNum--;
        }
        return sum;
    }

    int factorial_noneRecursiveUseStack(int inputNum) {
        int sum = 1;
        Stack<Integer> factorialStack = new Stack<>();
        for (int i = 1; i <= inputNum; i++) {
            factorialStack.push(i);
        }
        while (!factorialStack.isEmpty()) {
            sum *= factorialStack.pop();
        }
        return sum;
    }

}
