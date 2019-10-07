package com.nagraj.buses;

import java.util.Comparator;

public class SortByDeptTimeAcc implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        String s1=o1.getTripStartTime().substring(6,7)+o1.getTripStartTime().substring(0,5);
        String s2=o2.getTripStartTime().substring(6,7)+o2.getTripStartTime().substring(0,5);
        return s1.compareToIgnoreCase(s2);
    }
}

