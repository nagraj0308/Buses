package com.nagraj.buses;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Filter extends BottomSheetDialogFragment {
    private ButtonSheetlistener buttonSheetlistener;
    private Button doneFilter, clearFilter;
    private CheckBox ac, nonAc, volvo, nonVolvo, sleeper, semiSleeper;
    RecyclerView recyclerViewOperator;
    ArrayList<Route> routeArrayList = new ArrayList<>();
    public static boolean[] isOperatorChecked;
    boolean[] filterValues=new boolean[6];

    Route[] routeList;
    Set<String> set = new HashSet<>();
    String[] operator;


    public static Filter newInstance(List<Route> routes, boolean isFrom) {
        Filter fragment = new Filter();
        Bundle argument = new Bundle();
        argument.putBoolean("isFrom", isFrom);
        fragment.setArguments(argument);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.activity_filter, container, false);

        routeArrayList =(ArrayList<Route>) ((MainActivity)getActivity()).getRoutes();
        routeList = routeArrayList.toArray(new Route[routeArrayList.size()]);
        setOperators();
        operator=new String[set.size()];
        System.arraycopy(set.toArray(), 0, operator, 0, set.size());
        Arrays.sort(operator);
        isOperatorChecked=new boolean[set.size()];


        doneFilter = view1.findViewById(R.id.doneFilter);
        clearFilter = view1.findViewById(R.id.clearFilter);
        ac = view1.findViewById(R.id.ac);
        nonAc = view1.findViewById(R.id.nonAc);
        volvo = view1.findViewById(R.id.volvo);
        nonVolvo = view1.findViewById(R.id.nonVolvo);
        sleeper = view1.findViewById(R.id.sleeper);
        semiSleeper = view1.findViewById(R.id.semiSleeper);
        recyclerViewOperator = view1.findViewById(R.id.recyclerViewOperator);


        doneFilterSection();
        clearFilterSection();
        recyclerViewOperatorSection();
        return view1;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }


    public void clearFilterSection() {
        clearFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ac.setChecked(false);
                nonAc.setChecked(false);
                volvo.setChecked(false);
                nonVolvo.setChecked(false);
                sleeper.setChecked(false);
                semiSleeper.setChecked(false);
                recyclerViewOperator.setAdapter(new OperatorRecyclerAdapter(operator));
                for (int i=0;i<isOperatorChecked.length;i++) {
                    isOperatorChecked[i]=false;

                }
            }
        });


    }


    public void doneFilterSection() {
        doneFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSheetlistener.onButtonClick("Button clicked");
                setFilterValues();
                onDismiss();
                dismiss();
            }
        });
    }

    public interface ButtonSheetlistener {
        void onButtonClick(String string);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            buttonSheetlistener = (ButtonSheetlistener) context;
        } catch (Exception e) {

        }

    }

    public void recyclerViewOperatorSection() {
        try {
            LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewOperator.setLayoutManager(llm);
            recyclerViewOperator.setAdapter(new OperatorRecyclerAdapter(operator));
        } catch (Exception e) {

        }
    }

    public void setOperators(){
        for(Route contact :routeList){
            set.add(contact.getOperator());
        }
    }
    public void onDismiss(){
        MainActivity m1 = (MainActivity) getActivity();
        m1.getDataFromFilter(filterValues,isOperatorChecked,operator);



    }
    public void setFilterValues(){
        filterValues[0]=ac.isChecked();
        filterValues[1]=nonAc.isChecked();
        filterValues[2]=volvo.isChecked();
        filterValues[3]=nonVolvo.isChecked();
        filterValues[4]=sleeper.isChecked();
        filterValues[5]=semiSleeper.isChecked();
    }
}
