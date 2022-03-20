package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.widget.Button;
import android.content.Intent;
import  android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    public Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button) findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(MainActivity.this,login_page.class);
                startActivity(intent);
            }
        }
        );

        button1 =(Button) findViewById(R.id.signin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,signup_page.class);
                startActivity(intent);
            }
        });

    }
}