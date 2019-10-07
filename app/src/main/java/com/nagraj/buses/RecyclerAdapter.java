package com.nagraj.buses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {
    Route[] contactList;
        public RecyclerAdapter(List<Route> route) {
        try {

            contactList =route.toArray(new Route[route.size()]);




        } catch (Exception e) {
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item, parent, false);
        return new VH(listItem);
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        try {

            Route   route = contactList[position];
            holder.fare.setText("\u20B9"+String.valueOf(route.getFare()));
            holder.operatorName.setText(route.getOperator());
            holder.seats.setText(String.valueOf(route.getSeatsAvailable())+" Seats");
            holder.departureTime.setText(route.getTripStartTime());
            holder.arrivalTime.setText(route.getTripEndTime());
            String ac,volvo,sleeper;
            ac= route.isIsAc()?"AC":"Non-AC";
            volvo=route.isIsVolvo()?"Volvo":"Non-Volvo";
            sleeper=route.isIsSleeper()?"Full-Sleeper":"Semi-Sleeper";
            holder.luxuryType.setText(ac+", "+volvo+", "+sleeper);




        } catch (Exception e) {

        }
    }


    @Override
    public int getItemCount() {
        return contactList.length;
    }

    public class VH extends RecyclerView.ViewHolder {
        public TextView operatorName, fare, luxuryType, departureTime, seats, arrivalTime;

        public VH(View itemView) {
            super(itemView);
            this.fare = itemView.findViewById(R.id.fare);
            this.operatorName = itemView.findViewById(R.id.operatorName);
            this.luxuryType = itemView.findViewById(R.id.luxuryType);
            this.departureTime = itemView.findViewById(R.id.departureTime);
            this.seats = itemView.findViewById(R.id.seats);
            this.arrivalTime = itemView.findViewById(R.id.arrivalTime);
        }
    }

}


