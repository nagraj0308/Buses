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
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Filter.ButtonSheetlistener,InterfaceClass.ForView {
    Button  fare,departureTime,seats;
    FloatingActionButton gotoFilter;
    List<Route> routes;
    Presenter presenter;
    RecyclerView recyclerView;

    int isIncFare=2,isIncSeat=2,isIncDepTime=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bengaluru to Chennai");

        gotoFilter=findViewById(R.id.gotoFilter);
        fare=findViewById(R.id.fare);
        departureTime=findViewById(R.id.deptTime);
        seats=findViewById(R.id.seats);
        recyclerView=findViewById(R.id.recyclerView);

        sortingSection();
        filterSection();
        initialLoad();

    }
    public void sortingSection(){
        fare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isIncDepTime=2;
                isIncSeat=2;
                fare.setTextColor(getResources().getColor(R.color.yellow));
                departureTime.setTextColor(getResources().getColor(R.color.white));
                departureTime.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
                seats.setTextColor(getResources().getColor(R.color.white));
                seats.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);

                if(isIncFare==2) {
                    isIncFare=1;
                    fare.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.inc),null);


                }else{
                    if (isIncFare == 1) {
                        isIncFare = 0;
                        fare.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.dec),null);
                    }
                    else{
                        isIncFare = 1;
                        fare.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.inc),null);
                    }

                }

            }
        });
        departureTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isIncFare=2;
                isIncSeat=2;
                departureTime.setTextColor(getResources().getColor(R.color.yellow));
                fare.setTextColor(getResources().getColor(R.color.white));
                fare.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
                seats.setTextColor(getResources().getColor(R.color.white));
                seats.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);

                if(isIncDepTime==2) {
                    isIncDepTime=1;
                    departureTime.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.inc),null);


                }else{
                    if (isIncDepTime == 1) {
                        isIncDepTime = 0;
                        departureTime.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.dec),null);
                    }
                    else{
                        isIncDepTime = 1;
                        departureTime.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.inc),null);
                    }

                }

            }
        });
        seats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isIncFare=2;
                isIncDepTime=2;
                seats.setTextColor(getResources().getColor(R.color.yellow));
                fare. setTextColor(getResources().getColor(R.color.white));
                fare.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
                departureTime.setTextColor(getResources().getColor(R.color.white));
                departureTime.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);

                if(isIncSeat==2) {
                    isIncSeat=1;
                    seats.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.inc),null);


                }else{
                    if (isIncSeat == 1) {
                        isIncSeat = 0;
                        seats.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.dec),null);
                    }
                    else{
                        isIncSeat = 1;
                        seats.setCompoundDrawablesWithIntrinsicBounds(null,null,getResources().getDrawable(R.drawable.inc),null);
                    }

                }

            }
        });





    }
    public void filterSection(){
      gotoFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filter filter = Filter.newInstance(routes, true);
                //filter.setTargetFragment(,300);
                filter.show(getSupportFragmentManager(),"exampleBottomsheet");

            }
        });
    }

    public List<Route> getRoutes(){
        return routes;
    }

    @Override
    public void onButtonClick(String string){
        //.setText(string);
    }

    public void callRecycler(List<Route> routeList){
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(new RecyclerAdapter(routeList));



    }

    public void initialLoad(){
        presenter=new Presenter(this);
        presenter.getRoutesData();

    }
    @Override
    public void getObject(List<Route> route){
        routes=route;
        callRecycler(routes);
    }

}
