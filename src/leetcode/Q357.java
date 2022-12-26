package leetcode;

public class Q357 {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
    public static int countNumbersWithUniqueDigits(int n) {
        System.out.println(n);
        if(n==0)
            return 1;
        int i=9;
        int ans=9;
        int temp=n;
        while(temp-->1){
            ans*=i--;
        }

        return ans+ countNumbersWithUniqueDigits(n-1);
    }
}
