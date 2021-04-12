package com.example.toutouzi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_1d2;
    private Button btn_1d6;
    private Button btn_1d100;
    private EditText et_cs;
    private EditText et_max;
    private EditText et_bz;
    private Button btn_zdy;
    private int cs;
    private int max;
    private int bz;
    private int rand;
    private int min;
    private int ma;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initView(){
        btn_1d2=findViewById(R.id.btn_1d2);
        btn_1d6=findViewById(R.id.btn_1d6);
        btn_1d100=findViewById(R.id.btn_1d100);
        et_cs=findViewById(R.id.et_cs);
        et_max=findViewById(R.id.et_max);
        et_bz=findViewById(R.id.et_bz);
        btn_zdy=findViewById(R.id.btn_zdy);
    }
    private void initData(){
        btn_1d2.setOnClickListener(this);
        btn_1d6.setOnClickListener(this);
        btn_1d100.setOnClickListener(this);
        btn_zdy.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        flag=true;
        switch (v.getId()){
            case R.id.btn_1d2:
                rand=TouTouZi(2);
                break;
            case R.id.btn_1d6:
                rand=TouTouZi(6);
                break;
            case R.id.btn_1d100:
                rand=TouTouZi(100);
                break;
            case R.id.btn_zdy:{
                bz=0;
                if(et_cs.getText().toString().trim().equals("")||et_max.getText().toString().trim().equals("")){
                    flag=false;
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle(this.getString(R.string.error))
                            .setMessage(this.getString(R.string.isEmpty));
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
                else if(!isNumeric(et_cs.getText().toString())||!isNumeric(et_max.getText().toString())){
                    flag=false;
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle(this.getString(R.string.error))
                            .setMessage(this.getString(R.string.NotIsNumber));
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
                else{
                    if(!et_bz.getText().toString().trim().equals(""))
                        bz=Integer.parseInt(et_bz.getText().toString());
                    cs=Integer.parseInt(et_cs.getText().toString());
                    max=Integer.parseInt(et_max.getText().toString());
                }
                rand=TouTouZi(cs,max,bz);
                break;
            }

        }
        if(flag){

            Intent intent=new Intent(MainActivity.this,ViewActivity.class);
            intent.putExtra("rand",rand);
            intent.putExtra("ma",ma);
            intent.putExtra("min",min);
            startActivity(intent);
        }

    }
    public  int TouTouZi(int i){
        ma=i;
        min =1;
        return (int) (Math.random()*i+1);

    }
    public  int TouTouZi(int i,int j,int k){
        ma =i*j+k;
        min =i+k;
        return (int) (Math.random()*(i*j-i+1)+i+k);
    }

    /**
     * 判断是否为数字
     * @param str 输入字符串
     * @return true或false
     */
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }


}