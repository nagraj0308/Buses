package com.nagraj.buses;


import java.util.Comparator;

public class SortByFareAcc implements Comparator<Route> {
        @Override
        public int compare(Route o1, Route o2) {
            return o1.getFare()-o2.getFare();
        }
    }

