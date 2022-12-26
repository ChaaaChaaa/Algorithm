package programmers;

import java.util.HashMap;

public class TakeAPicture2 {
    private static final Character [] kakaoFriends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static HashMap<Character, Integer> hm;
    static int[] permute ;
    static boolean[] selected ;
    static int count;

    public int solution(int n, String[] data) {
        // 캐릭터마다 새로운 번호를 매칭
        hm = new HashMap<>();

        for(int i=0; i<kakaoFriends.length; i++){
            hm.put(kakaoFriends[i],i);
        }

        int size  = kakaoFriends.length;

        permute = new int[size];
        selected = new boolean[size];
        count = 0;

        dfs(0,  data);

        return count;
    }



    // permute에서 pos번째 케릭터의 위치를 고른다.
    private void dfs(int pos, String[] data) {
        int size  = kakaoFriends.length;
        if(pos == size) { // 하나의 permute이 완성
            char compare;
            int c1, c2, digit;
            for(int i = 0 ; i < data.length ; i++) {
                c1 = permute[hm.get(data[i].charAt(0))];
                c2 = permute[hm.get(data[i].charAt(2))];
                compare = data[i].charAt(3);
                digit = data[i].charAt(4)-'0';
                if(compare == '>') {
                    if(Math.abs(c1-c2) -1 <= digit)
                        return;
                }else if(compare == '<') {
                    if(Math.abs(c1-c2) -1  >= digit)
                        return;
                }else {
                    if(Math.abs(c1-c2) - 1 != digit)
                        return;
                }
            }
            count++;
            return;
        }

        // pos번째 캐릭터가 위치 가능한 모든 i
        for(int i = 0 ; i < size ; i++) {
            if(!selected[i]) {
                selected[i] = true;
                permute[pos] = i;
                dfs(pos+1, data);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args){

        TakeAPicture2 takeAPicture = new TakeAPicture2();
        String [] data = {"N~F=0", "R~T>2"};
        int n = 2;
        int result = takeAPicture.solution(n,data);
        System.out.println(result);

    }
}
