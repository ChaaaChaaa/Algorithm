package leetcode;

public class Q70 {
    public static void main(String[] args){
        System.out.println(climbStairs(3)+1);
    }

    public static int climbStairs(int n) {
        if(n <= 1){
            return n;
        }
        else
            return climbStairs(n-1)+climbStairs(n-2);
    }
}
