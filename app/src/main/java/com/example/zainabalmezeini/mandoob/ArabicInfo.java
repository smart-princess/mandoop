package com.example.zainabalmezeini.mandoob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ArabicInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_info);
    }

    /**
     * this class to interduce radioButton so the user can choose one option any time not more,so this class will do
     * this job, coz if we don't use it the user will choose more than 1 option.
     */

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.yes:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.no:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    /**
     * this method for "next" Button, first we diclear RadioButtons, then we examin them if they checked or not?
     * then if any one checked it will open new activity, "yes" will open customer "Customer" activity, & "no" will open "Exit" activity.
     */

    public void nextActivity (View view){

        RadioButton yesBox = (RadioButton) findViewById(R.id.yes);
        boolean hasAgree = yesBox.isChecked(); // hasAgree we use it in if statment if it checked or not

        RadioButton noBox = (RadioButton) findViewById(R.id.no);
        boolean hasNotAgree = yesBox.isChecked(); // hasNotAgree we use it in if statment if it checked or not

        if(hasAgree){

            Intent yseAgree = new Intent(this, CustomerInfo.class);
            startActivity(yseAgree);
        }

        else {

            Intent notAgree = new Intent(this, Exit.class);
            startActivity(notAgree);
        }
    }
}
