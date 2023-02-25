package boj;

import java.util.*;

public class Q1043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int partyCnt = sc.nextInt();
        int knowTruthPerson = sc.nextInt();

        boolean[] knowTruePeople = new boolean[people];
        boolean[] knowTrueParty = new boolean[partyCnt];

        List<List<Integer>> allParties = new ArrayList<>();
        List<List<Integer>> attendPeopleInParty = new ArrayList<>(); // 파티에 오는 사람의 수와 번호
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < partyCnt; i++) {
            allParties.add(new ArrayList<>());
            attendPeopleInParty.add(new ArrayList<>());
        }


        for (int i = 0; i < knowTruthPerson; i++) {
            knowTruePeople[sc.nextInt() - 1] = true;
        }

        for (int currentParty = 0; currentParty < partyCnt; currentParty++) {
            int attendPeopleCnt = sc.nextInt();
            for (int attendPeople = 0; attendPeople < attendPeopleCnt; attendPeople++) {
                int attendPersonIndex = sc.nextInt() - 1;
                attendPeopleInParty.get(currentParty).add(attendPersonIndex);
                if (knowTruePeople[attendPersonIndex] && !knowTrueParty[currentParty]) { // 사실을 알고 있는 사람이 있지만 해당 파티가 false일때 true로 바꿔줌
                    knowTrueParty[currentParty] = true;
                    q.offer(currentParty);
                }
                for (int prevParty = 0; prevParty < currentParty; prevParty++) {
                    boolean hasParticipated = attendPeopleInParty.get(prevParty).contains(attendPersonIndex); //이전 파티에 참여한적이 있는지 확인
                    if (hasParticipated) {
                        allParties.get(prevParty).add(currentParty);
                        allParties.get(currentParty).add(prevParty);
                    }
                }
            }
        }


        while (!q.isEmpty()) { 	// 진실을 아는(들은) 사람 갱신
            int partyInTruePerson = q.poll();
            for (int party : allParties.get(partyInTruePerson)) {
                if (!knowTrueParty[party]) {
                    knowTrueParty[party] = true;
                    q.offer(party);
                }
            }
        }

        int result = 0; 	// 지민이가 거짓말을 할 수 있는 파티 개수
        for (int i = 0; i < partyCnt; i++) {
            if (!knowTrueParty[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
}