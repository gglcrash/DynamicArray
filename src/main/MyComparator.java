package main;

import java.util.Comparator;


public class MyComparator implements Comparator<Integer> {

    private boolean ascending;
    public MyComparator(boolean ascend){
        ascending = ascend;
    }
    @Override
    public int compare(Integer value1, Integer value2) {
        if(value1.intValue() < value2.intValue()) {
            if(ascending) {
                return 1;
            } else {
                return -1;
            }
        } else if (value1.intValue() > value2.intValue()) {
            if(ascending) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
}
