package programmers;



public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                System.out.println("i :"+i);
                //printList(computers);
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }

    boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && check[j] == false) {
                check = dfs(computers, j, check);
            }
        }
        return check;
    }

    public static void main(String[] args){
        Network network = new Network();
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        int result = network.solution(n,computers);
        System.out.println(result);
    }

    private void printList(int[][] computers){
        for (int i = 0; i < computers.length * computers[0].length; i++) {
            int row = i / computers[0].length; // 행
            int column = i % computers[0].length; // 열
            System.out.print(computers[row][column] + "\t");


            if (column == computers[0].length - 1) {
                System.out.println();
            }
        }
    }

}
