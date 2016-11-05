package main.Comparators;

import java.util.Comparator;


public class Ascending implements Comparator<Integer> {

    @Override
    public int compare(Integer value1, Integer value2) {
        if(value1 < value2) {
            return 1;
        } else if (value1 > value2) {
            return -1;
        } else {
            return 0;
        }
    }
}