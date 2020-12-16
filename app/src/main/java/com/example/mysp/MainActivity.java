package com.example.mysp;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_cun;
    private Button btn_qu;
    private EditText et_password;
    private Button btn_login;
    private CheckBox cb_login;
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("main", "onCreate: ");

        btn_qu = findViewById(R.id.btn_qu);
        btn_cun = findViewById(R.id.btn_cun);
        btn_login = findViewById(R.id.btn_login);
        et_password = findViewById(R.id.et_password);
        cb_login = findViewById(R.id.cb_login);
        pref = (SharedPreferences) PreferenceManager.getDefaultSharedPreferences(this);

        btn_cun.setOnClickListener(this);
        btn_qu.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        boolean isremember = pref.getBoolean("remember",false);
        if(isremember){
            et_password.setText(pref.getString("password",""));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_qu:
                SharedPreferences s = (SharedPreferences) getSharedPreferences("data",MODE_PRIVATE);
                String name = s.getString("name","");
                int age = s.getInt("age", 0);
                Log.d("apple", name + "   "+age );
                break;
            case R.id.btn_cun:
                SharedPreferences.Editor sp = getSharedPreferences("data",MODE_PRIVATE).edit();
                sp.putString("name","woshiyi")
                        .putInt("age",1)
                        .apply();
                break;
            case R.id.btn_login:
                editor = pref.edit();
                //String a = String.valueOf(et_password.getText());
                editor.putString("password", String.valueOf(et_password.getText()));
                if(cb_login.isChecked()){
                    editor.putBoolean("remember",true);
                }else{
                    editor.clear();
                }
                editor.apply();
                Intent i = new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("main", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("main", "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("main", "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("main", "onPause: ");
    }
}