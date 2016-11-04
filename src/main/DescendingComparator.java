package main;

import java.util.Comparator;


public class DescendingComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer value1, Integer value2) {
        if(value1.intValue() < value2.intValue()) {
            return -1;
        } else if(value1.intValue() > value2.intValue()){
            return 1;
        } else {
            return 0;
        }
    }
}
