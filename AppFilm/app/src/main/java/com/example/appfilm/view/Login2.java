package com.example.appfilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfilm.R;
import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login2 extends AppCompatActivity {
    EditText edttenDN,edtMatKhau;
    Button btnlogin;
    private List<User> userList;
    private User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edttenDN = findViewById(R.id.edtTenTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnlogin = findViewById(R.id.btnDangNhap);
        readGetUser1();
        userList = new ArrayList<>();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLogin();
            }
        });
    }

    private void onClickLogin() {
        String username = edttenDN.getText().toString().trim();
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
            Intent intent = new Intent(Login2.this, MainActivity.class);
            Bundle bundle = new Bundle();
            intent.putExtra("tenDN",mUser.getHoTen());
//            bundle.putSerializable("object_user",mUser);
//            intent.putExtras(bundle);
            startActivity(intent);
        }else if (username.equals("")||matkhau.equals("")){

            Toast.makeText(this, "Tài khoản hoặc mật khẩu không được để trống", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
        }
    }

    private void readGetUser1() {
        ApiServer.API_SERVER.readGetUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = response.body();
                Log.e("List User", userList.size() + "");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Login2.this, "Call api error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}