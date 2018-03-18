package com.example.zainabalmezeini.mandoob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
    }

    /**
     * this method fot "Back Button" when we press it we will return back to the agreement page
     */

    public void backButton(View view){

        Intent back = new Intent(this, ArabicInfo.class);
        Button backButton = (Button) findViewById(R.id.back_Button);
        startActivity(back);

    }

    /**
     * this method fot "Exit Button" when we press it we will close the Application
     */

    public void exitButton(View view){

        Button exit = (Button) findViewById(R.id.exit_Button);

        Intent exitB = new Intent(Intent.ACTION_MAIN);
        exitB.addCategory( Intent.CATEGORY_HOME );
        exitB.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitB);

    }
}
