package comparablestudy;

public class YearComparable implements Comparable<YearComparable> {
    private double rating;
    private String name;
    private int year;
    private int age;

    YearComparable(String nm, double rt, int yr, int age) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
        this.age = age;
    }

//    public int compareTo(Movie_Comparable m) {
//
//        return m.year - this.year;
//    }

    public int compareTo(YearComparable m) {
        if (this.year < m.year) {
            return 1;
        } else if (this.year == m.year) {
            return 0;
        } else
            return -1;
    }

    double getRating() {
        return rating;
    }

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }

    int getAge() {
        return age;
    }
}
