package com.example.mymart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class UserRegistration extends AppCompatActivity {
    private static final String TAG ="message" ;
    EditText et1, et2, et3, et4, et5;
    Button button2;
    FirebaseAuth mAuth;
    String email, password,name,phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        et1 = (EditText) findViewById(R.id.user);
        et2 = (EditText) findViewById(R.id.password);
        et3 = (EditText) findViewById(R.id.repassword);
        et4 = (EditText) findViewById(R.id.phone);
        et5 = (EditText) findViewById(R.id.emailuser);
        button2 = (Button) findViewById(R.id.regist);
        mAuth = FirebaseAuth.getInstance();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input();
            }
        });

    }

    private void input() {
        email = et5.getText().toString();
        password = et2.getText().toString();
        name=et1.getText().toString();
        phoneNumber=et4.getText().toString();
        if (TextUtils.isEmpty(et1.getText().toString())) {
            Toast.makeText(this, "Enter Name...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(et2.getText().toString())) {
            Toast.makeText(this, "Enter Password...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(et4.getText().toString())) {
            Toast.makeText(this, "Enter Phone number...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(et3.getText().toString())) {
            Toast.makeText(this, "Confirm password...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(et5.getText().toString()).matches()) {
            Toast.makeText(this, "Enter correct email...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!(et2.getText().toString()).equals(et3.getText().toString())) {
            Toast.makeText(this, "Password doesn't match...", Toast.LENGTH_SHORT).show();
            return;
        }
        createAccount();

    }

    private void createAccount() {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        saveData();
                    }

                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UserRegistration.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        HashMap<String, Object> user = new HashMap<>();
        user.put("uid",""+mAuth.getUid());
        user.put("email",""+email);
        user.put("name",""+name);
        user.put("phone",""+phoneNumber);
        db.collection("users")
                .document(mAuth.getUid()).set(user)
                .addOnSuccessListener(documentReference -> {
                    startActivity(new Intent(UserRegistration.this, MainActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> {
                    Log.w(TAG, "Error adding document", e);
                    startActivity(new Intent(UserRegistration.this, MainActivity.class));
                    finish();

                });



    }
}