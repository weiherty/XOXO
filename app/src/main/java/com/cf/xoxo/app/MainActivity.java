package com.cf.xoxo.app;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;



public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    static int step =0;
    ImageButton b11;
    ImageButton b12;
    ImageButton b13;
    ImageButton b21;
    ImageButton b22;
    ImageButton b23;
    ImageButton b31;
    ImageButton b32;
    ImageButton b33;
    ImageButton back;
    Button bback;
    Button bshow;
    int xscore =0;
    int oscore =0;
    int escore =0;
    android.content.DialogInterface.OnClickListener listener;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        //int version = Integer.parseInt(Build.VERSION.SDK);
        //if(version == Build.VERSION_CODES.KITKAT) {
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
       // }
        setContentView(R.layout.activity_main);

        b11=(ImageButton)findViewById(R.id.imageButton);
        b12=(ImageButton)findViewById(R.id.imageButton2);
        b13=(ImageButton)findViewById(R.id.imageButton3);
        b21=(ImageButton)findViewById(R.id.imageButton4);
        b22=(ImageButton)findViewById(R.id.imageButton5);
        b23=(ImageButton)findViewById(R.id.imageButton6);
        b31=(ImageButton)findViewById(R.id.imageButton7);
        b32=(ImageButton)findViewById(R.id.imageButton8);
        b33=(ImageButton)findViewById(R.id.imageButton9);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        b23.setOnClickListener(this);
        b31.setOnClickListener(this);
        b32.setOnClickListener(this);
        b33.setOnClickListener(this);
        int bwidth = (width-2*dip2px(this,16))/3;
        b11.setMinimumWidth(bwidth);
        b11.setMinimumHeight(bwidth);
        b12.setMinimumWidth(bwidth);
        b12.setMinimumHeight(bwidth);
        b13.setMinimumWidth(bwidth);
        b13.setMinimumHeight(bwidth);
        b21.setMinimumWidth(bwidth);
        b21.setMinimumHeight(bwidth);
        b22.setMinimumWidth(bwidth);
        b22.setMinimumHeight(bwidth);
        b23.setMinimumWidth(bwidth);
        b23.setMinimumHeight(bwidth);
        b31.setMinimumWidth(bwidth);
        b31.setMinimumHeight(bwidth);
        b32.setMinimumWidth(bwidth);
        b32.setMinimumHeight(bwidth);
        b33.setMinimumWidth(bwidth);
        b33.setMinimumHeight(bwidth);

        listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cleanAll();
            }
        };

        Button breset=(Button)findViewById(R.id.button);
        breset.setOnClickListener(this);
        breset.setTag("reset");
        breset.setText("重新开始");
        breset.setBackgroundColor(Color.parseColor("#FFFFFF"));


        bback = (Button)findViewById(R.id.button2);
        bback.setOnClickListener(this);
        bback.setTag("noback");
        bback.setText("不能再悔");
        bback.setBackgroundColor(Color.parseColor("#FFFFFF"));

        bshow = (Button)findViewById(R.id.button3);
        bshow.setText("游戏记录：XX赢"+xscore+"局，打平"+escore+"局，OO赢"+oscore+"局");

        cleanAll();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_about) {
            new AlertDialog.Builder(this)
                    .setTitle("C.F.xoxo")
                    .setMessage("C.F.works出品，品质保证，童叟无欺\n版本v1.0")
                    .setPositiveButton("确定", null)
                    .show();
            return true;
        }
        if (id == R.id.action_setting) {
            new AlertDialog.Builder(this)
                    .setTitle("游戏规则说明")
                    .setMessage("井字棋\n" +
                            "游戏人数：2人\n" +
                            "游戏流程：游戏双方轮流点击九宫格空白区域\n" +
                            "胜利条件：任意一方的三个棋子连成一条直线得胜")
                    .setPositiveButton("确定", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void cleanAll()
    {
        b11.setBackgroundResource(R.drawable.blank);
        b12.setBackgroundResource(R.drawable.blank);
        b13.setBackgroundResource(R.drawable.blank);
        b21.setBackgroundResource(R.drawable.blank);
        b22.setBackgroundResource(R.drawable.blank);
        b23.setBackgroundResource(R.drawable.blank);
        b31.setBackgroundResource(R.drawable.blank);
        b32.setBackgroundResource(R.drawable.blank);
        b33.setBackgroundResource(R.drawable.blank);
        b11.setTag("unset");
        b12.setTag("unset");
        b13.setTag("unset");
        b21.setTag("unset");
        b22.setTag("unset");
        b23.setTag("unset");
        b31.setTag("unset");
        b32.setTag("unset");
        b33.setTag("unset");
        step =0;
    }
    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }
    int checkWinner()
    {
        int res;
        if((b11.getTag()=="oo"&&b22.getTag()=="oo"&&b33.getTag()=="oo")
                ||(b13.getTag()=="oo"&&b22.getTag()=="oo"&&b31.getTag()=="oo")
                ||(b11.getTag()=="oo"&&b12.getTag()=="oo"&&b13.getTag()=="oo")
                ||(b21.getTag()=="oo"&&b22.getTag()=="oo"&&b23.getTag()=="oo")
                ||(b31.getTag()=="oo"&&b32.getTag()=="oo"&&b33.getTag()=="oo")
                ||(b11.getTag()=="oo"&&b21.getTag()=="oo"&&b31.getTag()=="oo")
                ||(b12.getTag()=="oo"&&b22.getTag()=="oo"&&b32.getTag()=="oo")
                ||(b13.getTag()=="oo"&&b23.getTag()=="oo"&&b33.getTag()=="oo")
                )
        {
            res = 1;
        }
        else if((b11.getTag()=="xx"&&b22.getTag()=="xx"&&b33.getTag()=="xx")
                ||(b13.getTag()=="xx"&&b22.getTag()=="xx"&&b31.getTag()=="xx")
                ||(b11.getTag()=="xx"&&b12.getTag()=="xx"&&b13.getTag()=="xx")
                ||(b21.getTag()=="xx"&&b22.getTag()=="xx"&&b23.getTag()=="xx")
                ||(b31.getTag()=="xx"&&b32.getTag()=="xx"&&b33.getTag()=="xx")
                ||(b11.getTag()=="xx"&&b21.getTag()=="xx"&&b31.getTag()=="xx")
                ||(b12.getTag()=="xx"&&b22.getTag()=="xx"&&b32.getTag()=="xx")
                ||(b13.getTag()=="xx"&&b23.getTag()=="xx"&&b33.getTag()=="xx")
                )
        {
            res =2;
        }
        else if(b11.getTag()!="unset"&&b12.getTag()!="unset"&&b13.getTag()!="unset"
                &&b21.getTag()!="unset"&&b22.getTag()!="unset"&&b23.getTag()!="unset"
                &&b31.getTag()!="unset"&&b32.getTag()!="unset"&&b33.getTag()!="unset"
                )
        {
            res =3;
        }
        else
        {
            res =0;
        }
        return res;
    }
    @Override
    public void onClick(View view) {
        if(view.getTag() =="reset")
        {
            cleanAll();
            return;
        }
        if(view.getTag() =="back")
        {
            back.setBackgroundResource(R.drawable.blank);
            back.setTag("unset");
            step--;
            bback.setTag("noback");
            bback.setText("不能再悔");
            return;
        }
        if(view.getTag() =="unset") {
            if (step % 2 == 0) {
                view.setTag("oo");
                view.setBackgroundResource(R.drawable.oo);
            } else {
                view.setTag("xx");
                view.setBackgroundResource(R.drawable.xx);
            }
            bback.setTag("back");
            bback.setText("悔棋一步");
            back = (ImageButton) view;
            step++;
            if(checkWinner()==1) {
                oscore++;
                bshow.setText("游戏记录：XX赢"+xscore+"局，打平"+escore+"局，OO赢"+oscore+"局");
                ImageView img = new ImageView(this);
                img.setImageResource(R.drawable.oo);
                new AlertDialog.Builder(this)
                        .setTitle("OO IS WINNER")
                        .setView(img)
                        .setPositiveButton("重新开始", listener)
                        .show();
            }
            else if(checkWinner()==2)
            {
                xscore++;
                bshow.setText("游戏记录：XX赢"+xscore+"局，打平"+escore+"局，OO赢"+oscore+"局");
                ImageView img = new ImageView(this);
                img.setImageResource(R.drawable.xx);
                new AlertDialog.Builder(this)
                        .setTitle("XX IS WINNER")
                        .setView(img)
                        .setPositiveButton("重新开始", listener)
                        .show();
            }
            else if(checkWinner()==3)
            {
                escore++;
                bshow.setText("游戏记录：XX赢"+xscore+"局，打平"+escore+"局，OO赢"+oscore+"局");
                ImageView img = new ImageView(this);
                img.setImageResource(R.drawable.xin);
                new AlertDialog.Builder(this)
                        .setTitle("XOXO play even")
                        .setView(img)
                        .setPositiveButton("重新开始", listener)
                        .show();
            }
        }
    }

}
