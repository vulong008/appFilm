package com.example.appfilm.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfilm.R;
import com.example.appfilm.adapter.CinemaAdapter;
import com.example.appfilm.adapter.TimeAdapter;
import com.example.appfilm.interfaces.TimeInterface;
import com.example.appfilm.presenter.Time;
import com.example.appfilm.presenter.TimePresenter;

import java.util.Calendar;
import java.util.List;

public class TimeActivity extends AppCompatActivity implements TimeInterface {
    EditText edtNgay;
    EditText edtGio;
    TimePresenter timePresenter;
    TimeAdapter timeAdapter;
    ListView lvKhungio;
    int idFilm,idCinema;
    Button btnTieptuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        edtNgay = findViewById(R.id.edtNgay);
        edtGio = findViewById(R.id.edtGio);
        btnTieptuc = findViewById(R.id.btnTieptuc);
        Intent intent = getIntent();
        idFilm = intent.getIntExtra("idFilm",-1);
        idCinema = intent.getIntExtra("idCinema",-1);

        edtNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetDate();
            }
        });

        edtGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetTime();
            }
        });

        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TimeActivity.this,SeatActivity.class));
            }
        });

    }

    private void SetDate(){
        Calendar c = Calendar.getInstance();
        int day=c.get(Calendar.DAY_OF_MONTH);
        int month =c.get(Calendar.MONTH);
        int year =c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                edtNgay.setText(i2 + "-" + (i1 + 1) + "-" + i);
            }
        }, year,month,day);
        datePickerDialog.show();
    }


    private void SetTime(){

        TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                edtGio.setText(i+":"+i1);
            }
        },0,0,true);
        timePickerDialog.show();

    }

    @Override
    public void OnSuccessTime(List<Time> times) {
//        timeAdapter = new TimeAdapter(R.layout.item_list,TimeActivity.this,times,idFilm,idCinema);
//        lvKhungio.setAdapter(timeAdapter);
    }
}