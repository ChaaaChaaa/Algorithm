package leetcode;

public class Q1281 {
    public static void main(String[] args){
        System.out.println(subtractProductAndSum(234));
    }

    public static int subtractProductAndSum(int n) {
       String numbers = String.valueOf(n);
       char [] number = numbers.toCharArray();

       int product = 1;
       int sum = 0;

       for(int i=0; i<number.length; i++){
           sum += number[i] - 48;
           product *= number[i] -48;
       }

       return product-sum;
    }
}
