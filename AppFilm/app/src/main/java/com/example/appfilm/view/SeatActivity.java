package com.example.appfilm.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appfilm.R;
import com.example.appfilm.interfaces.TicketInterface;
import com.example.appfilm.model.PreTicket;
import com.example.appfilm.model.Ticket;
import com.example.appfilm.presenter.SeatPresenter;

import java.util.ArrayList;
import java.util.List;

public class SeatActivity extends AppCompatActivity implements TicketInterface {
    private List<Ticket> ticketList=new ArrayList<>();
    List<String> listSeat= new ArrayList<>();
    
    SeatPresenter seatPresenter= new SeatPresenter(this);

    TextView txtTongTien,txtNameCinema,txtInfTicket;
    Button btnNext;
    Button btnSeat1A,btnSeat2A,btnSeat3A,btnSeat4A,btnSeat5A,btnSeat6A,btnSeat7A,btnSeat8A,btnSeat9A;
    Button btnSeat10A,btnSeat11A,btnSeat12A, btnSeat1B,btnSeat2B,btnSeat3B,btnSeat4B,btnSeat5B;
    Button btnSeat6B,btnSeat7B,btnSeat8B,btnSeat9B,btnSeat10B,btnSeat11B,btnSeat12B,btnSeat1C;
    Button btnSeat2C,btnSeat3C,btnSeat4C,btnSeat5C,btnSeat6C,btnSeat7C,btnSeat8C,btnSeat9C,btnSeat10C;
    Button btnSeat11C,btnSeat12C,btnSeat1D,btnSeat2D,btnSeat3D,btnSeat4D,btnSeat5D,btnSeat6D,btnSeat7D;
    Button btnSeat8D,btnSeat9D,btnSeat10D,btnSeat11D,btnSeat12D,btnSeat1E,btnSeat2E,btnSeat3E,btnSeat4E;
    Button btnSeat5E,btnSeat6E,btnSeat7E, btnSeat8E,btnSeat9E, btnSeat10E, btnSeat11E, btnSeat12E,btnSeat1F,btnSeat2F;
    Button btnSeat3F, btnSeat4F, btnSeat5F,btnSeat6F,btnSeat7F,btnSeat8F,btnSeat9F,btnSeat10F;
    Button btnSeat11F, btnSeat12F,btnSeat1G,btnSeat2G,btnSeat3G,btnSeat4G,btnSeat5G, btnSeat6G,btnSeat7G;
    Button btnSeat8G,btnSeat9G,btnSeat10G,btnSeat11G,btnSeat12G,btnSeat1H,btnSeat2H,btnSeat3H, btnSeat4H;
    Button btnSeat5H, btnSeat6H, btnSeat7H, btnSeat8H,btnSeat9H, btnSeat10H,btnSeat11H,btnSeat12H,btnSeat1I;
    Button btnSeat2I, btnSeat3I,btnSeat4I,btnSeat5I,btnSeat6I,btnSeat7I,btnSeat8I,btnSeat9I,btnSeat10I;
    Button btnSeat11I,btnSeat12I,btnSeat1J,btnSeat2J,btnSeat3J,btnSeat4J,btnSeat5J,btnSeat6J, btnSeat7J;
    Button btnSeat8J, btnSeat9J,btnSeat10J,btnSeat11J,btnSeat12J;
    boolean check1A=false,check2A=false,check3A=false,check4A=false,check5A=false;
    boolean check6A=false,check7A=false,check8A=false,check9A=false,check10A=false,check11A=false;
    boolean check12A=false, check1B=false,check2B=false,check3B=false,check4B=false, check5B=false;
    boolean check6B=false,check7B=false, check8B=false,check9B=false, check10B=false, check11B=false;
    boolean check12B=false, check1C=false,check2C=false,check3C=false,check4C=false,check5F=false;
    boolean check5C=false,check6C=false,check7C=false,check8C=false, check9C=false,check10C=false;
    boolean check11C=false,check12C=false,check1D=false, check2D=false,check3D=false,check4D=false;
    boolean check5D=false,check6D=false,check7D=false,check8D=false,check9D=false,check10D=false;
    boolean check11D=false,check12D=false,check1E=false,check2E=false,check3E=false,check4E=false;
    boolean check5E=false,check6E=false,check7E=false,check8E=false,check9E=false,check10E=false;
    boolean check11E=false,check12E=false,check1F=false,check2F=false,check3F=false,check4F=false;
    boolean check6F=false,check7F=false,check8F=false,check9F=false,check10F=false;
    boolean check11F=false,check12F=false,check1G=false,check2G=false,check3G=false;
    boolean check4G=false,check5G=false,check6G=false, check7G=false,check8G=false;
    boolean check9G=false,check10G=false, check11G=false, check12G=false,check1H=false;
    boolean check2H=false, check3H=false, check4H=false, check5H=false, check6H=false;
    boolean check7H=false, check8H=false, check9H=false, check10H=false, check11H=false;
    boolean check12H=false, check1I=false, check2I=false, check3I=false, check4I=false;
    boolean check5I=false, check6I=false, check7I=false, check8I=false, check9I=false;
    boolean check10I=false, check11I=false, check12I=false,check1J=false, check2J=false;
    boolean check3J=false, check4J=false, check5J=false, check6J=false, check7J=false;
    boolean check8J=false, check9J=false, check10J=false, check11J=false, check12J=false;
    private  int tPrice=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        mapping();
        Intent intent= getIntent();
        int idPhim,idRap,idKhunggio;
        String tenDN;

        idPhim=intent.getIntExtra("idPhim",1);
        idRap=intent.getIntExtra("idRap",1);
        idKhunggio=intent.getIntExtra("idKhunggio",1);
        tenDN=intent.getStringExtra("tenDN");

