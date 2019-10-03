package com.nagraj.buses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {
    JSONArray contactList;

    public RecyclerAdapter(List<Route> route) {
        try {

            String json = new Gson().toJson(route);
            this.contactList = new JSONArray(json);
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
            JSONObject c = contactList.getJSONObject(position);

            holder.operatorName.setText(c.getString("operator"));


        } catch (Exception e) {

        }
    }


    @Override
    public int getItemCount() {
        return contactList.length();
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


