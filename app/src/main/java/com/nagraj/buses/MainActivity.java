package com.nagraj.buses;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements Filter.ButtonSheetlistener {
    Button  fare,departureTime,seats;
    FloatingActionButton gotoFilter;

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

        sortingSection();
        filterSection();

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
                Filter bottomSheetDialogDemo=new Filter();
                bottomSheetDialogDemo.show(getSupportFragmentManager(),"exampleBottomsheet");
            }
        });
    }


    @Override
    public void onButtonClick(String string){
        //.setText(string);
    }
}
