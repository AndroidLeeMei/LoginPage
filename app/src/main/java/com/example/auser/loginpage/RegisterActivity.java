package com.example.auser.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etEmail,etUserName,etPassword,etAge;
    private Button btnRegister;

    //加入偏好設定
    public static final String PREF="Login";
    public static final String PREF_USERNAME="Login_UserName";
    public static final String PREF_PASSWORD="Login_Password";
    String pref_userName,pref_passwrod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUserName=(EditText)findViewById(R.id.etUserName);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etAge=(EditText)findViewById(R.id.etAge);

        btnRegister=(Button)findViewById(R.id.btnRegister);

    }

    public void openUserHomePage(View target){
        String str=etEmail.getText().toString();

        if (!str.contains("@"))
            Toast.makeText(RegisterActivity.this,"EMAIL欄位不合法", Toast.LENGTH_SHORT).show();
        else if (etEmail.getText().toString().equals("")
                ||etUserName.getText().toString().equals("")
                ||etPassword.getText().toString().equals("")
                ||etAge.getText().toString().equals("")
                )
            Toast.makeText(RegisterActivity.this,"以上欄位都不能空白", Toast.LENGTH_SHORT).show();
        else {
//        Log("Lo","1");
            restorePrefs();
            Intent intent = new Intent();
            intent.setClass(RegisterActivity.this, UserHomePage.class);
            //            開始Intent傳遞參數程式
            Bundle bundle = new Bundle();
            bundle.putString("KEY_FROM", "register");
            bundle.putString("KEY_USER", etUserName.getText().toString());
            intent.putExtras(bundle);

            startActivity(intent);
        }

    }

    //Restore preferences
    private void restorePrefs(){
        SharedPreferences settings=getSharedPreferences(PREF,0);

        settings.edit().putString(PREF_USERNAME,
                etUserName.getText().toString()).commit();

        settings.edit().putString(PREF_PASSWORD,
                etPassword.getText().toString()).commit();


    }



}
