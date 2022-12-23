package leetcode;

public class Q48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);

        for(int [] num: matrix){
            for(int num2 : num){
                System.out.print(num2+" ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
       int n = matrix.length;
       
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
