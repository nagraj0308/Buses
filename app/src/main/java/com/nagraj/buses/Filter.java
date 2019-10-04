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

import java.util.List;

public class Filter extends BottomSheetDialogFragment {
    ButtonSheetlistener buttonSheetlistener;
    Button doneFilter,clearFilter;
    CheckBox ac,nonAc,volvo,nonVolvo,sleeper,semiSleeper;
    RecyclerView recyclerViewOperator;
    List<Route> routes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=inflater.inflate(R.layout.activity_filter,container,false);

        doneFilter=view1.findViewById(R.id.doneFilter);
        clearFilter=view1.findViewById(R.id.clearFilter);
        ac=view1.findViewById(R.id.ac);
        nonAc=view1.findViewById(R.id.nonAc);
        volvo=view1.findViewById(R.id.volvo);
        nonVolvo=view1.findViewById(R.id.nonVolvo);
        sleeper=view1.findViewById(R.id.sleeper);
        semiSleeper=view1.findViewById(R.id.semiSleeper);
        recyclerViewOperator=view1.findViewById(R.id.recyclerViewOperator);


        doneFilterSection();
        clearFilterSection();
        recyclerViewOperatorSection();
        return view1;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    public void clearFilterSection(){
        clearFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ac.setChecked(false);
                nonAc.setChecked(false);
                volvo.setChecked(false);
                nonVolvo.setChecked(false);
                sleeper.setChecked(false);
                semiSleeper.setChecked(false);
            }
        });


    }



    public void doneFilterSection(){
        doneFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSheetlistener.onButtonClick("Button clicked");
                dismiss();
            }
        });
    }

    public interface ButtonSheetlistener{
        void onButtonClick(String string);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            buttonSheetlistener = (ButtonSheetlistener) context;
        }catch (Exception e){

        }

    }
    public void recyclerViewOperatorSection(){
        try {
            LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewOperator.setLayoutManager(llm);
            // recyclerViewOperator.setAdapter(new OperatorRecyclerAdapter(routes));
        }catch (Exception e){

        }
    }
}
