package com.example.login_shared_preferences;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText editName,editPwd;
    private Button btn_logIn,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editPwd = findViewById(R.id.edit_pwd);

        btn_register = findViewById(R.id.btn_register);
        btn_logIn = findViewById(R.id.btn_login);

        //logIn
        btn_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editName.getText().toString();
                String pwd = editPwd.getText().toString();

                //1.存取檔案資料庫物件實體
                SharedPreferences mPreferences = getSharedPreferences("cc",MODE_PRIVATE);

                //2.從資料庫取得資料
                String userDetails = mPreferences.getString(user + pwd +"cc", "帳密錯誤" );//取得資料庫資料(1.資料目錄名 2.錯誤訊息);
                mPreferences.edit()//edit物件實體
                        .putString("display",userDetails)
                        .commit();

                Log.v("hank","userDetails:" + userDetails);
                Intent displayIntent = new Intent(MainActivity.this,DisplayScreen.class);
                startActivity(displayIntent);

            }
        });

        //Register
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,Register.class);
                startActivity(registerIntent);
            }
        });



    }
}
