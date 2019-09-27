package com.nagraj.buses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FilterActivity extends AppCompatActivity {
    Button doneFilter,clearFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        setTitle("Select Filter");

        doneFilter=findViewById(R.id.doneFilter);
        clearFilter=findViewById(R.id.clearFilter);
        doneFilterSection();
        clearFilterSection();

    }
    public void doneFilterSection(){
        doneFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
    public void clearFilterSection(){
        clearFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hhhhhh
            }
        });
    }
}
