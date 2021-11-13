package com.example.buildmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int[] ID_DRAWABLES = {R.drawable.ic_mess, R.drawable.ic_flight, R.drawable.ic_hospital,

            R.drawable.ic_hotel, R.drawable.ic_restaurant, R.drawable.ic_cocktail,

            R.drawable.ic_store, R.drawable.ic_work, R.drawable.ic_time, R.drawable.ic_education, R.drawable.ic_movie};



    private static final int[] ID_TEXTS = {R.string.txt_mess, R.string.txt_flight, R.string.txt_hospital,

            R.string.txt_hotel, R.string.txt_restaurant, R.string.txt_coctail,

            R.string.txt_store, R.string.txt_work, R.string.txt_time, R.string.txt_education, R.string.txt_movie};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){

        LinearLayout lnMain = findViewById(R.id.ln_main);
        lnMain.removeAllViews();

        //Tạo ra các Item topic động và add vào LinearLayout
        for (int i = 0; i < ID_DRAWABLES.length; i++) {
            /*LayoutInflater là 1 component giúp bạn chuyển layout file(Xml) thành View(Java code) trong Android.
            * Khi sử dụng LayoutInflater phải import thư viện android.view.LayoutInflater
            * Read more: https://viblo.asia/p/tim-hieu-ve-layoutinflater-trong-android-07LKXzL2lV4 */
            View v = LayoutInflater.from(this).inflate(R.layout.item_topic, null);

            //thay thế icon và text mới vào layout item_topic.xml
            ImageView ivTopic = v.findViewById(R.id.iv_topic);
            TextView tvTopic = v.findViewById(R.id.tv_topic);
            ivTopic.setImageResource(ID_DRAWABLES[i]);
            tvTopic.setText(ID_TEXTS[i]);

            //Quy định không gian chiếm của mỗi item view = 1
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            );

            //chèn layout item_topic đã thay đổi icon+text vào đối tượng LinearLayout trong layout activity_main.xml
            v.setLayoutParams(param);
            lnMain.addView(v);
        }
    }
}