package programmers;

public class TargetNumber {
    int size;
    int target;
    int answer;
    int[] numbers;

    public int solution(int[] numbers, int target){
        init(numbers,target);
       // System.out.println("가 numbers[0]*1 : "+numbers[0]*1);
        dfs(numbers[0]*1,1);
      //  System.out.println("나 numbers[0]*-1 : "+numbers[0]*-1);
        dfs(numbers[0]*-1,1);
        return answer;
    }

    private void init(int[] numbers, int target){
        this.numbers = numbers;
        this.target = target;
        size=numbers.length;
        answer = 0;
    }

    private void dfs(int sum, int index){

        if(index == size && sum == target){
           // System.out.println("sum: "+sum+" idx: "+ (index-1));
            answer++;
        }

        else if(index < size){
           // System.out.println("다 numbers[index]+ : "+numbers[index]+ " sum: "+sum +" sum+numbers[index]:"+(sum+numbers[index])+" index: "+ index);
            dfs(sum+numbers[index], index+1);
          //  System.out.println("라 numbers[index]- : "+numbers[index]+ " sum: "+sum +" sum-numbers[index]:"+(sum-numbers[index])+" index : "+index);
            dfs(sum-numbers[index], index+1);
        }
    }

    public static void main(String[] args){
        TargetNumber targetNumber = new TargetNumber();
        int [] numbers = {1,2,3};
        int result = targetNumber.solution(numbers,2);
        //System.out.println("**********"+result+"*********");
    }
}
