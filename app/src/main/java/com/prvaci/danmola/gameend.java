package com.prvaci.danmola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class gameend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameend);
        Intent intent = getIntent();
        int tacni = intent.getIntExtra("tacni",0);
        String tacnistr = tacni + "/10";
        TextView txtTacni = findViewById(R.id.txtTacni);
        txtTacni.setText(tacnistr);
    }

    public void mainClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //Nothing
    }
}
