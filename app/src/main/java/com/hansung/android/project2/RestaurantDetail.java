package com.hansung.android.project2;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantDetail extends AppCompatActivity {

    private DBHelper mDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        getContributes();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_menu:
                startActivity(new Intent(this,Registration_Menu.class));
        }
        return super.onOptionsItemSelected(item);
    }

    protected void getContributes(){
        mDbHelper = new DBHelper(this);

        Cursor c = mDbHelper.getAllUsersByMethod();
        c.moveToLast();
        int i= c.getInt(0);
        c.moveToFirst();

        while(c.moveToNext()){

            if(c.getInt(0)==i){
                TextView textView1 = (TextView) findViewById(R.id.restaurant_name);
                TextView textView2 = (TextView) findViewById(R.id.restaurant_add);
                TextView textView3 = (TextView) findViewById(R.id.restaurant_tel);
                ImageView imageView = (ImageView) findViewById(R.id.restaurant_image);

                textView1.setText(c.getString(1));
                textView2.setText(c.getString(2));
                textView3.setText(c.getString(3));

                Bitmap bitmap = BitmapFactory.decodeFile(c.getString(4));
                imageView.setImageBitmap(bitmap);

            }
        }















    }
}
