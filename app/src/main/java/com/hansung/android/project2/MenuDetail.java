package com.hansung.android.project2;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import static android.support.v4.graphics.drawable.DrawableCompat.setTint;

public class MenuDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        Intent intent =getIntent();
        String Name=intent.getStringExtra("Option1");
        String Photo=intent.getStringExtra("Option2");
        String Price=intent.getStringExtra("Option3");

        Menu_DetailFragment menu_detailFragment = new Menu_DetailFragment();
        menu_detailFragment.viewDetail(Name,Price,Photo);
        getSupportFragmentManager().beginTransaction().replace(R.id.details, menu_detailFragment).commit();

    }

}
