package com.nagraj.buses;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

public class OperatorRecyclerAdapter extends RecyclerView.Adapter<OperatorRecyclerAdapter.VH>  {
    String[] operator;
    boolean[] checkedOperators;


    public OperatorRecyclerAdapter(String[] operators,boolean[] checkedOperator) {

        try {
            operator=operators;
            checkedOperators=checkedOperator;

        } catch (Exception e) {
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.operter_list, parent, false);
        return new VH(listItem);
    }


    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        try {
            holder.operatorName.setText(operator[position]);
            if(checkedOperators!=null)
            holder.operatorName.setChecked(checkedOperators[position]);



        } catch (Exception e) {

        }
    }



    @Override
    public int getItemCount() {
        return operator.length;
    }

    public class VH extends RecyclerView.ViewHolder  {
        public AppCompatCheckBox operatorName;

        public VH(View itemView) {
            super(itemView);
            this.operatorName = itemView.findViewById(R.id.operatorName);
            operatorName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Filter.isOperatorChecked[getAdapterPosition()]=b;
                }
            });

        }
    }


}




