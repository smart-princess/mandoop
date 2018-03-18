package com.example.zainabalmezeini.mandoob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * this codes called when we clicked the buttons, it open new activity (page) using Intent
     *
     */

    public void arabicInfo(View view) {

        // Do something in response to button (open Arabic page)

        Intent arabic = new Intent(this, ArabicInfo.class);
        Button arabicInfo = (Button) findViewById(R.id.arabic);
        startActivity(arabic);
    }


    public void englishInfo(View view) {

        // Do something in response to button (open English page )

        Intent english = new Intent(this, EnglishInfo.class);
        Button englishInfo = (Button) findViewById(R.id.english);
        startActivity(english);
    }





}
