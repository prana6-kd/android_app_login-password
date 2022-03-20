package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup_page extends AppCompatActivity{
    EditText name,age,email,password;
    public Button register;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.emailid);
        age = (EditText) findViewById(R.id.age);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.button4);
        DB = new DBhelper(this);


        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String user = name.getText().toString();
                String useremail = email.getText().toString();
                String ageyear = age.getText().toString();
                String upassword = password.getText().toString();

                if(user.equals("")||useremail.equals("")||ageyear.equals("")||upassword.equals(""))
                    Toast.makeText(signup_page.this,"Please enter all the field",Toast.LENGTH_SHORT).show();
                else
                    if (upassword.equals(upassword))
                    {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false)
                        {
                            Boolean insert = DB.insertData(user, upassword, ageyear, useremail);
                            if (insert == true)
                            {
                                Toast.makeText(signup_page.this,"Registration Completed",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(signup_page.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(signup_page.this,"User already Exists, please login",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(signup_page.this,"Password not matching",Toast.LENGTH_SHORT).show();
                    }
            }



        });

    }



    public void registertolongin(View view) {
        Intent intent = new Intent(this,login_page.class);
        startActivity(intent);
    }
}