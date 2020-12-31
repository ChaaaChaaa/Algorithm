package leetcode;

public class Q1603 {
    public static void main(String[] args) {
        Q1603 q1603 = new Q1603(1, 2, 0);
        q1603.addCar(1);
    }

    int[] count;

    public Q1603(int big, int medium, int small) {
        count = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (count[carType - 1] > 0) {
            count[carType - 1]--;
            return true;
        }
        return false;
    }
}
