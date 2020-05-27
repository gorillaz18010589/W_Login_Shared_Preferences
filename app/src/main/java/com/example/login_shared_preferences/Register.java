package com.example.login_shared_preferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    private EditText editName, editPwd, editEmail;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        editName = findViewById(R.id.edt_name);
        editPwd = findViewById(R.id.edt_pwd);
        editEmail = findViewById(R.id.edt_email);

        btn_register = findViewById(R.id.btn_register);

        //    getSharedPreferences(String name, int mode)//創造取得存放位置(1,檔案名,2.讀寫模式) (回傳SharedPreferences)
//        SharedPreferences.Editor
//        commit()：直接將修改的結果寫入檔案
//        apply()：修改記憶體中的暫存資料，並以非同步式寫入檔案
//        put基本資料型態(key, value)：boolean, float, int, long, String, Set<String>
//                remove(key)
//        clear()
//
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //2.創造檔案資料夾
                SharedPreferences mPreferences = getSharedPreferences("cc", MODE_PRIVATE);

                //1.按下去時抓取使用者輸入的質
                String newUser = editName.getText().toString();
                String newPwd = editPwd.getText().toString();
                String newEmail = editEmail.getText().toString();


                //3.editor物件實體化,put: key/value將資料儲存
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString(newUser + newPwd +"cc",newUser + "\n" + newEmail);
                editor.commit();
                Log.v("hank" , "msg:" +newUser + newPwd +"data");
                Intent loginIntent = new Intent(Register.this,MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}