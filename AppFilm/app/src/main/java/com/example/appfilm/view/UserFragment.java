package com.example.appfilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appfilm.R;
import com.example.appfilm.model.User;
import com.squareup.picasso.Picasso;


public class UserFragment extends Fragment {



    Button click;
    View view;
    LinearLayout thongtin,dangxuat;
    TextView txtName;
    ImageView avatar;
    String hoten,sdt,email,matkhau,ngaysinh,gioitinh;
    private User mUser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container,false);
        dangxuat = view.findViewById(R.id.dangxuat);
        thongtin = view.findViewById(R.id.thongtin);
        txtName = view.findViewById(R.id.txtName);
        avatar = view.findViewById(R.id.avatar);
        click = view.findViewById(R.id.click);

        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),InfoUser.class);
//                intent.putExtra("tenDN1",hoten);
//                intent.putExtra("sdt",sdt);
//                intent.putExtra("Email",email);
//                intent.putExtra("matKhau",matkhau);
//                intent.putExtra("ngaySinh",ngaysinh);
//                intent.putExtra("gioiTinh",gioitinh);
//                startActivity(intent);

                Intent intent = new Intent(getActivity(), InfoUser.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user1",mUser);
                intent.putExtras(bundle);
                startActivity(intent);
                Log.d("AAAA", String.valueOf(mUser));




            }
        });

//        Intent intent = getActivity().getIntent();
//        hoten = intent.getStringExtra("hoTen");
//        sdt = intent.getStringExtra("sdt");
//        email = intent.getStringExtra("Email");
//        matkhau = intent.getStringExtra("matKhau");
//        ngaysinh = intent.getStringExtra("ngaySinh");
//        gioitinh = intent.getStringExtra("gioiTinh");
//        txtName.setText(hoten);

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null){
            User user = (User) bundle.get("object_user");

            if (user!=null){
                txtName.setText(user.getHoTen());
                 Picasso.get().load(user.getAvatar()).into(avatar);
                 mUser = user;
            }


        }










        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Login.class));
            }
        });



        return view;
    }







}
