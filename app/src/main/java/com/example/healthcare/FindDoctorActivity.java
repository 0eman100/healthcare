package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
      exit.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(FindDoctorActivity.this, LoginActivity.class);
              startActivities(new Intent[]{intent});
          }
      });
@SuppressLint({"MissingInflatedId", "LocalSuppress"})
CardView familyphysician=findViewById(R.id.cardFDFamilyPhysician);
familyphysician.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
        it.putExtra("title","family physician");
        startActivities(new Intent[]{it});
    }
});
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        CardView dietician=findViewById(R.id.cardFDDietician);
        familyphysician.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Detician");
                startActivities(new Intent[]{it});
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        CardView dentist=findViewById(R.id.cardFDDentist);
        familyphysician.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivities(new Intent[]{it});
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        familyphysician.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","surgeon");
                startActivities(new Intent[]{it});
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        CardView cardiologists=findViewById(R.id.cardFDCardiologists);
        familyphysician.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","cardiologists");
                startActivities(new Intent[]{it});
            }
        });


    }

}