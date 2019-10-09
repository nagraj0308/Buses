package com.nagraj.buses;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements Filter.ButtonSheetlistener, InterfaceClass.ForView {
    Button fare, departureTime, seats;
    FloatingActionButton gotoFilter;
    List<Route> routes, filteredRouteList, latestRouteList;
    List<String> checkedOperatorList;
    Presenter presenter;
    RecyclerView recyclerView;


    boolean[] isOperatorChecked;
    boolean[] filterValues;
    String[] operators;
    int isIncFare = 2, isIncSeat = 2, isIncDepTime = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bengaluru to Chennai");

        gotoFilter = findViewById(R.id.gotoFilter);
        fare = findViewById(R.id.fare);
        departureTime = findViewById(R.id.deptTime);
        seats = findViewById(R.id.seats);
        recyclerView = findViewById(R.id.recyclerView);

        sortingSection();
        filterSection();
        initialLoad();

    }

    public void sortingSection() {
        fare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isIncDepTime = 2;
                isIncSeat = 2;
                fare.setTextColor(getResources().getColor(R.color.yellow));
                departureTime.setTextColor(getResources().getColor(R.color.white));
                departureTime.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                seats.setTextColor(getResources().getColor(R.color.white));
                seats.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                if (isIncFare == 2) {
                    isIncFare = 1;
                    fare.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.inc), null);
                    Collections.sort(latestRouteList, new SortByFareAcc());
                    callRecycler(latestRouteList);


                } else {
                    if (isIncFare == 1) {
                        isIncFare = 0;
                        fare.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.dec), null);
                        Collections.sort(latestRouteList, new SortByFareDec());
                        callRecycler(latestRouteList);
                    } else {
                        isIncFare = 1;
                        fare.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.inc), null);
                        Collections.sort(latestRouteList, new SortByFareAcc());
                        callRecycler(latestRouteList);
                    }

                }

            }
        });
        departureTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isIncFare = 2;
                isIncSeat = 2;
                departureTime.setTextColor(getResources().getColor(R.color.yellow));
                fare.setTextColor(getResources().getColor(R.color.white));
                fare.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                seats.setTextColor(getResources().getColor(R.color.white));
                seats.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                if (isIncDepTime == 2) {
                    isIncDepTime = 1;
                    departureTime.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.inc), null);
                    Collections.sort(latestRouteList, new SortByDeptTimeAcc());
                    callRecycler(latestRouteList);

                } else {
                    if (isIncDepTime == 1) {
                        isIncDepTime = 0;
                        departureTime.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.dec), null);
                        Collections.sort(latestRouteList, new SortByDeptTimeDec());
                        callRecycler(latestRouteList);
                    } else {
                        isIncDepTime = 1;
                        departureTime.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.inc), null);
                        Collections.sort(latestRouteList, new SortByDeptTimeAcc());
                        callRecycler(latestRouteList);
                    }

                }

            }
        });
        seats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isIncFare = 2;
                isIncDepTime = 2;
                seats.setTextColor(getResources().getColor(R.color.yellow));
                fare.setTextColor(getResources().getColor(R.color.white));
                fare.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                departureTime.setTextColor(getResources().getColor(R.color.white));
                departureTime.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                if (isIncSeat == 2) {
                    isIncSeat = 1;
                    seats.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.inc), null);
                    Collections.sort(latestRouteList, new SortBySeatsAcc());
                    callRecycler(latestRouteList);

                } else {
                    if (isIncSeat == 1) {
                        isIncSeat = 0;
                        seats.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.dec), null);
                        Collections.sort(latestRouteList, new SortBySeatsDec());
                        callRecycler(latestRouteList);
                    } else {
                        isIncSeat = 1;
                        seats.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.inc), null);
                        Collections.sort(latestRouteList, new SortBySeatsAcc());
                        callRecycler(latestRouteList);
                    }

                }

            }
        });


    }

    public void filterSection() {
        gotoFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filter filter = Filter.newInstance(routes, true);
                filter.show(getSupportFragmentManager(), "exampleBottomsheet");

            }
        });
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public boolean[] getFilterValues() {
        return filterValues;
    }
    public boolean[]getIsOperatorChecked(){
        return isOperatorChecked;
    }

    @Override
    public void onButtonClick(String string) {
        //.setText(string);
    }

    public void callRecycler(List<Route> routeList) {
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(new RecyclerAdapter(routeList));
    }

    public void initialLoad() {
        presenter = new Presenter(this);
        presenter.getRoutesData();

    }

    @Override
    public void getObject(List<Route> route) {
        routes = route;
        latestRouteList = new ArrayList<>();
        latestRouteList.addAll(routes);
        callRecycler(latestRouteList);
    }

    public void getDataFromFilter(boolean[] booleanFilters, boolean[] booleanOperators, String[] stringOperators) {
        fare.setTextColor(getResources().getColor(R.color.white));
        fare.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        seats.setTextColor(getResources().getColor(R.color.white));
        seats.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        departureTime.setTextColor(getResources().getColor(R.color.white));
        departureTime.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        isIncFare = 2;
        isIncSeat = 2;
        isIncDepTime = 2;

        filterValues = booleanFilters;
        isOperatorChecked = booleanOperators;
        operators = stringOperators;
        listCheckedOperator();
        applyFilter();
        latestRouteList = new ArrayList<>();
        latestRouteList.addAll(filteredRouteList);
        callRecycler(latestRouteList);

    }

    public void applyFilter() {
        filteredRouteList = new ArrayList();

        Route[] route1 = routes.toArray(new Route[routes.size()]);
        for (Route route : route1) {
            if (((filterValues[0] == filterValues[1]) || (filterValues[0] && route.isIsAc()) || (!route.isIsAc() && filterValues[1])) && ((filterValues[2] == filterValues[3]) || (route.isIsVolvo() && filterValues[2]) || (!route.isIsVolvo() && filterValues[3])) && ((filterValues[4] == filterValues[5]) || (route.isIsSleeper() && filterValues[4]) || (!route.isIsSleeper() && filterValues[5]))) {
                if (checkedOperatorList.contains(route.getOperator())) {
                    filteredRouteList.add(route);
                }
            }
        }
        Log.e("TAG", (filterValues[0]) + String.valueOf(filterValues[2]) + "Items" + filteredRouteList.size());
        for (int i = 0; i < isOperatorChecked.length; i++) {

            Log.e("TAG1", "p " + i + (" " + isOperatorChecked[i]));


        }

        for (String string : checkedOperatorList) {

            Log.e("TAG1", "\n" + string);


        }

    }

    public void listCheckedOperator() {
        checkedOperatorList = new ArrayList<>();
        int i = 0;
        for (String string : operators) {
            if (isOperatorChecked[i]) {
                checkedOperatorList.add(string);
            }
            i++;

        }
        if (checkedOperatorList.size() == 0) {
            checkedOperatorList = Arrays.asList(operators);
        }

    }


}
