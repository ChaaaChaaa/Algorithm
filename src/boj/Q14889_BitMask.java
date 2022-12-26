package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Q14889_BitMask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] teamAbility = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                teamAbility[i][j] = sc.nextInt();
            }
        }

        StartAndLinkBitMask startAndLinkBitMask = new StartAndLinkBitMask(num, teamAbility);
        startAndLinkBitMask.aa();
    }
}

class StartAndLinkBitMask {
    private int num;
    private int ans = -1;
    private int[][] teamAbility;

    StartAndLinkBitMask(int num, int[][] teamAbility) {
        this.num = num;
        this.teamAbility = teamAbility;
    }


    void aa() {
        for (int i = 0; i < ((1 << num)); i++) {
            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>();

            divideTeamMember(i, first, second);

            if (first.size() != num / 2) {
                continue; //다시 제어문 처음으로
            }

            inputEachTeam(first, second);

        }
        System.out.println(ans);
    }

    private void divideTeamMember(int i, ArrayList<Integer> first, ArrayList<Integer> second) {
        for (int j = 0; j < num; j++) {
            if ((i & (1 << j)) == 0) { //0이면 없다
                first.add(j);
            }
            if ((i & (1 << j)) != 0) {
                second.add(j);
            }
        }
    }


    private void inputEachTeam(ArrayList<Integer> first, ArrayList<Integer> second) {
        int team1 = 0;
        int team2 = 0;

        for (int l1 = 0; l1 < num / 2; l1++) {
            for (int l2 = 0; l2 < num / 2; l2++) {
                if (l1 == l2) { //같으면 0
                    continue;
                }
                team1 += teamAbility[first.get(l1)][first.get(l2)];
                team2 += teamAbility[second.get(l1)][second.get(l2)];
            }
        }

        getResult(team1, team2);
    }

    private void getResult(int team1, int team2) {
        int diff = Math.abs(team1 - team2);
        if (ans == -1 || ans > diff) {
            ans = diff;
        }
    }
}