package com.example.yatindhingra.savered;

import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class loginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText userName;
    private EditText passWord;
    private Button loginBtn;
    private Button signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.uname);
        passWord = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);
        signupBtn = (Button) findViewById(R.id.signup);


        try {
            if (mAuth.getCurrentUser() != null) {
                Intent i = new Intent(loginActivity.this, carousal.class);
                loginActivity.this.startActivity(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        Intent i = new Intent(loginActivity.this, MapsActivity.class);
//        loginActivity.this.startActivity(i);

        mAuth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = userName.getText().toString();
                final String pass = passWord.getText().toString();
                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(loginActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //start yor activity here
                                    Intent i = new Intent(loginActivity.this, carousal.class);
                                    loginActivity.this.startActivity(i);
                                } else {
                                    Log.d("hello", "h");
                                }
                            }
                        });
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = userName.getText().toString();
                final String pass = passWord.getText().toString();
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(loginActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //start yor activity here
                                    Intent i = new Intent(loginActivity.this, carousal.class);
                                    loginActivity.this.startActivity(i);
                                } else {
                                    Log.d("hello", "h");
                                }
                            }
                        });
            }
        });

    }
}
