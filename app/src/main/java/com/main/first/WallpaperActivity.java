package com.main.first;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WallpaperActivity extends AppCompatActivity {

    ImageView big_picture;
    Button set_wallpaper;
    LinearLayout linear_layout;
    TextView text_view;
    View.OnClickListener changeWallpaperListener, openDialogListener;

    int to_phone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        big_picture = findViewById(R.id.iv_bigpicture);
        set_wallpaper = findViewById(R.id.btn_change_wallpaper);
        linear_layout = findViewById(R.id.ll_view);
        text_view = findViewById(R.id.tv_test_text);

        Intent intent = getIntent();
        text_view.setText(intent.getStringExtra("NAME"));

        setupImageList();

        changeWallpaperListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream is = getResources().openRawResource(to_phone);
                Bitmap pic = BitmapFactory.decodeStream(is);

                WallpaperManager myWallpaper = WallpaperManager.getInstance(getApplicationContext());

                try {
                    myWallpaper.setBitmap(pic);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        set_wallpaper.setOnClickListener(changeWallpaperListener);

        openDialogListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(new BottomSheetDialog.OnCalculationListener() {
                    @Override
                    public void onCalculationClicked(String clicked) {
                        text_view.setText(clicked);
                    }
                });

                bottomSheetDialog.show(getSupportFragmentManager(),"TAG");
            }
        };

        //set_wallpaper.setOnClickListener(openDialogListener);
    }

    private void setupImageList() {

        for(int i=1;i<=13;i++){
            final ImageView iv = new ImageView(this);
            String a = "spic"+Integer.toString(i);
            int id = getResources().getIdentifier(a,"drawable",getPackageName());
            iv.setImageResource(id);
            iv.setId(i);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(500, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10,20,20,30);
            iv.setLayoutParams(lp);
            linear_layout.addView(iv);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int ide = iv.getId();
                    String b = "pic"+Integer.toString(ide);
                    int id = getResources().getIdentifier(b,"drawable",getPackageName());
                    big_picture.setImageResource(id);

                    to_phone = id;
                }
            });

        }

    }
}
