package comparablestudy;

import java.util.Comparator;

public class AgeComparable implements Comparator<YearComparable> {

    @Override
    public int compare(YearComparable o1, YearComparable o2) {

        return o1.getAge()-o2.getAge();
    }
}
