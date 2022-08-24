package inflearn;

public class Q23 {
    public int q23(int n, int[][] arr){
        int ans=0, max = Integer.MAX_VALUE;
        for(int student1=1; student1<=n; student1++){
            int cnt=0;
            for(int student2=1; student2<=n; student2++){
                for(int grade=1; grade<=5; grade++){
                    if(arr[student1][grade] == arr[student2][grade]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max = cnt;
                ans = student1;
            }
        }
        return ans;
    }
}
