package com.dealfaro.luca.backandforthstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final public String MYPREFS = "myprefs";
   // static final public String PREF_STRING_1 = "string_1";

    AppInfo appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Activity 1 example");
        appInfo = AppInfo.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (appInfo.sharedString1 != null) {
            EditText edv = (EditText) findViewById(R.id.editText1);
            edv.setText(appInfo.sharedString1);
        }
        TextView txt2 = (TextView)findViewById(R.id.textViewA2);
        if (appInfo.sharedString2 != null) {
            txt2.setText(appInfo.sharedString2);
        }
        TextView txt3 = (TextView)findViewById(R.id.textViewA3);
        if (appInfo.sharedString3 != null) {
            txt3.setText(appInfo.sharedString3);
        }
    }

    public void setValue1 (View V) {
        EditText edv = (EditText) findViewById(R.id.editText1);
        String text1 = edv.getText().toString();
        appInfo.setMyText(text1,1);
    }


    public void goA2(View V) {
        // Grab the Edit1 text, and store it in the singleton class
        EditText edv = (EditText) findViewById(R.id.editText1);
        String text1 = edv.getText().toString();
        appInfo.setMyText(text1,1);

        // Grab the TextView String2 and store it in the singleton class.
        TextView txt2 = (TextView)findViewById(R.id.textViewA2);
        String text2 = txt2.getText().toString();
        appInfo.setMyText(text2,2);

        // Grab the String 3 TextView string we store it in the singleton class.
        TextView txt3 = (TextView)findViewById(R.id.textViewA3);
        String text3 = txt3.getText().toString();
        appInfo.setMyText(text3,3);

        // Go to second activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goA3(View V) {
        // Grab the Edit1 text, and store it in the singleton class
        EditText edv = (EditText) findViewById(R.id.editText1);
        String text1 = edv.getText().toString();
        appInfo.setMyText(text1,1);

        // Grab the String 2 TextView string we store it in the singleton class.
        TextView txt2 = (TextView)findViewById(R.id.textViewA2);
        String text2 = txt2.getText().toString();
        appInfo.setMyText(text2,2);

        // Grab the String 3 TextView string we store it in the singleton class.
        TextView txt3 = (TextView)findViewById(R.id.textViewA3);
        String text3 = txt3.getText().toString();
        appInfo.setMyText(text3,3);

        // Go to third activity
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
   public void onBackPressed() {
      //Intent intent = new Intent(this, MainActivity.class);
      //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      //startActivity(intent);
    }



}
