package com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
Button btnData,btnSearchData,btnUpdelete,btnRegisterData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnData=findViewById(R.id.btnData);
        btnSearchData=findViewById(R.id.btnSearchData);
        btnUpdelete=findViewById(R.id.btnUpdelete);
        btnRegisterData=findViewById(R.id.btnRegisterData);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnRegisterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnSearchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,SearchActivity.class);

                startActivity(intent);
            }
        });


        btnUpdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,UpdateDeleteActivity.class);
                startActivity(intent);
            }
            });
    }
}
