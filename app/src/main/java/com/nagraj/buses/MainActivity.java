package com.nagraj.buses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button gotoFilter,sortButton;
    Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bengaluru to Chennai");

        gotoFilter=findViewById(R.id.gotoFilter);
        sortButton=findViewById(R.id.sortButton);

        filterSection();
        sortingSetion();

    }
    public void filterSection(){
        gotoFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FilterActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
    public void sortingSetion(){
        frag = getSupportFragmentManager().findFragmentById(R.id.sortingFragment);
        frag.getView().setVisibility(View.GONE);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (frag.isVisible()) {
                    frag.getView().setVisibility(View.GONE);
                    sortButton.setBackgroundResource(R.drawable.buttonlight);
                    sortButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                else {
                    frag.getView().setVisibility(View.VISIBLE);
                    sortButton.setBackgroundResource(R.drawable.button);
                    sortButton.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
    }
}
