package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ProfileActivity extends AppCompatActivity {
    ImageView imageview;
    TextView username;
    TextView phone;
    TextView location;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        imageview = (ImageView)findViewById(R.id.img1);
        username = (TextView)findViewById(R.id.username);
        phone = (TextView)findViewById(R.id.phone);
        location = (TextView)findViewById(R.id.location);

        Intent it = getIntent();

        int imageNumber = it.getIntExtra("image",0);
        if(imageNumber==0){
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p12));
        }else if(imageNumber == 1){
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p11));
        }else if(imageNumber == 2){
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p13));
        }
        else if(imageNumber == 3){
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p10));
        }else if(imageNumber == 4){
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p14));
        }
        username.setText(it.getStringExtra("title"));
        phone.setText(it.getStringExtra("desc"));
        location.setText(it.getStringExtra("location"));
    }
}
