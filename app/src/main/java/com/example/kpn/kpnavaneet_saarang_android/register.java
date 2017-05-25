package com.example.kpn.kpnavaneet_saarang_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent i = getIntent();
    }

   //onClick method for the confirm register button
   //Displays a Toast for the confirmation .

    public void save(View view)
    {
        Toast.makeText(this,"Registered!",Toast.LENGTH_SHORT).show();
        finish();
    }



}
