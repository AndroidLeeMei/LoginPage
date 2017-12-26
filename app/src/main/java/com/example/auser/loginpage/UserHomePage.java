package com.example.auser.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserHomePage extends AppCompatActivity {
    TextView textView;
    String userName,fromPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        textView=(TextView)findViewById(R.id.tvWelcome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //取得資料,若物件之間沒有繼承關係時,可以用toString()做轉型
        userName = bundle.getString("KEY_USER");
        fromPage= bundle.getString("KEY_FROM");
        if (fromPage=="register")
            Toast.makeText(UserHomePage.this,"註冊成功",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(UserHomePage.this,"帳號驗證成功",Toast.LENGTH_SHORT).show();

        textView.setText("Welcome," + userName);


    }

}
