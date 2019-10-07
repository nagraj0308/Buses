package com.nagraj.buses;


import java.util.Comparator;

public class SortByFareDec implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        return o2.getFare()-o1.getFare();
    }
}

