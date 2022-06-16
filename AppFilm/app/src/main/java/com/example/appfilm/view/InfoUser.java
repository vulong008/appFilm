package com.example.appfilm.view;

import android.app.DatePickerDialog;
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
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appfilm.R;
import com.example.appfilm.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class InfoUser extends AppCompatActivity {
    TextInputLayout txtGioiTinh;
    AutoCompleteTextView dropdown_text,txtNgaySinh;
    TextInputEditText edtHoTen,edtSDT,edtEmail,edtMatKhau;
    Button btnSuaThongTin;
    Toolbar toolbar;
    String hoten;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_profile_user);
        mapping();


        String[] items=new String[]{
                "Nam",
                "Nữ",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                InfoUser.this,
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
//        Intent intent = getIntent();
//        String hoten = intent.getStringExtra("tenDN1");
//        String sdt = intent.getStringExtra("sdt");
//        String email = intent.getStringExtra("Email");
//        String matkhau = intent.getStringExtra("matKhau");
//        String ngaysinh = intent.getStringExtra("ngaySinh");
//        String gioitinh = intent.getStringExtra("gioiTinh");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            User user = (User) bundle.get("object_user1");
            if (user!=null){
                edtSDT.setText(user.getTenDN());
                edtHoTen.setText(user.getHoTen());
                edtEmail.setText(user.getEmail());
                edtMatKhau.setText(user.getMatKhau());
                txtNgaySinh.setText(user.getNgaySinh());
                dropdown_text.setText(user.getGioiTinh());
                Log.d("AAA", String.valueOf(user));



            }
        }
//        edtSDT.setText(sdt);
//        edtHoTen.setText(hoten);
//        edtEmail.setText(email);
//        edtMatKhau.setText(matkhau);
//        txtNgaySinh.setText(ngaysinh);
//        dropdown_text.setText(gioitinh);
        btnSuaThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateUser("http://nguyentrongquang.freevar.com@nguyentrongquang.freevar.com/account/UpdateUser.php");

            }
        });



    }

    private void updateUser(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Thanhcong")){
                            Toast.makeText(InfoUser.this, "Sửa thông tin thành công"+response, Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(InfoUser.this,UserFragment.class));

                        }else {
                            Toast.makeText(InfoUser.this, "Sửa thất bại"+response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(InfoUser.this, "Có lỗi xảy ra"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                Log.d("AAA",""+edtHoTen);
                //map.put("id",String.valueOf(id));
                map.put("hoTen",edtHoTen.getText().toString().trim());
                map.put("ngaySinh",txtNgaySinh.getText().toString().trim());
                map.put("gioiTinh",dropdown_text.getText().toString().trim());
                map.put("tenDN",edtSDT.getText().toString().trim());
                map.put("matKhau",edtMatKhau.getText().toString().trim());
                map.put("Email",edtEmail.getText().toString().trim());
                return map;
            }
        };
        requestQueue.add(stringRequest);

    }







    private void mapping() {
        txtGioiTinh = findViewById(R.id.txtGioiTinh);
        dropdown_text = findViewById(R.id.dropdown_text);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtSDT = findViewById(R.id.edtSDT);
        edtEmail = findViewById(R.id.edtEmail);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnSuaThongTin = findViewById(R.id.btnSuaThongTin);
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


}
