package com.example.login_shared_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        SharedPreferences mPreferences = getSharedPreferences("cc",MODE_PRIVATE);
        String display = mPreferences.getString("display","");

        TextView txtMsg = findViewById(R.id.txt_user_msg);
        txtMsg.setText(display);
    }
}