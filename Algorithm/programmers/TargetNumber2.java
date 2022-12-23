package programmers;

public class TargetNumber2 {
    static int ans = 0;
    public void dfs(int level, int sum, int[] numbers, int target){
        if(level == numbers.length){
            if(sum == target){
                ans++;
            }
        }else{
            dfs(level+1,sum+numbers[level],numbers,target);
            dfs(level+1, sum, numbers, target);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return ans;
    }

    public static void main(String[] args) {
        TargetNumber2 targetNumber2 = new TargetNumber2();
        int [] numbers = {4,1,2,1};
        int target = 4;
        int ans = targetNumber2.solution(numbers,target);
        if(ans == 2){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
