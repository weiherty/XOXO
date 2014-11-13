package com.cf.xoxo.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import me.drakeet.materialdialog.MaterialDialog;


public class MainActivity extends Activity implements View.OnClickListener {

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
    ImageButton about;
    Button bback;
    Button bshow;
    int xscore =0;
    int oscore =0;
    int escore =0;
    android.content.DialogInterface.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）


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


        bback = (Button)findViewById(R.id.button2);
        bback.setOnClickListener(this);
        bback.setTag("noback");
        bback.setText("不能再悔");

        bshow = (Button)findViewById(R.id.button3);
        bshow.setText("游戏记录：XX赢"+xscore+"局，打平"+escore+"局，OO赢"+oscore+"局");

        about = (ImageButton) findViewById(R.id.imageButton10);
        about.setMinimumWidth(about.getHeight());
        about.setTag("about");
        about.setOnClickListener(this);
        cleanAll();
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
        if(view.getTag()=="about")
        {
            final MaterialDialog mMaterialDialog = new MaterialDialog(this);

            mMaterialDialog.setTitle("游戏说明")
                    .setMessage("游戏开始后，玩家点击九个方格中的任意一个，方格中会显示O的图案，" +
                            "此时换另一个玩家点击剩余的方格，方格中会显示X的图案，" +
                            "如此轮流直到某一图案排成3个一竖、一横或一斜线，" +
                            "否则则为平局。")
                    .setPositiveButton("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mMaterialDialog.dismiss();
                        }
                    })
                    .setNegativeButton("CANCEL", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mMaterialDialog.dismiss();
                        }
                    });

            mMaterialDialog.show();
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

                final MaterialDialog mMaterialDialog = new MaterialDialog(this);
                mMaterialDialog.setTitle("OO IS WINNER")
                        .setMessage("Congratulations!")
                        .setPositiveButton("RESTART", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                                cleanAll();
                            }
                        })
                        .setNegativeButton("CANCEL", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                            }
                        });
                mMaterialDialog.show();
            }
            else if(checkWinner()==2)
            {
                xscore++;
                bshow.setText("游戏记录：XX赢"+xscore+"局，打平"+escore+"局，OO赢"+oscore+"局");

                final MaterialDialog mMaterialDialog = new MaterialDialog(this);
                mMaterialDialog.setTitle("XX IS WINNER")
                        .setMessage("Congratulations!")
                        .setPositiveButton("RESTART", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                                cleanAll();
                            }
                        })
                        .setNegativeButton("CANCEL", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                            }
                        });
                mMaterialDialog.show();
            }
            else if(checkWinner()==3)
            {
                escore++;
                bshow.setText("游戏记录：XX赢"+xscore+"局，打平"+escore+"局，OO赢"+oscore+"局");

                final MaterialDialog mMaterialDialog = new MaterialDialog(this);
                mMaterialDialog.setTitle("XOXO play even")
                        .setMessage("Congratulations!")
                        .setPositiveButton("RESTART", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                                cleanAll();
                            }
                        })
                        .setNegativeButton("CANCEL", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                            }
                        });
                mMaterialDialog.show();
            }
        }
    }

}
