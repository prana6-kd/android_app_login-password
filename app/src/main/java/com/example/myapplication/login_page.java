package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_page extends AppCompatActivity {



    public EditText name,password;
    public Button login;
    DBhelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        DB =  new DBhelper(this);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user      = name.getText().toString();
                String upassword = password.getText().toString();

                if(user.equals("")||upassword.equals(""))
                    Toast.makeText(login_page.this,"Please enter all the field",Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkuserpass = DB.checkusernamepassword(user,upassword);
                    if (checkuserpass==true)
                    {
                        Toast.makeText(login_page.this,"Login in Successfull",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent( getApplicationContext(),Dashboard.class);



                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(login_page.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });


    }

}