package comparablestudy;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<YearComparable> list = new ArrayList<YearComparable>();
        list.add(new YearComparable("Force Awakens", 8.3, 2015, 15));
        list.add(new YearComparable("Star Wars", 8.7, 1977, 18));
        list.add(new YearComparable("Empire Strikes Back", 8.8, 1980, 13));
        list.add(new YearComparable("Return of the Jedi", 8.4, 1983, 18));

        Collections.sort(list);

        System.out.println("Sorted by year ");
        for (YearComparable year_comparable : list) {
            System.out.println(year_comparable.getYear() + " " + year_comparable.getRating() + " " + year_comparable.getName() + " " + year_comparable.getAge());
        }

        System.out.println();
        System.out.println("Sorted by Rating");
        RatingCompare ratingCompare = new RatingCompare();

        Collections.sort(list, ratingCompare);

        for (YearComparable year_comparable : list) {
            System.out.println(year_comparable.getRating() + " " + year_comparable.getName() + " " + year_comparable.getYear() + " " + year_comparable.getAge());
        }

        System.out.println();
        System.out.println("Sorted by Age");
        AgeComparable ageComparable = new AgeComparable();

        Collections.sort(list, ageComparable);
        for (YearComparable year_comparable : list) {
            System.out.println(year_comparable.getAge() + " " + year_comparable.getName() + " " + year_comparable.getYear() + " " + year_comparable.getRating());
        }
    }
}
