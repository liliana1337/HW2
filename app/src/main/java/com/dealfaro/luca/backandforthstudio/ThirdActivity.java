package com.dealfaro.luca.backandforthstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    //static final public String MYPREFS = "myprefs";
    // static final public String PREF_STRING_1 = "string_1";

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("Activity 3 example");
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (appInfo.sharedString1 != null) {
            EditText edv = (EditText) findViewById(R.id.editText1);
            edv.setText(appInfo.sharedString3);
        }
        TextView txt2 = (TextView)findViewById(R.id.textViewA2);
        if (appInfo.sharedString2 != null) {
            txt2.setText(appInfo.sharedString2);
        }
        TextView txt1 = (TextView)findViewById(R.id.textViewA1);
        if (appInfo.sharedString1 != null) {
            txt1.setText(appInfo.sharedString1);
        }
    }

    public void setValue3 (View V) {
        EditText edv = (EditText) findViewById(R.id.editText1);
        String text3 = edv.getText().toString();
        appInfo.setMyText(text3,3);
    }


    public void goA2(View V) {
        // Grab the text, and store it in the singleton class
        EditText edv = (EditText) findViewById(R.id.editText1);
        String text3 = edv.getText().toString();
        appInfo.setMyText(text3,3);

        // The second string we store it in the singleton class.
        TextView txt2 = (TextView)findViewById(R.id.textViewA2);
        String text2 = txt2.getText().toString();
        appInfo.setMyText(text2,2);

        // The third string we store it in the singleton class.
        TextView txt1 = (TextView)findViewById(R.id.textViewA1);
        String text1 = txt1.getText().toString();
        appInfo.setMyText(text1,1);

        // Go to second activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goA1(View V) {
        // Grab the text, and store it in the singleton class
        EditText edv = (EditText) findViewById(R.id.editText1);
        String text3 = edv.getText().toString();
        appInfo.setMyText(text3,3);

        // The second string we store it in the singleton class.
        TextView txt2 = (TextView)findViewById(R.id.textViewA2);
        String text2 = txt2.getText().toString();
        appInfo.setMyText(text2,2);

        // The third string we store it in the singleton class.
        TextView txt1 = (TextView)findViewById(R.id.textViewA1);
        String text1 = txt1.getText().toString();
        appInfo.setMyText(text1,1);

        // Go to third activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        //this.finish();
    }



}