        seatPresenter.readListTicket(this,idPhim,idRap,idKhunggio);
        seatPresenter.readInfTicket(this,idPhim,idRap,idKhunggio);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SeatActivity.this);
                builder.setTitle("Xác nhận đặt vé?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(SeatActivity.this,MainActivity.class));
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });


    }

    private void clickButton1A(int status,  int price){
        if(status==1){
            btnSeat1A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check1A){
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1A.setBackgroundResource(R.drawable.button_seat3);
                        check1A=true;
                        listSeat.add("01A");
                        
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01A");
                        btnSeat1A.setBackgroundResource(R.drawable.button_seat2);
                        check1A=false;
                        
                    }
                }
            });
        }
    }
    private void clickButton2A(int status,  int price){
        if(status==1){
            btnSeat2A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check2A){
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2A.setBackgroundResource(R.drawable.button_seat3);
                        check2A=true;
                        listSeat.add("02A");
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02A");
                        btnSeat2A.setBackgroundResource(R.drawable.button_seat2);
                        check2A=false;
                    }
                }
            });
        }

    }
    private void clickButton3A(int status,  int price){
        if(status==1){
            btnSeat3A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!check3A){
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3A.setBackgroundResource(R.drawable.button_seat3);
                        check3A=true;
                        listSeat.add("03A");
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03A");
                        btnSeat3A.setBackgroundResource(R.drawable.button_seat2);
                        check3A=false;
                    }
                }
            });
        }

    }
    private void clickButton4A(int status,  int price){
        if(status==1){
            btnSeat4A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check4A){listSeat.add("04A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4A.setBackgroundResource(R.drawable.button_seat3);
                        check4A=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04A");
                        btnSeat4A.setBackgroundResource(R.drawable.button_seat2);
                        check1A=false;
                    }
                }
            });
        }

    }
    private void clickButton5A(int status,  int price){
        if(status==1){
            btnSeat5A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!check5A){listSeat.add("05A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5A.setBackgroundResource(R.drawable.button_seat3);
                        check5A=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05A");
                        btnSeat5A.setBackgroundResource(R.drawable.button_seat2);
                        check5A=false;
                    }
                }
            });
        }

    }
    private void clickButton6A(int status,  int price){
        if(status==1){
            btnSeat6A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check6A){listSeat.add("06A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6A.setBackgroundResource(R.drawable.button_seat3);
                        check6A=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06A");
                        btnSeat6A.setBackgroundResource(R.drawable.button_seat2);
                        check6A=false;
                    }
                }
            });
        }

    }
    private void clickButton7B(int status,  int price){
        if(status==1){
            btnSeat7A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check7B){listSeat.add("07B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7B.setBackgroundResource(R.drawable.button_seat3);
                        check7B=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07B");
                        btnSeat7B.setBackgroundResource(R.drawable.button_seat2);
                        check7B=false;
                    }
                }
            });
        }

    }
    private void clickButton8A(int status,  int price){
        if(status==1){
            btnSeat8A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check8A){listSeat.add("08A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8A.setBackgroundResource(R.drawable.button_seat3);
                        check8A=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08A");
                        btnSeat8A.setBackgroundResource(R.drawable.button_seat2);
                        check8A=false;
                    }
                }
            });
        }

    }
    private void clickButton9B(int status,  int price){
        if(status==1){
            btnSeat9A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check9B){listSeat.add("09B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9B.setBackgroundResource(R.drawable.button_seat3);
                        check9B=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09B");
                        btnSeat9B.setBackgroundResource(R.drawable.button_seat2);
                        check9B=false;
                    }
                }
            });
        }

    }
    private void clickButton10A(int status,  int price){
        if(status==1){listSeat.add("10A");
            btnSeat10A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check10A){listSeat.add("10A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10A.setBackgroundResource(R.drawable.button_seat3);
                        check10A=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10A");
                        btnSeat10A.setBackgroundResource(R.drawable.button_seat2);
                        check10A=false;
                    }
                }
            });
        }

    }
    private void clickButton11A(int status,  int price){
        if(status==1){
            btnSeat11A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check11A){listSeat.add("11A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11A.setBackgroundResource(R.drawable.button_seat3);
                        check11A=true;
                    }
                    else {
                        
                        btnSeat11A.setBackgroundResource(R.drawable.button_seat2);
                        check11A=false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11A");
                    }
                }
            });
        }

    }
    private void clickButton12A(int status,  int price){
        if(status==1){
            btnSeat12A.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12A.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check12A){listSeat.add("12A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12A.setBackgroundResource(R.drawable.button_seat3);
                        check12A=true;
                    }
                    else {

                        btnSeat12A.setBackgroundResource(R.drawable.button_seat2);
                        check12A= false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12A");
                    }
                }
            });
        }

    }
    private void clickButton1B(int status,  int price){
        if(status==1){
            btnSeat1B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check1B){listSeat.add("01B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1B.setBackgroundResource(R.drawable.button_seat3);
                        check1B=true;

                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01B");
                        btnSeat1B.setBackgroundResource(R.drawable.button_seat2);
                        check1B=false;
                    }
                }
            });
        }

    }
    private void clickButton2B(int status,  int price){
        if(status==1){
            btnSeat2B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check2B){listSeat.add("02B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2B.setBackgroundResource(R.drawable.button_seat3);
                        check2B=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02B");
                        btnSeat2B.setBackgroundResource(R.drawable.button_seat2);
                        check2B=false;
                    }
                }
            });
        }

    }
    private void clickButton3B(int status,  int price){
        if(status==1){
            btnSeat3B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check3B){listSeat.add("03B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3B.setBackgroundResource(R.drawable.button_seat3);
                        check3B=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03B");
                        btnSeat3B.setBackgroundResource(R.drawable.button_seat2);
                        check3B=false;
                    }
                }
            });
        }

    }
    private void clickButton4B(int status,  int price){
        if(status==1){
            btnSeat4B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check4B){listSeat.add("04B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4B.setBackgroundResource(R.drawable.button_seat3);
                        check4B=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04B");
                        btnSeat4B.setBackgroundResource(R.drawable.button_seat2);
                        check1A=false;
                    }
                }
            });
        }

    }
    private void clickButton5B(int status,  int price){
        if(status==1){
            btnSeat5B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check5B){listSeat.add("05B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5B.setBackgroundResource(R.drawable.button_seat3);
                        check5B=true;
                    }
                    else {
                        tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05B");
                        btnSeat5B.setBackgroundResource(R.drawable.button_seat2);
                        check5B=false;
                    }
                }
            });
        }

    }
    private void clickButton6B(int status,  int price){
        if(status==1){
            btnSeat6B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check6B){listSeat.add("06B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6B.setBackgroundResource(R.drawable.button_seat3);
                        check6B=true;
                    }
                    else {tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06B");
                        btnSeat6B.setBackgroundResource(R.drawable.button_seat2);
                        check6B=false;
                    }
                }
            });
        }

    }
    private void clickButton7A(int status,  int price){
        if(status==1){
            btnSeat7B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!check7A){listSeat.add("07A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7A.setBackgroundResource(R.drawable.button_seat3);
                        check7A=true;
                    }
                    else {
                        btnSeat7A.setBackgroundResource(R.drawable.button_seat2);
                        check7A= false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07A");
                    }
                }
            });
        }

    }
    private void clickButton8B(int status,  int price){
        if(status==1){
            btnSeat8B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check8B){listSeat.add("08B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8B.setBackgroundResource(R.drawable.button_seat3);
                        check8B=true;
                    }
                    else {
                        btnSeat8B.setBackgroundResource(R.drawable.button_seat2);
                        check8B= false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08B");
                    }
                }
            });
        }

    }
    private void clickButton9A(int status,  int price){
        if(status==1){
            btnSeat9B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check9A){listSeat.add("09A");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9A.setBackgroundResource(R.drawable.button_seat3);
                        check9A=true;
                    }
                    else {
                        btnSeat9A.setBackgroundResource(R.drawable.button_seat2);
                        check9A= false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09A");
                    }
                }
            });
        }

    }
    private void clickButton10B(int status,  int price){
        if(status==1){
            btnSeat10B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check10B){listSeat.add("10B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10B.setBackgroundResource(R.drawable.button_seat3);
                        check10B=true;
                    }
                    else {
                        btnSeat10B.setBackgroundResource(R.drawable.button_seat2);
                        check10B= false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10B");
                    }
                }
            });
        }

    }
    private void clickButton11B(int status,  int price){
        if(status==1){
            btnSeat11B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check11B){listSeat.add("11B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11B.setBackgroundResource(R.drawable.button_seat3);
                        check11B=true;
                    }
                    else {
                        btnSeat11B.setBackgroundResource(R.drawable.button_seat2);
                        check11B= false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11B");
                    }
                }
            });
        }

    }
    private void clickButton12B(int status,  int price){
        if(status==1){
            btnSeat12B.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12B.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!check12B){listSeat.add("12B");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12B.setBackgroundResource(R.drawable.button_seat3);
                        check12B=true;
                    }
                    else {
                        btnSeat12B.setBackgroundResource(R.drawable.button_seat2);
                        check12B=false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12B");
                    }
                }
            });
        }

    }
    private void clickButton1C(int status,  int price){
        if(status==1){
            btnSeat1C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1C) {listSeat.add("01C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1C.setBackgroundResource(R.drawable.button_seat3);
                        check1C = true;
                    } else {
                        btnSeat1C.setBackgroundResource(R.drawable.button_seat2);
                        check1C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01C");
                    }
                }
            });
        }

    }
    private void clickButton2C(int status,  int price){
        if(status==1){
            btnSeat2C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2C) {listSeat.add("02C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2C.setBackgroundResource(R.drawable.button_seat3);
                        check2C = true;
                    } else {
                        btnSeat2C.setBackgroundResource(R.drawable.button_seat2);
                        check2C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02C");
                    }
                }
            });
        }

    }
    private void clickButton3C(int status,  int price){
        if(status==1){
            btnSeat3C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3C) {listSeat.add("03C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat3C.setTextColor(getResources().getColor(R.color.black));
                        check3C = true;
                    } else {
                        btnSeat3C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat3C.setTextColor(getResources().getColor(R.color.white));

                        check3C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03C");
                    }
                }
            });
        }

    }
    private void clickButton4C(int status,  int price){
        if(status==1){
            btnSeat4C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4C) {listSeat.add("04C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat4C.setTextColor(getResources().getColor(R.color.black));
                        check4C = true;
                    } else {
                        btnSeat4C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat4C.setTextColor(getResources().getColor(R.color.white));
                        check4C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04C");
                    }
                }
            });
        }

    }
    private void clickButton5C(int status,  int price){
        if(status==1){
            btnSeat5C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5C) {listSeat.add("05C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat5C.setTextColor(getResources().getColor(R.color.black));
                        check5C = true;
                    } else {
                        btnSeat5C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat5C.setTextColor(getResources().getColor(R.color.white));
                        check5C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05C");
                    }
                }
            });
        }

    }
    private void clickButton6C(int status,  int price){
        if(status==1){
            btnSeat6C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6C) {listSeat.add("06C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat6C.setTextColor(getResources().getColor(R.color.black));
                        check6C = true;
                    } else {
                        btnSeat6C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat6C.setTextColor(getResources().getColor(R.color.white));
                        check6C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06C");
                    }
                }
            });
        }

    }
    private void clickButton7C(int status,  int price){
        if(status==1){
            btnSeat7C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7C) {listSeat.add("07C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat7C.setTextColor(getResources().getColor(R.color.black));
                        check7C = true;
                    } else {
                        btnSeat7C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat7C.setTextColor(getResources().getColor(R.color.white));
                        check7C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07C");
                    }
                }
            });
        }

    }
    private void clickButton8C(int status,  int price){
        if(status==1){
            btnSeat8C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8C) {listSeat.add("08C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat8C.setTextColor(getResources().getColor(R.color.black));
                        check8C = true;
                    } else {
                        btnSeat8C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat8C.setTextColor(getResources().getColor(R.color.white));
                        check8C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08C");
                    }
                }
            });
        }

    }
    private void clickButton9C(int status,  int price){
        if(status==1){
            btnSeat9C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9C) {listSeat.add("09C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat9C.setTextColor(getResources().getColor(R.color.black));
                        check9C = true;
                    } else {
                        btnSeat9C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat9C.setTextColor(getResources().getColor(R.color.white));
                        check9C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09C");
                    }
                }
            });
        }

    }
    private void clickButton10C(int status,  int price){
        if(status==1){
            btnSeat10C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10C) {listSeat.add("10C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10C.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat10C.setTextColor(getResources().getColor(R.color.black));
                        check10C = true;
                    } else {
                        btnSeat10C.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat10C.setTextColor(getResources().getColor(R.color.white));
                        check10C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10C");
                    }
                }
            });
        }

    }
    private void clickButton11C(int status,  int price){
        if(status==1){
            btnSeat11C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11C) {listSeat.add("11C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11C.setBackgroundResource(R.drawable.button_seat3);
                        check11C = true;
                    } else {
                        btnSeat11C.setBackgroundResource(R.drawable.button_seat2);
                        check11C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11C");
                    }
                }
            });
        }

    }
    private void clickButton12C(int status,  int price){
        if(status==1){
            btnSeat12C.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12C.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12C) {listSeat.add("12C");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12C.setBackgroundResource(R.drawable.button_seat3);
                        check12C = true;
                    } else {
                        btnSeat12C.setBackgroundResource(R.drawable.button_seat2);
                        check12C = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12C");
                    }
                }
            });
        }

    }
    private void clickButton1D(int status,  int price){
        if(status==1){
            btnSeat1D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1D) {listSeat.add("01D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1D.setBackgroundResource(R.drawable.button_seat3);
                        check1D = true;
                    } else {
                        btnSeat1D.setBackgroundResource(R.drawable.button_seat2);
                        check1D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01D");
                    }
                }
            });
        }

    }
    private void clickButton2D(int status,  int price){
        if(status==1){
            btnSeat2D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2D) {listSeat.add("02D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2D.setBackgroundResource(R.drawable.button_seat3);
                        check2D = true;
                    } else {
                        btnSeat2D.setBackgroundResource(R.drawable.button_seat2);
                        check2D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02D");
                    }
                }
            });
        }

    }
    private void clickButton3D(int status,  int price){
        if(status==1){
            btnSeat3D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3D) {listSeat.add("03D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat3D.setTextColor(getResources().getColor(R.color.black));
                        check3D = true;
                    } else {
                        btnSeat3D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat3D.setTextColor(getResources().getColor(R.color.white));
                        check3D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03D");
                    }
                }
            });
        }

    }
    private void clickButton4D(int status,  int price){
        if(status==1){
            btnSeat4D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4D) {listSeat.add("04D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat4D.setTextColor(getResources().getColor(R.color.black));
                        check4D = true;
                    } else {
                        btnSeat4D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat4D.setTextColor(getResources().getColor(R.color.white));
                        check4D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04D");
                    }
                }
            });
        }

    }
    private void clickButton5D(int status,  int price){
        if(status==1){
            btnSeat5D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5D) {listSeat.add("05D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat5D.setTextColor(getResources().getColor(R.color.black));
                        check5D = true;
                    } else {
                        btnSeat5D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat5D.setTextColor(getResources().getColor(R.color.white));
                        check5D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05D");
                    }
                }
            });
        }

    }
    private void clickButton6D(int status,  int price){
        if(status==1){
            btnSeat6D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6D) {listSeat.add("06D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat6D.setTextColor(getResources().getColor(R.color.black));
                        check6D = true;
                    } else {
                        btnSeat6D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat6D.setTextColor(getResources().getColor(R.color.white));
                        check6D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07D");
                    }
                }
            });
        }

    }
    private void clickButton7D(int status,  int price){
        if(status==1){
            btnSeat7D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7D) {listSeat.add("07D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat7D.setTextColor(getResources().getColor(R.color.black));
                        check7D = true;
                    } else {
                        btnSeat7D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat7D.setTextColor(getResources().getColor(R.color.white));
                        check7D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07D");
                    }
                }
            });
        }

    }
    private void clickButton8D(int status,  int price){
        if(status==1){
            btnSeat8D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8D) {listSeat.add("08D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat8D.setTextColor(getResources().getColor(R.color.black));
                        check8D = true;
                    } else {
                        btnSeat8D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat8D.setTextColor(getResources().getColor(R.color.white));
                        check8D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08D");
                    }
                }
            });
        }

    }
    private void clickButton9D(int status,  int price){
        if(status==1){
            btnSeat9D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9D) {listSeat.add("09D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat9D.setTextColor(getResources().getColor(R.color.black));
                        check9D = true;
                    } else {
                        btnSeat9D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat9D.setTextColor(getResources().getColor(R.color.white));
                        check9D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09D");
                    }
                }
            });
        }
    }
    private void clickButton10D(int status,  int price){
        if(status==1){
            btnSeat10D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10D) {listSeat.add("10D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10D.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat10D.setTextColor(getResources().getColor(R.color.black));
                        check10D = true;
                    } else {
                        btnSeat10D.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat10D.setTextColor(getResources().getColor(R.color.white));
                        check10D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10D");
                    }
                }
            });
        }
    }
    private void clickButton11D(int status,  int price){
        if(status==1){
            btnSeat11D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11D.setTextColor(getResources().getColor(R.color.white));
        }else{
            
            btnSeat11D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11D) {tPrice+=price;txtTongTien.setText(tPrice+"");
                        listSeat.add("11D");
                        btnSeat11D.setBackgroundResource(R.drawable.button_seat3);
                        check11D = true;
                    } else {
                        btnSeat11D.setBackgroundResource(R.drawable.button_seat2);
                        check11D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11D");
                    }
                }
            });
        }

    }
    private void clickButton12D(int status,  int price){
        if(status==1){
            btnSeat12D.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12D.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12D) {listSeat.add("12D");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12D.setBackgroundResource(R.drawable.button_seat3);
                        check12D = true;
                    } else {
                        btnSeat12D.setBackgroundResource(R.drawable.button_seat2);
                        check12D = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12D");
                    }
                }
            });
        }

    }
    private void clickButton1E(int status,  int price){
        if(status==1){
            btnSeat1E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1E) {listSeat.add("01E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1E.setBackgroundResource(R.drawable.button_seat3);
                        check1E = true;
                    } else {
                        btnSeat1E.setBackgroundResource(R.drawable.button_seat2);
                        check1E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01E");
                    }
                }
            });
        }

    }
    private void clickButton2E(int status,  int price){
        if(status==1){
            btnSeat2E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2E) {listSeat.add("02E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2E.setBackgroundResource(R.drawable.button_seat3);
                        check2E = true;
                    } else {
                        btnSeat2E.setBackgroundResource(R.drawable.button_seat2);
                        check2E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02E");
                    }
                }
            });
        }

    }
    private void clickButton3E(int status,  int price){
        if(status==1){
            btnSeat3E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3E) {listSeat.add("03E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat3E.setTextColor(getResources().getColor(R.color.black));
                        check3E = true;
                    } else {
                        btnSeat3E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat3E.setTextColor(getResources().getColor(R.color.white));
                        check3E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03E");
                    }
                }
            });
        }

    }
    private void clickButton4E(int status,  int price){
        if(status==1){
            btnSeat4E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4E) {listSeat.add("04E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat4E.setTextColor(getResources().getColor(R.color.black));
                        check4E = true;
                    } else {
                        btnSeat4E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat4E.setTextColor(getResources().getColor(R.color.white));
                        check4E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04E");
                    }
                }
            });
        }

    }
    private void clickButton5E(int status,  int price){
        if(status==1){
            btnSeat5E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5E) {listSeat.add("05E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat5E.setTextColor(getResources().getColor(R.color.black));
                        check5E = true;
                    } else {
                        btnSeat5E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat5E.setTextColor(getResources().getColor(R.color.white));
                        check5E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05E");
                    }
                }
            });
        }

    }
    private void clickButton6E(int status,  int price){
        if(status==1){
            btnSeat6E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6E) {listSeat.add("06E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat6E.setTextColor(getResources().getColor(R.color.black));
                        check6E = true;
                    } else {
                        btnSeat6E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat6E.setTextColor(getResources().getColor(R.color.white));
                        check6E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06E");
                    }
                }
            });
        }

    }
    private void clickButton7E(int status,  int price){
        if(status==1){
            btnSeat7E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7E) {listSeat.add("07E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat7E.setTextColor(getResources().getColor(R.color.black));
                        check7E = true;
                    } else {
                        btnSeat7E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat7E.setTextColor(getResources().getColor(R.color.white));
                        check7E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07E");
                    }
                }
            });
        }

    }
    private void clickButton8E(int status,  int price){
        if(status==1){
            btnSeat8E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8E) {listSeat.add("08E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat8E.setTextColor(getResources().getColor(R.color.black));
                        check8E = true;
                    } else {
                        btnSeat8E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat8E.setTextColor(getResources().getColor(R.color.white));
                        check8E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08E");
                    }
                }
            });
        }

    }
    private void clickButton9E(int status,  int price){
        if(status==1){
            btnSeat9E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9E) {listSeat.add("09E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat9E.setTextColor(getResources().getColor(R.color.black));
                        check9E = true;
                    } else {
                        btnSeat9E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat9E.setTextColor(getResources().getColor(R.color.white));
                        check9E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09E");
                    }
                }
            });
        }

    }
    private void clickButton10E(int status,  int price){
        if(status==1){
            btnSeat10E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10E) {listSeat.add("10E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10E.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat10E.setTextColor(getResources().getColor(R.color.black));
                        check10E = true;
                    } else {
                        btnSeat10E.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat10E.setTextColor(getResources().getColor(R.color.white));
                        check10E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10E");
                    }
                }
            });
        }

    }
    private void clickButton11E(int status,  int price){
        if(status==1){
            btnSeat11E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11E) {listSeat.add("11E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11E.setBackgroundResource(R.drawable.button_seat3);
                        check11E = true;
                    } else {
                        btnSeat11E.setBackgroundResource(R.drawable.button_seat2);
                        check11E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11E");
                    }
                }
            });
        }

    }
    private void clickButton12E(int status,  int price){
        if(status==1){
            btnSeat12E.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12E.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12E) {listSeat.add("12E");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12E.setBackgroundResource(R.drawable.button_seat3);
                        check12E = true;
                    } else {
                        btnSeat12E.setBackgroundResource(R.drawable.button_seat2);
                        check12E = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12E");
                    }
                }
            });
        }

    }
    private void clickButton1F(int status,  int price){
        if(status==1){
            btnSeat1F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1F) {listSeat.add("01F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1F.setBackgroundResource(R.drawable.button_seat3);
                        check1F = true;
                    } else {
                        btnSeat1F.setBackgroundResource(R.drawable.button_seat2);
                        check1F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01F");
                    }
                }
            });
        }

    }
    private void clickButton2F(int status,  int price){
        if(status==1){
            btnSeat2F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2F) {listSeat.add("02F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2F.setBackgroundResource(R.drawable.button_seat3);
                        check2F = true;
                    } else {
                        btnSeat2F.setBackgroundResource(R.drawable.button_seat2);
                        check2F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02F");
                    }
                }
            });
        }

    }
    private void clickButton3F(int status,  int price){
        if(status==1){
            btnSeat3F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3F) {listSeat.add("03F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat3F.setTextColor(getResources().getColor(R.color.black));
                        check3F = true;
                    } else {
                        btnSeat3F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat3F.setTextColor(getResources().getColor(R.color.white));
                        check3F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03F");
                    }
                }
            });
        }

    }
    private void clickButton4F(int status,  int price){
        if(status==1){
            btnSeat4F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4F) {listSeat.add("04F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat4F.setTextColor(getResources().getColor(R.color.black));
                        check4F = true;
                    } else {
                        btnSeat4F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat4F.setTextColor(getResources().getColor(R.color.white));
                        check4F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04F");
                    }
                }
            });
        }

    }
    private void clickButton5F(int status,  int price){
        if(status==1){
            btnSeat5F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5F) {listSeat.add("05F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat5F.setTextColor(getResources().getColor(R.color.black));
                        check5F = true;
                    } else {
                        btnSeat5F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat5F.setTextColor(getResources().getColor(R.color.white));
                        check5F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05F");
                    }
                }
            });
        }

    }
    private void clickButton6F(int status,  int price){
        if(status==1){
            btnSeat6F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6F) {listSeat.add("06F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat6F.setTextColor(getResources().getColor(R.color.black));
                        check6F = true;
                    } else {
                        btnSeat6F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat6F.setTextColor(getResources().getColor(R.color.white));
                        check6F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06F");
                    }
                }
            });
        }

    }
    private void clickButton7F(int status,  int price){
        if(status==1){
            btnSeat7F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7F) {listSeat.add("07F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat7F.setTextColor(getResources().getColor(R.color.black));
                        check7F = true;
                    } else {
                        btnSeat7F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat7F.setTextColor(getResources().getColor(R.color.white));
                        check7F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07F");
                    }
                }
            });
        }

    }
    private void clickButton8F(int status,  int price){
        if(status==1){
            btnSeat8F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8F) {listSeat.add("08F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat8F.setTextColor(getResources().getColor(R.color.black));
                        check8F = true;
                    } else {
                        btnSeat8F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat8F.setTextColor(getResources().getColor(R.color.white));
                        check8F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08F");
                    }
                }
            });
        }

    }
    private void clickButton9F(int status,  int price){
        if(status==1){
            btnSeat9F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9F) {
                        listSeat.add("09F");
                        tPrice+=price;
                        txtTongTien.setText(tPrice+"");
                        btnSeat9F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat9F.setTextColor(getResources().getColor(R.color.black));
                        check9F = true;
                    } else {
                        btnSeat9F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat9F.setTextColor(getResources().getColor(R.color.white));
                        check9F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09F");
                    }
                }
            });
        }

    }
    private void clickButton10F(int status,  int price){
        if(status==1){
            btnSeat10F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10F) {
                        listSeat.add("10F");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10F.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat10F.setTextColor(getResources().getColor(R.color.black));
                        check10F = true;
                    } else {
                        btnSeat10F.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat10F.setTextColor(getResources().getColor(R.color.white));
                        check10F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10F");
                    }
                }
            });
        }

    }
    private void clickButton11F(int status,  int price){
        if(status==1){
            btnSeat11F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11F) {listSeat.add("11F");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11F.setBackgroundResource(R.drawable.button_seat3);
                        check11F = true;
                    } else {
                        btnSeat11F.setBackgroundResource(R.drawable.button_seat2);
                        check11F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11F");
                    }
                }
            });
        }

    }
    private void clickButton12F(int status,  int price){
        if(status==1){
            btnSeat12F.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12F.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12F.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12F) {listSeat.add("12F");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12F.setBackgroundResource(R.drawable.button_seat3);
                        check12F = true;
                    } else {
                        btnSeat12F.setBackgroundResource(R.drawable.button_seat2);
                        check12F = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12F");
                    }
                }
            });
        }

    }
    private void clickButton1G(int status,  int price){
        if(status==1){
            btnSeat1G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1G) {listSeat.add("01G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1G.setBackgroundResource(R.drawable.button_seat3);
                        check1G = true;
                    } else {
                        btnSeat1G.setBackgroundResource(R.drawable.button_seat2);
                        check1G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01G");
                    }
                }
            });
        }

    }
    private void clickButton2G(int status,  int price){
        if(status==1){
            btnSeat2G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2G) {listSeat.add("02G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2G.setBackgroundResource(R.drawable.button_seat3);
                        check2G = true;
                    } else {
                        btnSeat2G.setBackgroundResource(R.drawable.button_seat2);
                        check2G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02G");
                    }
                }
            });
        }

    }
    private void clickButton3G(int status,  int price){
        if(status==1){
            btnSeat3G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3G) {listSeat.add("03G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat3G.setTextColor(getResources().getColor(R.color.black));
                        check3G = true;
                    } else {
                        btnSeat3G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat3G.setTextColor(getResources().getColor(R.color.white));
                        check3G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03G");
                    }
                }
            });

        }

    }
    private void clickButton4G(int status,  int price){
        if(status==1){
            btnSeat4G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4G) {listSeat.add("04G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat4G.setTextColor(getResources().getColor(R.color.black));
                        check4G = true;
                    } else {
                        btnSeat4G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat4G.setTextColor(getResources().getColor(R.color.white));
                        check4G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04G");
                    }
                }
            });
        }

    }
    private void clickButton5G(int status,  int price){
        if(status==1){
            btnSeat5G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5G) {listSeat.add("05G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat5G.setTextColor(getResources().getColor(R.color.black));
                        check5G = true;
                    } else {
                        btnSeat5G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat5G.setTextColor(getResources().getColor(R.color.white));
                        check5G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05G");
                    }
                }
            });
        }

    }
    private void clickButton6G(int status,  int price){
        if(status==1){
            btnSeat6G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6G) {listSeat.add("06G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat6G.setTextColor(getResources().getColor(R.color.black));
                        check6G = true;
                    } else {
                        btnSeat6G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat6G.setTextColor(getResources().getColor(R.color.white));
                        check6G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06G");
                    }
                }
            });
        }

    }
    private void clickButton7G(int status,  int price){
        if(status==1){
            btnSeat7G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7G) {listSeat.add("07G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat7G.setTextColor(getResources().getColor(R.color.black));
                        check7G = true;
                    } else {
                        btnSeat7G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat7G.setTextColor(getResources().getColor(R.color.white));
                        check7G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07G");
                    }
                }
            });
        }

    }
    private void clickButton8G(int status,  int price){
        if(status==1){
            btnSeat8G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8G) {listSeat.add("08G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat8G.setTextColor(getResources().getColor(R.color.black));
                        check8G = true;
                    } else {
                        btnSeat8G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat8G.setTextColor(getResources().getColor(R.color.white));
                        check8G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08G");
                    }
                }
            });
        }

    }
    private void clickButton9G(int status,  int price){
        if(status==1){
            btnSeat9G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9G) {listSeat.add("09G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat9G.setTextColor(getResources().getColor(R.color.black));
                        check9G = true;
                    } else {
                        btnSeat9G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat9G.setTextColor(getResources().getColor(R.color.white));
                        check9G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09G");
                    }
                }
            });
        }

    }
    private void clickButton10G(int status,  int price){
        if(status==1){
            btnSeat10G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10G) {
                        listSeat.add("10G");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10G.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat10G.setTextColor(getResources().getColor(R.color.black));
                        check10G = true;
                    } else {
                        btnSeat10G.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat10G.setTextColor(getResources().getColor(R.color.white));
                        check10G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10G");
                    }
                }
            });
        }

    }
    private void clickButton11G(int status,  int price){
        if(status==1){
            btnSeat11G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11G) {listSeat.add("11G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11G.setBackgroundResource(R.drawable.button_seat3);
                        check11G = true;
                    } else {
                        btnSeat11G.setBackgroundResource(R.drawable.button_seat2);
                        check11G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11G");
                    }
                }
            });
        }

    }
    private void clickButton12G(int status,  int price){
        if(status==1){
            btnSeat12G.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12G.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12G.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12G) {listSeat.add("12G");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12G.setBackgroundResource(R.drawable.button_seat3);
                        check12G = true;
                    } else {
                        btnSeat12G.setBackgroundResource(R.drawable.button_seat2);
                        check12G = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12G");
                    }
                }
            });
        }

    }
    private void clickButton1H(int status,  int price){
        if(status==1){
            btnSeat1H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1H) {listSeat.add("01H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1H.setBackgroundResource(R.drawable.button_seat3);
                        check1H = true;
                    } else {
                        btnSeat1H.setBackgroundResource(R.drawable.button_seat2);
                        check1H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01H");
                    }
                }
            });
        }

    }
    private void clickButton2H(int status,  int price){
        if(status==1){
            btnSeat2H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2H) {listSeat.add("02H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2H.setBackgroundResource(R.drawable.button_seat3);
                        check2H = true;
                    } else {
                        btnSeat2H.setBackgroundResource(R.drawable.button_seat2);
                        check2H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02H");
                    }
                }
            });
        }

    }
    private void clickButton3H(int status,  int price){
        if(status==1){
            btnSeat3H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3H) {listSeat.add("03H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat3H.setTextColor(getResources().getColor(R.color.black));
                        check3H = true;
                    } else {
                        btnSeat3H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat3H.setTextColor(getResources().getColor(R.color.white));
                        check3H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03H");
                    }
                }
            });
        }

    }
    private void clickButton4H(int status,  int price){
        if(status==1){
            btnSeat4H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4H) {listSeat.add("04H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat4H.setTextColor(getResources().getColor(R.color.black));
                        check4H = true;
                    } else {
                        btnSeat4H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat4H.setTextColor(getResources().getColor(R.color.white));
                        check4H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04H");
                    }
                }
            });
        }

    }
    private void clickButton5H(int status,  int price){
        if(status==1){
            btnSeat5H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5H) {listSeat.add("05H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat5H.setTextColor(getResources().getColor(R.color.black));
                        check5H = true;
                    } else {
                        btnSeat5H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat5H.setTextColor(getResources().getColor(R.color.white));
                        check5H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05H");
                    }
                }
            });
        }

    }
    private void clickButton6H(int status,  int price){
        if(status==1){
            btnSeat6H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6H) {listSeat.add("06H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat6H.setTextColor(getResources().getColor(R.color.black));
                        check6H = true;
                    } else {
                        btnSeat6H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat6H.setTextColor(getResources().getColor(R.color.white));
                        check6H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06H");
                    }
                }
            });
        }

    }
    private void clickButton7H(int status,  int price){
        if(status==1){
            btnSeat7H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7H) {listSeat.add("07H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat7H.setTextColor(getResources().getColor(R.color.black));
                        check7H = true;
                    } else {
                        btnSeat7H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat7H.setTextColor(getResources().getColor(R.color.white));
                        check7H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07H");
                    }
                }
            });
        }

    }
    private void clickButton8H(int status,  int price){
        if(status==1){
            btnSeat8H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8H) {listSeat.add("08H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat8H.setTextColor(getResources().getColor(R.color.black));
                        check8H = true;
                    } else {
                        btnSeat8H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat8H.setTextColor(getResources().getColor(R.color.white));
                        check8H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08H");
                    }
                }
            });
        }

    }
    private void clickButton9H(int status,  int price){
        if(status==1){
            btnSeat9H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9H) {listSeat.add("09H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat9H.setTextColor(getResources().getColor(R.color.black));
                        check9H = true;
                    } else {
                        btnSeat9H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat9H.setTextColor(getResources().getColor(R.color.white));
                        check9H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09H");
                    }
                }
            });
        }

    }
    private void clickButton10H(int status,  int price){
        if(status==1){
            btnSeat10H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10H) {listSeat.add("10H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10H.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat10H.setTextColor(getResources().getColor(R.color.black));
                        check10H = true;
                    } else {
                        btnSeat10H.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat10H.setTextColor(getResources().getColor(R.color.white));
                        check10H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10H");
                    }
                }
            });
        }

    }
    private void clickButton11H(int status,  int price){
        if(status==1){
            btnSeat11H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11H) {listSeat.add("11H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11H.setBackgroundResource(R.drawable.button_seat3);
                        check11H = true;
                    } else {
                        btnSeat11H.setBackgroundResource(R.drawable.button_seat2);
                        check11H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11H");
                    }
                }
            });
        }

    }
    private void clickButton12H(int status,  int price){
        if(status==1){
            btnSeat12H.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12H.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12H.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12H) {listSeat.add("12H");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12H.setBackgroundResource(R.drawable.button_seat3);
                        check12H = true;
                    } else {
                        btnSeat12H.setBackgroundResource(R.drawable.button_seat2);
                        check12H = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12H");
                    }
                }
            });
        }

    }
    private void clickButton1I(int status,  int price){
        if(status==1){
            btnSeat1I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1I) {listSeat.add("01I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1I.setBackgroundResource(R.drawable.button_seat3);
                        check1I = true;
                    } else {
                        btnSeat1I.setBackgroundResource(R.drawable.button_seat2);
                        check1I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01I");
                    }
                }
            });
        }

    }
    private void clickButton2I(int status,  int price){
        if(status==1){
            btnSeat2I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2I) {listSeat.add("02I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2I.setBackgroundResource(R.drawable.button_seat3);
                        check2I = true;
                    } else {
                        btnSeat2I.setBackgroundResource(R.drawable.button_seat2);
                        check2I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02I");
                    }
                }
            });
        }

    }
    private void clickButton3I(int status,  int price){
        if(status==1){
            btnSeat3I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3I) {listSeat.add("03I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat3I.setTextColor(getResources().getColor(R.color.black));
                        check3I = true;
                    } else {
                        btnSeat3I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat3I.setTextColor(getResources().getColor(R.color.white));
                        check3I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03I");
                    }
                }
            });
        }

    }
    private void clickButton4I(int status,  int price){
        if(status==1){
            btnSeat4I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4I) {listSeat.add("04I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat4I.setTextColor(getResources().getColor(R.color.black));
                        check4I = true;
                    } else {
                        btnSeat4I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat4I.setTextColor(getResources().getColor(R.color.white));
                        check4I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04I");
                    }
                }
            });
        }

    }
    private void clickButton5I(int status,  int price){
        if(status==1){
            btnSeat5I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5I) {listSeat.add("05I");
                        tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat5I.setTextColor(getResources().getColor(R.color.black));
                        check5I = true;
                    } else {
                        btnSeat5I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat5I.setTextColor(getResources().getColor(R.color.white));
                        check5I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05I");
                    }
                }
            });
        }

    }
    private void clickButton6I(int status,  int price){
        if(status==1){
            btnSeat6I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6I) {listSeat.add("06I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat6I.setTextColor(getResources().getColor(R.color.black));
                        check6I = true;
                    } else {
                        btnSeat6I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat6I.setTextColor(getResources().getColor(R.color.white));
                        check6I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06I");
                    }
                }
            });
        }

    }
    private void clickButton7I(int status,  int price){
        if(status==1){
            btnSeat7I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7I) {listSeat.add("07I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat7I.setTextColor(getResources().getColor(R.color.black));
                        check7I = true;
                    } else {
                        btnSeat7I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat7I.setTextColor(getResources().getColor(R.color.white));
                        check7I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07I");
                    }
                }
            });
        }

    }
    private void clickButton8I(int status,  int price){
        if(status==1){
            btnSeat8I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8I) {listSeat.add("08I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat8I.setTextColor(getResources().getColor(R.color.black));
                        check8I = true;
                    } else {
                        btnSeat8I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat8I.setTextColor(getResources().getColor(R.color.white));
                        check8I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08I");
                    }
                }
            });
        }

    }
    private void clickButton9I(int status,  int price){
        if(status==1){
            btnSeat9I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9I) {listSeat.add("09I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat9I.setTextColor(getResources().getColor(R.color.black));
                        check9I = true;
                    } else {
                        btnSeat9I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat9I.setTextColor(getResources().getColor(R.color.white));
                        check9I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09I");
                    }
                }
            });
        }

    }
    private void clickButton10I(int status,  int price){
        if(status==1){
            btnSeat10I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10I) {listSeat.add("10I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10I.setBackgroundResource(R.drawable.button_seat3);
                        btnSeat10I.setTextColor(getResources().getColor(R.color.black));
                        check10I = true;
                    } else {
                        btnSeat10I.setBackgroundResource(R.drawable.button_seat1);
                        btnSeat10I.setTextColor(getResources().getColor(R.color.white));
                        check10I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10I");
                    }
                }
            });
        }

    }
    private void clickButton11I(int status,  int price){
        if(status==1){
            btnSeat11I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11I) {listSeat.add("11I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11I.setBackgroundResource(R.drawable.button_seat3);
                        check11I = true;
                    } else {
                        btnSeat11I.setBackgroundResource(R.drawable.button_seat2);
                        check11I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11I");
                    }
                }
            });
        }

    }
    private void clickButton12I(int status,  int price){
        if(status==1){
            btnSeat12I.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12I.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12I.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12I) {listSeat.add("12I");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12I.setBackgroundResource(R.drawable.button_seat3);
                        check12I = true;
                    } else {
                        btnSeat12I.setBackgroundResource(R.drawable.button_seat2);
                        check12I = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12I");
                    }
                }
            });
        }

    }
    private void clickButton1J(int status,  int price){
        if(status==1){
            btnSeat1J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat1J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat1J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check1J) {listSeat.add("01J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat1J.setBackgroundResource(R.drawable.button_seat3);
                        check1J = true;
                    } else {
                        btnSeat1J.setBackgroundResource(R.drawable.button_seat2);
                        check1J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("01J");
                    }
                }
            });
        }

    }
    private void clickButton2J(int status,  int price){
        if(status==1){
            btnSeat2J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat2J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat2J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check2J) {listSeat.add("02J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat2J.setBackgroundResource(R.drawable.button_seat3);
                        check2J = true;
                    } else {
                        btnSeat2J.setBackgroundResource(R.drawable.button_seat2);
                        check2J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("02J");
                    }
                }
            });
        }

    }
    private void clickButton3J(int status,  int price){
        if(status==1){
            btnSeat3J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat3J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat3J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check3J) {listSeat.add("03J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat3J.setBackgroundResource(R.drawable.button_seat3);
                        check3J = true;
                    } else {
                        btnSeat3J.setBackgroundResource(R.drawable.button_seat2);
                        check3J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("03J");
                    }
                }
            });
        }

    }
    private void clickButton4J(int status,  int price){
        if(status==1){
            btnSeat4J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat4J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat4J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check4J) {listSeat.add("04J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat4J.setBackgroundResource(R.drawable.button_seat3);
                        check4J = true;
                    } else {
                        btnSeat4J.setBackgroundResource(R.drawable.button_seat2);
                        check4J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("04J");
                    }
                }
            });
        }

    }
    private void clickButton5J(int status,  int price){
        if(status==1){
            btnSeat5J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat5J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat5J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check5J) {listSeat.add("05J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat5J.setBackgroundResource(R.drawable.button_seat3);
                        check5J = true;
                    } else {
                        btnSeat5J.setBackgroundResource(R.drawable.button_seat2);
                        check5J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("05J");
                    }
                }
            });
        }

    }
    private void clickButton6J(int status,  int price){
        if(status==1){
            btnSeat6J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat6J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat6J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check6J) {listSeat.add("06J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat6J.setBackgroundResource(R.drawable.button_seat3);
                        check6J = true;
                    } else {
                        btnSeat6J.setBackgroundResource(R.drawable.button_seat2);
                        check6J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("06J");
                    }
                }
            });
        }

    }
    private void clickButton7J(int status,  int price){
        if(status==1){
            btnSeat7J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat7J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat7J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check7J) {listSeat.add("07J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat7J.setBackgroundResource(R.drawable.button_seat3);
                        check7J = true;
                    } else {
                        btnSeat7J.setBackgroundResource(R.drawable.button_seat2);
                        check7J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("07J");
                    }
                }
            });
        }

    }
    private void clickButton8J(int status,  int price){
        if(status==1){
            btnSeat8J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat8J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat8J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check8J) {listSeat.add("08J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat8J.setBackgroundResource(R.drawable.button_seat3);
                        check8J = true;
                    } else {
                        btnSeat8J.setBackgroundResource(R.drawable.button_seat2);
                        check8J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("08J");
                    }
                }
            });
        }

    }
    private void clickButton9J(int status,  int price){
        if(status==1){
            btnSeat9J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat9J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat9J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check9J) {listSeat.add("09J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat9J.setBackgroundResource(R.drawable.button_seat3);
                        check9J = true;
                    } else {
                        btnSeat9J.setBackgroundResource(R.drawable.button_seat2);
                        check9J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("09J");
                    }
                }
            });
        }

    }
    private void clickButton10J(int status,  int price){
        if(status==1){
            btnSeat10J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat10J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat10J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check10J) {listSeat.add("10J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat10J.setBackgroundResource(R.drawable.button_seat3);
                        check10J = true;
                    } else {
                        btnSeat10J.setBackgroundResource(R.drawable.button_seat2);
                        check10J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("10J");
                    }
                }
            });
        }

    }
    private void clickButton11J(int status,  int price){
        if(status==1){
            btnSeat11J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat11J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat11J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check11J) {listSeat.add("11J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat11J.setBackgroundResource(R.drawable.button_seat3);
                        check11J = true;
                    } else {
                        btnSeat11J.setBackgroundResource(R.drawable.button_seat2);
                        check11J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("11J");
                    }
                }
            });
        }

    }
    private void clickButton12J(int status,  int price){
        if(status==1){
            btnSeat12J.setBackgroundResource(R.drawable.button_seat4);
            btnSeat12J.setTextColor(getResources().getColor(R.color.white));
        }else{
            btnSeat12J.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!check12J) {listSeat.add("12J");tPrice+=price;txtTongTien.setText(tPrice+"");
                        btnSeat12J.setBackgroundResource(R.drawable.button_seat3);
                        check12J = true;
                    } else {
                        btnSeat12J.setBackgroundResource(R.drawable.button_seat2);
                        check12J = false;tPrice-=price;txtTongTien.setText(tPrice+"");listSeat.remove("12J");
                    }
                }
            });
        }

    }


    public void mapping(){
        btnNext=findViewById(R.id.btnNext);
        txtTongTien=findViewById(R.id.txtTongTien);
        txtInfTicket=findViewById(R.id.txtInfTicket);
        txtNameCinema=findViewById(R.id.txtNameCinema);
        btnSeat1A=findViewById(R.id.btnSeat1A);
        btnSeat2A=findViewById(R.id.btnSeat2A);
        btnSeat3A=findViewById(R.id.btnSeat3A);
        btnSeat4A=findViewById(R.id.btnSeat4A);
        btnSeat5A=findViewById(R.id.btnSeat5A);
        btnSeat6A=findViewById(R.id.btnSeat6A);
        btnSeat7A=findViewById(R.id.btnSeat7A);
        btnSeat8A=findViewById(R.id.btnSeat8A);
        btnSeat9A=findViewById(R.id.btnSeat9A);
        btnSeat10A=findViewById(R.id.btnSeat10A);
        btnSeat11A=findViewById(R.id.btnSeat11A);
        btnSeat12A=findViewById(R.id.btnSeat12A);
        btnSeat1B=findViewById(R.id.btnSeat1B);
        btnSeat2B=findViewById(R.id.btnSeat2B);
        btnSeat3B=findViewById(R.id.btnSeat3B);
        btnSeat4B=findViewById(R.id.btnSeat4B);
        btnSeat5B=findViewById(R.id.btnSeat5B);
        btnSeat6B=findViewById(R.id.btnSeat6B);
        btnSeat7B=findViewById(R.id.btnSeat7B);
        btnSeat8B=findViewById(R.id.btnSeat8B);
        btnSeat9B=findViewById(R.id.btnSeat9B);
        btnSeat10B=findViewById(R.id.btnSeat10B);
        btnSeat11B=findViewById(R.id.btnSeat11B);
        btnSeat12B=findViewById(R.id.btnSeat12B);
        btnSeat1C=findViewById(R.id.btnSeat1C);
        btnSeat2C=findViewById(R.id.btnSeat2C);
        btnSeat3C=findViewById(R.id.btnSeat3C);
        btnSeat4C=findViewById(R.id.btnSeat4C);
        btnSeat5C=findViewById(R.id.btnSeat5C);
        btnSeat6C=findViewById(R.id.btnSeat6C);
        btnSeat7C=findViewById(R.id.btnSeat7C);
        btnSeat8C=findViewById(R.id.btnSeat8C);
        btnSeat9C=findViewById(R.id.btnSeat9C);
        btnSeat10C=findViewById(R.id.btnSeat10C);
        btnSeat11C=findViewById(R.id.btnSeat11C);
        btnSeat12C=findViewById(R.id.btnSeat12C);
        btnSeat1D=findViewById(R.id.btnSeat1D);
        btnSeat2D=findViewById(R.id.btnSeat2D);
        btnSeat3D=findViewById(R.id.btnSeat3D);
        btnSeat4D=findViewById(R.id.btnSeat4D);
        btnSeat5D=findViewById(R.id.btnSeat5D);
        btnSeat6D=findViewById(R.id.btnSeat6D);
        btnSeat7D=findViewById(R.id.btnSeat7D);
        btnSeat8D=findViewById(R.id.btnSeat8D);
        btnSeat9D=findViewById(R.id.btnSeat9D);
        btnSeat10D=findViewById(R.id.btnSeat10D);
        btnSeat11D=findViewById(R.id.btnSeat11D);
        btnSeat12D=findViewById(R.id.btnSeat12D);
        btnSeat1E=findViewById(R.id.btnSeat1E);
        btnSeat2E=findViewById(R.id.btnSeat2E);
        btnSeat3E=findViewById(R.id.btnSeat3E);
        btnSeat4E=findViewById(R.id.btnSeat4E);
        btnSeat5E=findViewById(R.id.btnSeat5E);
        btnSeat6E=findViewById(R.id.btnSeat6E);
        btnSeat7E=findViewById(R.id.btnSeat7E);
        btnSeat8E=findViewById(R.id.btnSeat8E);
        btnSeat9E=findViewById(R.id.btnSeat9E);
        btnSeat10E=findViewById(R.id.btnSeat10E);
        btnSeat11E=findViewById(R.id.btnSeat11E);
        btnSeat12E=findViewById(R.id.btnSeat12E);
        btnSeat1F=findViewById(R.id.btnSeat1F);
        btnSeat2F=findViewById(R.id.btnSeat2F);
        btnSeat3F=findViewById(R.id.btnSeat3F);
        btnSeat4F=findViewById(R.id.btnSeat4F);
        btnSeat5F=findViewById(R.id.btnSeat5F);
        btnSeat6F=findViewById(R.id.btnSeat6F);
        btnSeat7F=findViewById(R.id.btnSeat7F);
        btnSeat8F=findViewById(R.id.btnSeat8F);
        btnSeat9F=findViewById(R.id.btnSeat9F);
        btnSeat10F=findViewById(R.id.btnSeat10F);
        btnSeat11F=findViewById(R.id.btnSeat11F);
        btnSeat12F=findViewById(R.id.btnSeat12F);
        btnSeat1G=findViewById(R.id.btnSeat1G);
        btnSeat2G=findViewById(R.id.btnSeat2G);
        btnSeat3G=findViewById(R.id.btnSeat3G);
        btnSeat4G=findViewById(R.id.btnSeat4G);
        btnSeat5G=findViewById(R.id.btnSeat5G);
        btnSeat6G=findViewById(R.id.btnSeat6G);
        btnSeat7G=findViewById(R.id.btnSeat7G);
        btnSeat8G=findViewById(R.id.btnSeat8G);
        btnSeat9G=findViewById(R.id.btnSeat9G);
        btnSeat10G=findViewById(R.id.btnSeat10G);
        btnSeat11G=findViewById(R.id.btnSeat11G);
        btnSeat12G=findViewById(R.id.btnSeat12G);
        btnSeat1H=findViewById(R.id.btnSeat1H);
        btnSeat2H=findViewById(R.id.btnSeat2H);
        btnSeat3H=findViewById(R.id.btnSeat3H);
        btnSeat4H=findViewById(R.id.btnSeat4H);
        btnSeat5H=findViewById(R.id.btnSeat5H);
        btnSeat6H=findViewById(R.id.btnSeat6H);
        btnSeat7H=findViewById(R.id.btnSeat7H);
        btnSeat8H=findViewById(R.id.btnSeat8H);
        btnSeat9H=findViewById(R.id.btnSeat9H);
        btnSeat10H=findViewById(R.id.btnSeat10H);
        btnSeat11H=findViewById(R.id.btnSeat11H);
        btnSeat12H=findViewById(R.id.btnSeat12H);
        btnSeat1I=findViewById(R.id.btnSeat1I);
        btnSeat2I=findViewById(R.id.btnSeat2I);
        btnSeat3I=findViewById(R.id.btnSeat3I);
        btnSeat4I=findViewById(R.id.btnSeat4I);
        btnSeat5I=findViewById(R.id.btnSeat5I);
        btnSeat6I=findViewById(R.id.btnSeat6I);
        btnSeat7I=findViewById(R.id.btnSeat7I);
        btnSeat8I=findViewById(R.id.btnSeat8I);
        btnSeat9I=findViewById(R.id.btnSeat9I);
        btnSeat10I=findViewById(R.id.btnSeat10I);
        btnSeat11I=findViewById(R.id.btnSeat11I);
        btnSeat12I=findViewById(R.id.btnSeat12I);
        btnSeat1J=findViewById(R.id.btnSeat1J);
        btnSeat2J=findViewById(R.id.btnSeat2J);
        btnSeat3J=findViewById(R.id.btnSeat3J);
        btnSeat4J=findViewById(R.id.btnSeat4J);
        btnSeat5J=findViewById(R.id.btnSeat5J);
        btnSeat6J=findViewById(R.id.btnSeat6J);
        btnSeat7J=findViewById(R.id.btnSeat7J);
        btnSeat8J=findViewById(R.id.btnSeat8J);
        btnSeat9J=findViewById(R.id.btnSeat9J);
        btnSeat10J=findViewById(R.id.btnSeat10J);
        btnSeat11J=findViewById(R.id.btnSeat11J);
        btnSeat12J=findViewById(R.id.btnSeat12J);

    }

    @Override
    public void myToast(String message) {
        Toast.makeText(SeatActivity.this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCallBack(List<Ticket> tickets) {
        ticketList=tickets;
        Log.d("ktraList", "onCreate: "+ticketList.size());
        int i=0;
        clickButton1A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton1J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton2A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton2J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton3A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton3J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton4A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton4J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton5A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton5J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton6A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton6J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton7A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton7J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton8A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton8J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton9A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton9J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton10A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());


        i=i+1;
        clickButton10E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton10J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;

        clickButton12A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11A(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12B(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12C(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton11D(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12E(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12F(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12G(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12H(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12I(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
        i=i+1;
        clickButton12J(tickets.get(i).getTinhTrang(),tickets.get(i).getGiaMacDinh());
    }

    @Override
    public void onPreCallBack(PreTicket preTicket) {
        txtNameCinema.setText(preTicket.getTenRap());
        txtInfTicket.setText(preTicket.getNgayChieu()+" - "+preTicket.getKhungGio()+" - Phòng: "+preTicket.getIdPhong());

    }
}