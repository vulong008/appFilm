package com.example.appfilm.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.model.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class Login extends AppCompatActivity {
    Button btnDangKy;
    TextInputEditText edtTenTaiKhoan,edtMatKhau;
    String taikhoan,matkhau;
    Button btnDangNhap;
    ProgressDialog progressDialog;
    private List<User> userList;
    private User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnDangKy = findViewById(R.id.btnDangKy);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        edtTenTaiKhoan = findViewById(R.id.edtTenTaiKhoan);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        readGetUser1();
        taikhoan = matkhau ="";

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                   // Login("http://nguyentrongquang.freevar.com@nguyentrongquang.freevar.com/account/login.php");
                onClickLogin();




            }
        });


    }

    private void Login(String url){



        taikhoan = edtTenTaiKhoan.getText().toString().trim();
        matkhau = edtMatKhau.getText().toString().trim();
        if (!taikhoan.equals("") && !matkhau.equals("")){

            progressDialog = new ProgressDialog(Login.this);
            progressDialog.show();
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.getWindow().setBackgroundDrawableResource(
                    android.R.color.transparent
            );


            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Log.d("AAA",response);
                    if (response.equalsIgnoreCase("thanhcong")){


                        Intent intent = new Intent(Login.this, MainActivity.class);

                        startActivity(intent);
                        progressDialog.dismiss();

                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Login.this, error.toString().trim(), Toast.LENGTH_SHORT).show();

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("tenDN",taikhoan);
                    params.put("matKhau",matkhau);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
            requestQueue.add(stringRequest);
        }else {
            Toast.makeText(Login.this, "Tài khoản hoặc mật khẩu không được để trống", Toast.LENGTH_SHORT).show();
        }



    }

    private void onClickLogin() {


        String username = edtTenTaiKhoan.getText().toString().trim();
        String matkhau = edtMatKhau.getText().toString().trim();

        if(userList == null|| userList.isEmpty()) {
            return;
        }
        boolean isHasUser = false;
        for (User user:userList){
            if (username.equals(user.getTenDN())&& matkhau.equals(user.getMatKhau())){

                isHasUser = true;
                mUser = user;
                break;

            }
        }


        if (isHasUser){
            progressDialog = new ProgressDialog(Login.this);
            progressDialog.show();
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.getWindow().setBackgroundDrawableResource(
                    android.R.color.transparent
            );

            Intent intent = new Intent(Login.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_user",mUser);
            intent.putExtras(bundle);
            startActivity(intent);
//            intent.putExtra("hoTen",mUser.getHoTen());
//            intent.putExtra("sdt",mUser.getTenDN());
//            intent.putExtra("Email",mUser.getEmail());
//            intent.putExtra("matKhau",mUser.getMatKhau());
//            intent.putExtra("ngaySinh",mUser.getNgaySinh());
//            intent.putExtra("gioiTinh",mUser.getGioiTinh());
//            intent.putExtra("avatar",mUser.getAvatar());



//            bundle.putSerializable("object_user",mUser);
//            intent.putExtras(bundle);





        }else if (username.equals("")||matkhau.equals("")){


            Toast.makeText(this, "Tài khoản hoặc mật khẩu không được để trống", Toast.LENGTH_SHORT).show();


        }else{


            Toast.makeText(this, "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();


        }



    }

    private void readGetUser1() {
        ApiServer.API_SERVER.readGetUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, retrofit2.Response<List<User>> response) {
                userList = response.body();
                Log.e("List User", userList.size() + "");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Login.this, "Call api error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
        super.onBackPressed();
    }
}


