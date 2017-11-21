package com.hansung.android.project2;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.SoftReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu_DetailFragment extends Fragment {

    String Name;
    String Price;
    String Photo ;


    public Menu_DetailFragment() {
        // Required empty public constructor
    }


    public void viewDetail(String name, String price, String photo){

        Name = name;
        Price = price;
        Photo = photo;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu__detail, container, false);
        //Image 설정
        ImageView image=(ImageView)view.findViewById(R.id.image1) ;
        Bitmap bitmap = BitmapFactory.decodeFile(Photo);
        image.setImageBitmap(bitmap);

        //음식 이름 설정
        TextView name = (TextView)view.findViewById(R.id.text1);
        name.setText(Name);

        //가격 설정
        TextView name2 = (TextView)view.findViewById(R.id.text2);
        name2.setText(Price+"원");

        return view;
    }

}
