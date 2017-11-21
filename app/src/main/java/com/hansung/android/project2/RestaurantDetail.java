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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantDetail extends AppCompatActivity {

    private DBHelper mDbHelper;
    static MyAdapter adapter;
    ArrayList<MyItem> data = new ArrayList<MyItem>();




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
                startActivityForResult(new Intent(this,Registration_Menu.class),1);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        Intent intent = getIntent();
        int i = intent.getIntExtra("aa",1);
        if(i==3||i==4){
            getContributes2();
            Log.i("asd","onresume");
        }
        super.onResume();
    }


    protected void getContributes(){

        Log.i("asd","contributes1");
        mDbHelper = new DBHelper(this);

        Cursor cursor_restaurant = mDbHelper.getAllRestaurantsByMethod();
        int i= cursor_restaurant.getCount();


        while(cursor_restaurant.moveToNext()){
            Log.i("asd",""+i);
            Log.i("asd", ""+cursor_restaurant.getInt(0));

            if(cursor_restaurant.getInt(0)==i){
                TextView textView1 = (TextView) findViewById(R.id.restaurant_name);
                TextView textView2 = (TextView) findViewById(R.id.restaurant_add);
                TextView textView3 = (TextView) findViewById(R.id.restaurant_tel);
                ImageView imageView = (ImageView) findViewById(R.id.restaurant_image);

                textView1.setText(cursor_restaurant.getString(1));
                textView2.setText(cursor_restaurant.getString(2));
                textView3.setText(cursor_restaurant.getString(3));

                Bitmap bitmap = BitmapFactory.decodeFile(cursor_restaurant.getString(4));
                imageView.setImageBitmap(bitmap);

            }
        }


        /******************************************************/

    }

    public void getContributes2(){


        Log.i("asd","contibutes2");


        Cursor cursor_restaurant = mDbHelper.getAllRestaurantsByMethod();
        Cursor cursor_menu = mDbHelper.getAllMenusByMethod();

        int ID = cursor_restaurant.getCount();



        while(cursor_menu.moveToNext()){
            if(cursor_menu.getInt(1)==ID){
                String menu_name = cursor_menu.getString(2);
                String menu_price = cursor_menu.getString(3);
                String menu_photo = cursor_menu.getString(5);
                data.add(new MyItem(menu_photo, menu_name, menu_price));

            }
        }








        //어댑터 생성
        adapter = new MyAdapter(this, R.layout.item, data);

        //어댑터 연결
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        //Listner 부착
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {

                String name = ((MyItem)adapter.getItem(position)).nName;
                String Photo=((MyItem)adapter.getItem(position)).mphoto;
                String Price=((MyItem)adapter.getItem(position)).nPrice;


                //MenuDetail에 속성값 전달
                Intent intent=new Intent(getApplicationContext(),MenuDetail.class);
                intent.putExtra("Option1",name);
                intent.putExtra("Option2",Photo);
                intent.putExtra("Option3",Price);
                startActivity(intent);

            }
        });

    }
}
