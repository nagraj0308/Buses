package com.nagraj.buses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class SortFragment extends Fragment {
    ImageView seatsUnbookedImg,fareImg,depTimeImg;

    int isIncFare=2,isIncSeat=2,isIncDepTime=2;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sort, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        seatsUnbookedImg=view.findViewById(R.id.seatsUnbookedImg);
        fareImg=view.findViewById(R.id.fareImg);
        depTimeImg=view.findViewById(R.id.depTimeImg);

        sortingSection();
    }
    public void sortingSection(){


        fareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isIncDepTime=2;
                isIncSeat=2;
                depTimeImg.setImageDrawable(getResources().getDrawable(R.drawable.no));
                seatsUnbookedImg.setImageDrawable(getResources().getDrawable(R.drawable.no));

                if(isIncFare==2) {
                    isIncFare=1;
                    fareImg.setImageDrawable(getResources().getDrawable(R.drawable.inc));

                }else{
                    if (isIncFare == 1) {
                        isIncFare = 0;
                        fareImg.setImageDrawable(getResources().getDrawable(R.drawable.dec));
                    }
                    else{
                        isIncFare = 1;
                        fareImg.setImageDrawable(getResources().getDrawable(R.drawable.inc));
                    }

                }

            }
        });

        depTimeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isIncFare=2;
                isIncSeat=2;
                fareImg.setImageDrawable(getResources().getDrawable(R.drawable.no));
                seatsUnbookedImg.setImageDrawable(getResources().getDrawable(R.drawable.no));

                if(isIncDepTime==2) {
                    isIncDepTime=1;
                    depTimeImg.setImageDrawable(getResources().getDrawable(R.drawable.inc));

                }else{
                    if (isIncDepTime == 1) {
                        isIncDepTime = 0;
                        depTimeImg.setImageDrawable(getResources().getDrawable(R.drawable.dec));
                    }
                    else{
                        isIncDepTime = 1;
                        depTimeImg.setImageDrawable(getResources().getDrawable(R.drawable.inc));
                    }

                }

            }
        });

        seatsUnbookedImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isIncFare=2;
                isIncDepTime=2;
                fareImg.setImageDrawable(getResources().getDrawable(R.drawable.no));
                depTimeImg.setImageDrawable(getResources().getDrawable(R.drawable.no));

                if(isIncSeat==2) {
                    isIncSeat=1;
                    seatsUnbookedImg.setImageDrawable(getResources().getDrawable(R.drawable.inc));

                }else{
                    if (isIncSeat == 1) {
                        isIncSeat = 0;
                        seatsUnbookedImg.setImageDrawable(getResources().getDrawable(R.drawable.dec));
                    }
                    else{
                        isIncSeat = 1;
                        seatsUnbookedImg.setImageDrawable(getResources().getDrawable(R.drawable.inc));
                    }

                }

            }
        });

    }


}
