package com.example.appfilm.view;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appfilm.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    TextInputLayout txtGioiTinh;
    AutoCompleteTextView dropdown_text,txtNgaySinh;
    TextInputEditText edtHoTen,edtSDT,edtEmail,edtMatKhau;
    Button btnDangKy;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    String tendn,matkhau,emai,hoten,ngaysinh,gioitinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mapping();


        String[] items=new String[]{
                    "Nam",
                    "Nữ",
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                Register.this,
                R.layout.dropdown_item,
                items
        );
        dropdown_text.setAdapter(adapter);

        txtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetDate();
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DangKy("http://nguyentrongquang.freevar.com@nguyentrongquang.freevar.com/account/Register.php");
            }
        });
        tendn=matkhau=emai=hoten=ngaysinh=gioitinh="";
    }


    public void DangKy(String url){
        tendn = edtSDT.getText().toString().trim();
        matkhau = edtMatKhau.getText().toString().trim();
        emai = edtEmail.getText().toString().trim();
        hoten = edtHoTen.getText().toString().trim();
        ngaysinh = txtNgaySinh.getText().toString().trim();
        gioitinh = dropdown_text.getText().toString().trim();

        if (hoten.isEmpty()){
            edtHoTen.setError("Vui lòng nhập họ tên");
            edtHoTen.requestFocus();
            return;

        }
        if (tendn.isEmpty()){
            edtSDT.setError("Vui lòng nhập số điện thoại");
            edtSDT.requestFocus();
            return;

        }
        if (emai.isEmpty()){
            edtEmail.setError("Vui lòng nhập Email");
            edtEmail.requestFocus();
            return;

        }
        if (matkhau.isEmpty()){
            edtMatKhau.setError("Vui lòng nhập mật khẩu");
            edtMatKhau.requestFocus();
            return;

        }
        if (ngaysinh.isEmpty()){
            txtNgaySinh.setError("Vui lòng chọn ngày sinh");
            txtNgaySinh.requestFocus();
            return;

        }
        if (gioitinh.isEmpty()){
            dropdown_text.setError("Vui lòng nhập họ tên");
            dropdown_text.requestFocus();
            return;

        }

//        if (!tendn.equals("") && !matkhau.equals("") && !emai.equals("") && !hoten.equals("") && !ngaysinh.equals("") && !gioitinh.equals("")){

            //dialog thời gian chờ


            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("AAAA",response);
                    if (response.equalsIgnoreCase("ThanhCong")){
                        progressDialog = new ProgressDialog(Register.this);
                        progressDialog.show();
                        progressDialog.setContentView(R.layout.progress_dialog);
                        progressDialog.getWindow().setBackgroundDrawableResource(
                                android.R.color.transparent
                        );
                        startActivity(new Intent(Register.this, Login2.class));
                        Toast.makeText(Register.this, "Đăng ký thành công ", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(Register.this, response, Toast.LENGTH_LONG).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Register.this, error.toString().trim(), Toast.LENGTH_SHORT).show();

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("tenDN",tendn);
                    params.put("matKhau",matkhau);
                    params.put("Email",emai);
                    params.put("hoTen",hoten);
                    params.put("ngaySinh",ngaysinh);
                    params.put("gioiTinh",gioitinh);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
            requestQueue.add(stringRequest);
//        }else {
//            Toast.makeText(Register.this, "Vui lòng điền đủ các trường", Toast.LENGTH_SHORT).show();
//        }
    }

    private void SetDate(){
        Calendar c = Calendar.getInstance();
        int day=c.get(Calendar.DAY_OF_MONTH);
        int month =c.get(Calendar.MONTH);
        int year =c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                txtNgaySinh.setText(i2 + "/" + (i1 + 1) + "/" + i);
            }
        }, year,month,day);
        datePickerDialog.show();
    }
    private void mapping() {
        txtGioiTinh = findViewById(R.id.txtGioiTinh);
        dropdown_text = findViewById(R.id.dropdown_text);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtSDT = findViewById(R.id.edtSDT);
        edtEmail = findViewById(R.id.edtEmail);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangKy = findViewById(R.id.btnDangKy);
    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
    }
}