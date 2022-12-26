package programmers;

public class SteppingStone2 {
    public int solution(int [] stones, int k){
        int answer = Integer.MAX_VALUE;
        System.out.println(stones.length);
        for(int i=0; i<= stones.length-k; i++){
            int temp = i;
            int stone = stones[i];

            for(int j=i; j<i+k; j++){
                if(stones[j] > stone){
                    stone = stones[j];
                    temp = j;
                }
            }
            if(answer > stone){
                answer = stone;
            }
            i = temp;
        }
        return answer;
    }

    public static void main(String[] args){
        int [] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        SteppingStone2 steppingStone = new SteppingStone2();
        System.out.println(steppingStone.solution(stones,k));
    }
}
