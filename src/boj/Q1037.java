package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1037 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int measureNumCount = sc.nextInt();
        FindMeasure findMeasure = new FindMeasure();
        for (int i = 0; i < measureNumCount; i++) {
            int inputMeasureNum = sc.nextInt();
            findMeasure.inputMeasureToTheList(inputMeasureNum);
        }
        findMeasure.sortTheMeasureList();
        findMeasure.findNumFromMeasure();
    }
}

class FindMeasure {

    private ArrayList<Integer> listOfMeasure = new ArrayList<>();

    void inputMeasureToTheList(int inputMeasureNum) {
        listOfMeasure.add(inputMeasureNum);
    }

    void sortTheMeasureList() {
        Collections.sort(listOfMeasure);
    }

    void findNumFromMeasure() {
        int listLength = listOfMeasure.size() - 1;
        int numFromMeasure = listOfMeasure.get(0) * listOfMeasure.get(listLength);
        System.out.print(numFromMeasure);
    }

}