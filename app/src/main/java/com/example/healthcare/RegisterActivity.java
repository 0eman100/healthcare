package com.example.healthcare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
public class RegisterActivity extends AppCompatActivity {
    Button btn;
    EditText edUser,edPassword,edEmail,edConfirmPassword;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUser= findViewById(R.id.editTextRegUsername);
        edPassword= findViewById(R.id.editTextRegPassword);
        edEmail= findViewById(R.id.editTextRegEmail);
        edConfirmPassword= findViewById(R.id.editTextRegConfirmPassword);
        btn  = findViewById(R.id.button2);
        tv=   findViewById(R.id.ExisitingUser);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivities(new Intent[]{intent});

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUser.getText().toString();
                String pass=edPassword.getText().toString();
                String email=edEmail.getText().toString();
                String confirm= edConfirmPassword.getText().toString()
                        ;
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || pass.length()==0 || email.length()==0|| confirm.length()==0 ){
                    Toast.makeText(getApplicationContext(),"pleasee enter all fields",Toast.LENGTH_LONG).show();

                }
                if(pass.compareTo(confirm)==0){
                    if(isValid(pass)){
                        db.register(username,email,pass);
                        Toast.makeText(getApplicationContext(),"record inserted",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivities(new Intent[]{intent});

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"password is must contain 8 character ,letter digit uppercase lowercase",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"password and confirm password did not match",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public static boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length()<8){

            return false;
        }else{
            for(int p=0;p<passwordhere.length();p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0;r<passwordhere.length();r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;

                }
            }
            for (int s=0; s<passwordhere.length();s++){
                char c=passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return  true;
            return false;
        }

    }

}
