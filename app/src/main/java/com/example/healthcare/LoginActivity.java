package com.example.healthcare;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {

    EditText edUser,edPassword;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser= findViewById(R.id.editTextLoginUsername);
        edPassword= findViewById(R.id.editTextLoginPassword);
        Button btn = findViewById(R.id.button);
        tv=   findViewById(R.id.textView3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUser.getText().toString();
                String Pass=edPassword.getText().toString()
                        ;
                Database db=new Database(getApplicationContext(),"healthcare",null,1);;
                if(username.length()==0 && Pass.length()==0){
                    Toast.makeText(getApplicationContext(),"please fill all details",Toast.LENGTH_SHORT).show();
                }else{
                    if(db.Login(username,Pass)==1){
                        Toast.makeText(getApplicationContext(),"login succseful",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences=getSharedPreferences("shared  prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString("username,",username);
                        //to save our data with key and value
                        editor.apply();

                        Intent intent=new Intent(LoginActivity.this, HomeActivity.class);

                        startActivities(new Intent[]{intent});

                    }
                  else{
                        Toast.makeText(getApplicationContext(),"invalid username and password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivities(new Intent[]{intent});
            }
        });}
}