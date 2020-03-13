import java.util.Scanner;

public class Q9095_2 {
    private static final int methodAboutZero = 0;
    private static final int methodAboutOne = 1;
    private static final int methodsAboutTwo = 2;
    private static final int methodsAboutThree = 4;
    private static final int maximumValue = 11;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int [] dp = new int[maximumValue];

        dp[0] = methodAboutZero;
        dp[1] = methodAboutOne;
        dp[2] = methodsAboutTwo;
        dp[3] = methodsAboutThree;

        for(int i=4; i<maximumValue; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        while (tc>0){
            int n = sc.nextInt();
            System.out.println(dp[n]);
            tc--;
        }
    }
}
