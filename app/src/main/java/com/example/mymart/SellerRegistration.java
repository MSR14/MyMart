package com.example.mymart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SellerRegistration extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4,ed5,ed6;
    Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_registration);
        ed1 = (EditText) findViewById(R.id.seller);
        ed2 = (EditText) findViewById(R.id.passw);
        ed3 = (EditText) findViewById(R.id.repassw);
        ed4 = (EditText) findViewById(R.id.phnbr);
        ed5=(EditText) findViewById(R.id.emailseller);
        ed6=(EditText) findViewById(R.id.shname);
        butt = (Button) findViewById(R.id.buttona);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input();
            }
        });
    }

    private void input() {
        if (TextUtils.isEmpty(ed1.getText().toString())){
            Toast.makeText(this, "Enter Name...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(ed2.getText().toString())){
            Toast.makeText(this, "Enter Password...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(ed4.getText().toString())){
            Toast.makeText(this, "Enter Phone number...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(ed3.getText().toString())){
            Toast.makeText(this, "Confirm password...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(ed5.getText().toString()).matches()){
            Toast.makeText(this, "Enter correct email...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!(ed2.getText().toString()).equals(ed3.getText().toString())){
            Toast.makeText(this, "Password doesn't match...", Toast.LENGTH_SHORT).show();
            return;
        }
        createAccount();

    }

    private void createAccount() {

    }
}


