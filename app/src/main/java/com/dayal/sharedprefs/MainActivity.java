package com.dayal.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button btn;
    private static final String PREFS_NAME="MyPrefs";
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences=getSharedPreferences(PREFS_NAME,0);               //mode = 0  - accessible
                SharedPreferences.Editor editor=sharedPreferences.edit();          // editor interface
                editor.putString("msg",editText.getText().toString());             //msg(key), editText(value)
                editor.commit();
            }
        });
        //get data back
        SharedPreferences getPrefs=getSharedPreferences(PREFS_NAME,0);
        if(getPrefs.contains("msg")){
            String message=getPrefs.getString("msg","not found !");                 // (message, DEFAULT_VALUE)
            textView.setText("Saved Message : "+message);
        }

    }
}
