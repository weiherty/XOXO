package com.cf.xoxo.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.qiujuer.genius.material.MaterialButton;


public class MainActivity2 extends Activity implements View.OnClickListener {

    MaterialButton mb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        mb1= (MaterialButton) findViewById(R.id.mb1);
        mb1.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
