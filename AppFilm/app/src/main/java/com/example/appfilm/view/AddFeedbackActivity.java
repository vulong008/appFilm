package com.example.appfilm.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appfilm.R;
import com.example.appfilm.adapter.AdapterFeedBack;
import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.model.feedBackFilm;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFeedbackActivity extends AppCompatActivity {

    Button btnThem, btnThoat;
    RatingBar editRating;
    EditText editComment, tenDanhNhap;
    ListView listView1;
    List<feedBackFilm> film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);
        listView1 = findViewById(R.id.listViewFeedBack);
        anhXa();
//        Intent intent = getIntent();
//        int id = intent.getExtras().getInt("idPhim");
//       Log.d("abc",id+"");
        getFeedBack();

//        editRating.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
//
//        editComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastPerfect.makeText(AddFeedbackActivity.this, ToastPerfect.INFORMATION, "Bạn vui lòng đăng nhập để đánh giá nhé.", ToastPerfect.BOTTOM, ToastPerfect.LENGTH_LONG).show();
//                editComment.setFocusable(false);
//                btnThem.setVisibility(View.GONE);
//            }
//        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float star = editRating.getRating();
                String comment = editComment.getText().toString();
                if (star == 0.0 || comment.equals("")) {
                    Toast.makeText(AddFeedbackActivity.this, "Nhập đủ để đánh giá.", Toast.LENGTH_LONG).show();
                } else {
                    insertStudent();
                    btnThem.setVisibility(View.GONE);
                    getFeedBack();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showAlertDialog(AddFeedbackActivity.this);
            }
        });
    }

    private void insertStudent() {
        ApiServer.API_SERVER.insertFeedBack(tenDanhNhap.getText().toString(),
                editRating.getRating(), editComment.getText().toString())
                .enqueue(new Callback<feedBackFilm>() {
                    @Override
                    public void onResponse(Call<feedBackFilm> call, Response<feedBackFilm> response) {
                        editRating.setRating(0);
                        editComment.setText("");
                        Toast.makeText(AddFeedbackActivity.this, "Cảm ơn bạn đã đánh giá.", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<feedBackFilm> call, Throwable t) {
                        Toast.makeText(AddFeedbackActivity.this, "Lỗi thêm!!"+t.toString(), Toast.LENGTH_LONG).show();
                        Log.d("aaa", call.toString());
                    }
                });
    }

    private void anhXa() {
        editRating = findViewById(R.id.ratingBar);
        editComment = findViewById(R.id.editComment);
        tenDanhNhap = findViewById(R.id.tenDN);
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.Huy);
    }

    private void getFeedBack() {
        ApiServer.API_SERVER.getAllFeedBack().enqueue(new Callback<List<feedBackFilm>>() {
            @Override
            public void onResponse(Call<List<feedBackFilm>> call, Response<List<feedBackFilm>> response) {
                film = new ArrayList<feedBackFilm>();
                film = response.body();
                for (int i = 0; i < film.size(); i++) {
                    AdapterFeedBack adapterInforFilm1 =
                            new AdapterFeedBack(AddFeedbackActivity.this,
                                    R.layout.dong_layout_feedback, film);
                    listView1.setAdapter(adapterInforFilm1);
                }
            }

            @Override
            public void onFailure(Call<List<feedBackFilm>> call, Throwable t) {
                Toast.makeText(AddFeedbackActivity.this, "Lỗi get!!"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showAlertDialog(final Context context) {
        final Drawable positiveIcon = context.getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24);
        final Drawable negativeIcon = context.getResources().getDrawable(R.drawable.ic_sharp_close_24);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // Set Title and Message:
        builder.setTitle("XÁC NHẬN").setMessage("Bạn chắc chắn muốn thoát?");
        //
        builder.setCancelable(true);
        builder.setIcon(R.drawable.iron_man);

        // Create "Yes" button with OnClickListener.
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onBackPressed();
            }
        });
        builder.setPositiveButtonIcon(positiveIcon);

        // Create "No" button with OnClickListener.
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Cancel
                dialog.cancel();
            }
        });
        builder.setNegativeButtonIcon(negativeIcon);

        // Create AlertDialog:
        AlertDialog alert = builder.create();
        alert.show();
    }

}