package com.example.noa_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button entermyacc,createmyacc,enterwithoutacc,one;
CustomDialog customDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entermyacc=findViewById(R.id.btnA);
        createmyacc=findViewById(R.id.btnNewA);
        enterwithoutacc=findViewById(R.id.btnNA);
            enterwithoutacc.setOnClickListener(this);
            createmyacc.setOnClickListener(this);
            entermyacc.setOnClickListener(this);
             one =findViewById(R.id.button9);
            one.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==createmyacc)
        {
            Intent intent= new Intent(this, NewAccountActivity.class);
            startActivity(intent);
        } else if (v==enterwithoutacc) {
            Intent intent= new Intent(this, SearchSongActivity.class);
            startActivity(intent);

        }
        if (v==entermyacc)
        {
            Intent intent=new Intent(this,LogingActivity.class);
            startActivity(intent);
        }
        if (v==one)
        {
            Intent intent=new Intent(this, MainActivity2.class);
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

         customDialog = new CustomDialog(this);
        customDialog.show();

    }
}