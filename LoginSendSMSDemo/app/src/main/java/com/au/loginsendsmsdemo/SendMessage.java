package com.au.loginsendsmsdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class SendMessage extends AppCompatActivity {
    EditText number,message;
    SmsManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        number=findViewById(R.id.number);
        message=findViewById(R.id.messages);
        sm=SmsManager.getDefault();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void SendSms(View view) {
        if (checkSelfPermission(Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS},0);
        }
        sm.sendTextMessage(number.getText().toString(),null,message.getText().toString(),null,null);

    }

    public void logout(View view) {
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
    }


    public void call(View view) {
        Intent b =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number.getText().toString()));
        startActivity(b);
    }
}