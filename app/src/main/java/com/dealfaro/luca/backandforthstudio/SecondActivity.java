package com.dealfaro.luca.backandforthstudio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

   // static final public String MYPREFS = "myprefs";
    // static final public String PREF_STRING_1 = "string_1";

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Activity 2 example");
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (appInfo.sharedString1 != null) {
            EditText edv = (EditText) findViewById(R.id.editTextA2);
            edv.setText(appInfo.sharedString2);
        }
        TextView txt1 = (TextView)findViewById(R.id.textViewA1);
        if (appInfo.sharedString1 != null) {
            txt1.setText(appInfo.sharedString1);
        }
        TextView txt3 = (TextView)findViewById(R.id.textViewA3);
        if (appInfo.sharedString3 != null) {
            txt3.setText(appInfo.sharedString3);
        }
    }

    public void setValue2 (View V) {
        EditText edv = (EditText) findViewById(R.id.editTextA2);
        String text2 = edv.getText().toString();
        appInfo.setMyText(text2,2);
    }


    public void goA1(View V) {
        // Grab the text, and store it in the singleton class
        EditText edv = (EditText) findViewById(R.id.editTextA2);
        String text2 = edv.getText().toString();
        appInfo.setMyText(text2,2);

        // The second string we store it in the singleton class.
        TextView txt1 = (TextView)findViewById(R.id.textViewA1);
        String text1 = txt1.getText().toString();
        appInfo.setMyText(text1,1);

        // The third string we store it in the singleton class.
        TextView txt3 = (TextView)findViewById(R.id.textViewA3);
        String text3 = txt3.getText().toString();
        appInfo.setMyText(text3,3);

        // Go to first activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goA3(View V) {
        // Grab the text, and store it in the singleton class
        EditText edv = (EditText) findViewById(R.id.editTextA2);
        String text2 = edv.getText().toString();
        appInfo.setMyText(text2,2);

        // The first string we store it in the singleton class.
        TextView txt1 = (TextView)findViewById(R.id.textViewA1);
        String text1 = txt1.getText().toString();
        appInfo.setMyText(text1,1);

        // The third string we store it in the singleton class.
        TextView txt3 = (TextView)findViewById(R.id.textViewA3);
        String text3 = txt3.getText().toString();
        appInfo.setMyText(text3,3);

        // Go to second activity
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       startActivity(intent);
       // this.finish();
    }


}
