package com.example.zainabalmezeini.mandoob;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CustomerInfo extends AppCompatActivity {

    String buy = "طلب شراء";
    String arrive = "طلب توصيل";
    String notGift = " نعم";
    String gift = "لا هدية";
    String noPrice = "لا";
    String yesPrice = "نعم";
    String withSen = "عند الإستلام";
    String withRes = "عند التسليم";
    String bank = "ايداع بنكي";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
    }

    public void submit(View view) {

        /**
         * decloration of radio button and radio group by Id
         */

        RadioGroup service = (RadioGroup) findViewById(R.id.serviceType);
        RadioButton buyS = (RadioButton) findViewById(R.id.buy);
        RadioButton arriveS = (RadioButton) findViewById(R.id.arrive);

        /**
         * decloration of Text View so we can use it in Summary
         */

        TextView ser = (TextView) findViewById(R.id.ser);
        String ser1 = ser.getText().toString();

        // to choice any radio button so the device can know it
        int radioGropSer = service.getCheckedRadioButtonId();

        /**
         * if the user choice any option the option that they choice it will call the value from the main class so, the value will
         * saved on (ser1) witch is text view so we can use it in summary
         */

        if (radioGropSer == buyS.getId()) {


            ser1 = buy;


        } else {

            ser1 = arrive;

        }

// to add sender name
        EditText nameFailf = (EditText) findViewById(R.id.senderName);
        String name = nameFailf.getText().toString();

        //to add sender phone number
        EditText numberSField = (EditText) findViewById(R.id.senderNumber);
        String numberSener = numberSField.getText().toString();

        // the type of things that they want to send
        EditText thingsFaild = (EditText) findViewById(R.id.things);
        String things = thingsFaild.getText().toString();

        // Sender Address
        EditText senderAdressField = (EditText) findViewById(R.id.senderAddress);
        String senderAress = senderAdressField.getText().toString();

        // the Time the sender want to take the things
        EditText timeFeild = (EditText) findViewById(R.id.time);
        String time = timeFeild.getText().toString();

        // resiver phone number
        EditText resNumber = (EditText) findViewById(R.id.resiverNumber);
        String reNumber = resNumber.getText().toString();

        // resiver address
        EditText resAddress = (EditText) findViewById(R.id.resiverAddress);
        String reAddress = resAddress.getText().toString();

        //if there are money to be collect or not
        EditText price = (EditText) findViewById(R.id.priceE);
        String priceEdit = price.getText().toString();

        // if the sender have any notes
        EditText noteText = (EditText) findViewById(R.id.note);
        String noteT = noteText.getText().toString();

        /**
         * decloration of radio button and radio group by Id
         */

        RadioGroup giftR = (RadioGroup) findViewById(R.id.gift);
        RadioButton noNot = (RadioButton) findViewById(R.id.know);
        RadioButton yesGift = (RadioButton) findViewById(R.id.notKnow);

        /**
         * decloration of Text View so we can use it in Summary
         */

        TextView gif = (TextView) findViewById(R.id.giftor);
        String gif1 = gif.getText().toString();

        // to choice any radio button so the device can know it
        int radioGropGif = giftR.getCheckedRadioButtonId();

        /**
         * if the user choice any option the option that they choice it will call the value from the main class so, the value will
         * saved on (gif1) witch is text view so we can use it in summary
         */

        if (radioGropGif == noNot.getId()) {


            gif1 = notGift;


        } else {

            gif1 = gift;

        }

        /**
         * decloration of radio button and radio group by Id
         */

        RadioGroup pric = (RadioGroup) findViewById(R.id.money);
        RadioButton noPrice1 = (RadioButton) findViewById(R.id.noPrice);
        RadioButton yesPrice1 = (RadioButton) findViewById(R.id.yesPrice);

        /**
         * decloration of Text View so we can use it in Summary
         */

        TextView pri = (TextView) findViewById(R.id.priceText);
        String priceT = pri.getText().toString();

        // to choice any radio button so the device can know it
        int radioGropPrice = pric.getCheckedRadioButtonId();

        /**
         * if the user choice any option the option that they choice it will call the value from the main class so, the value will
         * saved on (priceT) witch is text view so we can use it in summary
         */

        if (radioGropPrice == noPrice1.getId()) {


            priceT = noPrice;


        } else {

            priceT = yesPrice;

        }

        /**
         * decloration of radio button and radio group by Id
         */

        RadioGroup pay = (RadioGroup) findViewById(R.id.wayPay);
        RadioButton whenSend = (RadioButton) findViewById(R.id.withS);
        RadioButton whenResive = (RadioButton) findViewById(R.id.withR);
        RadioButton byBank = (RadioButton) findViewById(R.id.sendBank);

        /**
         * decloration of Text View so we can use it in Summary
         */

        TextView money = (TextView) findViewById(R.id.monyPay);
        String payMoney = money.getText().toString();

        // to choice any radio button so the device can know it
        int radioGropPay = pay.getCheckedRadioButtonId();

        /**
         * if the user choice any option the option that they choice it will call the value from the main class so, the value will
         * saved on (payMoney) witch is text view so we can use it in summary
         */

        if (radioGropPay == whenSend.getId()) {


            payMoney = withSen;


        } else if (radioGropPay == whenResive.getId()) {

            payMoney = withRes;

        } else {

            payMoney = bank;
        }


        String summaryOrder = creatSummary(ser1, name, numberSener, things, senderAress, time, reNumber, reAddress, priceEdit, noteT, gif1, priceT, payMoney);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: zainab.892011@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "طلب توصيل ل " + name);
        intent.putExtra(Intent.EXTRA_TEXT, summaryOrder);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(summaryOrder);


    }

    private void displayMessage(String message) {

        TextView orderSummary = (TextView) findViewById(R.id.summaryText);
        orderSummary.setText(message);
    }


    private String creatSummary(String ser1, String name, String numberSener, String things, String senderAress, String time, String reNumber, String reAddress, String priceEdit, String noteT, String gif1, String priceT, String payMoney) {

        String summaryOrder = "\nنوع الخدمة:  " + ser1;
        summaryOrder += "\n";
        summaryOrder += "اسم مقدم الطلب:  \n" + name;
        summaryOrder += "\n رقم مقدم الطلب:  " + numberSener;
        summaryOrder += "\n نوع الغرض: " + things;
        summaryOrder += "\n عنوان مقدم الطلب: " + senderAress;
        summaryOrder += "\n الوقت الذي يرغب فيه بإنتشال الطلب: " + time;
        summaryOrder += "\n رقم المرسل إليه:" + reNumber;
        summaryOrder += "\n عنوان المرسل إليه: " + reAddress;
        summaryOrder += "\n  هل المرسل إليه على علم بالموضوع؟ " + gif1;
        summaryOrder += "\n هل سوف يتم استلام مبالغ مالية؟ " + priceT;
        summaryOrder += "\n اذكر القيمه ان وجدت: " + priceEdit;
        summaryOrder += "\n طريقة الدفع:" + payMoney;
        summaryOrder += "\n اي ملاحظات اخرى: " + noteT;

        return summaryOrder;

    }


}
