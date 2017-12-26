package com.example.auser.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etUserName,etPassword;
    Button btnSignIn;
    TextView tvRegister;

    //加入偏好設定
    public static final String PREF="Login";
    public static final String PREF_USERNAME="Login_UserName";
    public static final String PREF_PASSWORD="Login_Password";
    String pref_userName,pref_passwrod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=(EditText)findViewById(R.id.etUserName);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        tvRegister=(TextView)findViewById(R.id.tvRegister);


    }

    @Override
    protected void onPause() {
        super.onPause();

        //Save user preferences. use Editor object to make changes.
        SharedPreferences settings=getSharedPreferences(PREF,0);


        settings.edit().putString(PREF_USERNAME,
                etUserName.getText().toString()).commit();

        settings.edit().putString(PREF_PASSWORD,
                etPassword.getText().toString()).commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.d(TAG,"Bmi.onResume");
        restorePrefs();
    }

    //Restore preferences
    private void restorePrefs(){
        SharedPreferences settings=getSharedPreferences(PREF,0);
        pref_userName=settings.getString(PREF_USERNAME,"");
        pref_passwrod=settings.getString(PREF_PASSWORD,"");


        if (!"".equals(pref_userName)){
            etUserName.setText(pref_userName);
//            fieldWeight.requestFocus();
        }

        if (!"".equals(pref_passwrod)){
            etPassword.setText(pref_passwrod);
//            fieldWeight.requestFocus();
        }
    }


    //open new windows
    public void openRegisterActivity(View target){
//        System.out.println("etUserName.getText()=" + etUserName.getText());
//        Log.d("Login",etUserName.getText().toString());
        Intent intent=new Intent();
        intent.setClass(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    //open new windows
    public void signIn(View target){
        if ("".equals(etUserName.getText().toString())
                ||"".equals(etPassword.getText().toString()))
            Toast.makeText(LoginActivity.this,"欄位不可空白", Toast.LENGTH_SHORT).show();
        else if (!etUserName.getText().toString().equals(pref_userName)||
                !etPassword.getText().toString().equals(pref_passwrod))
            Toast.makeText(LoginActivity.this,"帳號驗證失敗", Toast.LENGTH_SHORT).show();
        else {


            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, UserHomePage.class);
            //            開始Intent傳遞參數程式
            Bundle bundle = new Bundle();
            bundle.putString("KEY_FROM", "Login");
            bundle.putString("KEY_USER", etUserName.getText().toString());
            intent.putExtras(bundle);

            startActivity(intent);
        }

    }
}
