package programmers;

import java.util.*;

public class CandidateKey {
    public int solution(String[][] relation) {
        int colLen = relation[0].length;
        int rowLen = relation.length;
        HashSet<String> selects = new HashSet<>();
        HashSet<Integer> candidates = new HashSet<>();

        for (int bitmap = 1; bitmap < (1 << colLen); bitmap++) {
            System.out.println("1 bitmap : "+bitmap+" (1 << colLen) :"+(1 << colLen));
            System.out.println(selects.size());
            selects.clear();
            System.out.println(selects.size());
            for (int r = 0; r < rowLen; r++) {
                System.out.println("2. r : " +r+" rowLen :" +rowLen);
                String data = "";
                for (int th = 0; th < colLen; th++) {
                    System.out.println("3. th : "+th+" colLen :" +colLen);
                    if ((bitmap & (1 << th)) != 0) {
                        System.out.println("4. bitmap : "+bitmap+" (1 << th) :" +(1 << th)+" data : "+data+" r :"+r+" th : "+th+" relation[r][th] : "+relation[r][th]);
                        data += relation[r][th] + ",";
                    }
                }
                selects.add(data);
            }
            if(selects.size() == rowLen){
                System.out.println("5. push");
                push(candidates,bitmap);
                System.out.println(candidates);
            }
        }
        return candidates.size();
    }

    private void push(HashSet<Integer> candidate, int set){
        for(int key : candidate){
            System.out.println(key+","+set);
            if((key & set) == key){
                return;
            }
        }
        candidate.add(set);
    }

    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}
                , {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}
                , {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};

        int result = candidateKey.solution(relation);
        System.out.println(result);
    }
}
