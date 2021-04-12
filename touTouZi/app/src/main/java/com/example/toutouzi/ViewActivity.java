package com.example.toutouzi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;




public class ViewActivity extends AppCompatActivity {
    int rand;
    int ma ;
    int min;
    TextView tv_js;
    RotateAnimation rotateAnimation= null;
    LinearInterpolator linearInterpolator = null;
    ImageView imageView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tv_js=findViewById(R.id.tv_js);
        Intent intent=this.getIntent();
        rand=intent.getIntExtra("rand",0);
        ma=intent.getIntExtra("ma",0);
        min=intent.getIntExtra("min",0);
        String str=String.valueOf(rand);
        tv_js.setText(str);
    }
//    private  void Init(){
//        imageView = findViewById(R.id.iv);
//        rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
//        linearInterpolator = new LinearInterpolator();
//        rotateAnimation.setDuration(2000);
//        rotateAnimation.setRepeatCount(-1);
//        rotateAnimation.setInterpolator(linearInterpolator);
//        imageView.startAnimation(rotateAnimation);
//    }
}
