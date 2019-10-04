package com.nagraj.buses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OperatorRecyclerAdapter extends RecyclerView.Adapter<OperatorRecyclerAdapter.VH> {
    Route[] contactList;

    public OperatorRecyclerAdapter(List<Route> route) {
        try {
            contactList = route.toArray(new Route[route.size()]);
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
    public void onBindViewHolder(VH holder, int position) {
        try {

            Route route = contactList[position];
            holder.operatorName.setText(route.getOperator());


        } catch (Exception e) {

        }
    }


    @Override
    public int getItemCount() {
        return contactList.length;
    }

    public class VH extends RecyclerView.ViewHolder {
        public CheckBox operatorName;

        public VH(View itemView) {
            super(itemView);
            this.operatorName = itemView.findViewById(R.id.operatorName);

        }
    }
}




