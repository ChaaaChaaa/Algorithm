package sort;

import java.util.Scanner;

public class Q2959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rectangle = new int[4];
        for (int i = 0; i < rectangle.length; i++) {
            rectangle[i] = sc.nextInt();
        }
        Turtle turtle = new Turtle(rectangle);
        turtle.selectionSort();
        System.out.print(turtle.makeRectangle());

    }
}

class Turtle {
    private int[] rectangle;

    Turtle(int[] rectangle) {
        this.rectangle = rectangle;
    }

    void selectionSort() {

        for (int i = 0; i < rectangle.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < rectangle.length; j++) {
                if (rectangle[j] < rectangle[min]) {
                    min = j;
                }
            }
            sort(i, min, rectangle);
        }
    }

    private void sort(int i, int j, int[] rectangle) {
        int temp = rectangle[i];
        rectangle[i] = rectangle[j];
        rectangle[j] = temp;
    }

    int makeRectangle() {
        return rectangle[0] * rectangle[2];
    }
}
