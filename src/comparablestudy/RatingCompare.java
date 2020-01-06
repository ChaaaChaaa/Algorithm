package comparablestudy;

import java.util.Comparator;

public class RatingCompare implements Comparator<YearComparable> {

    public int compare(YearComparable m1, YearComparable m2) {
        if (m1.getRating() > m2.getRating()) {
            return 1;
        }
        if (m1.getRating() < m2.getRating()) {
            return -1;
        } else
            return 0;
    }
}