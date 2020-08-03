package com.taol.function;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.DataOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btRoot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Runtime mRuntime = Runtime.getRuntime();
                Process process = null;
                DataOutputStream os = null;
                try {
                    process = Runtime.getRuntime().exec("su"); //切换到root帐号
                    os = new DataOutputStream(process.getOutputStream());
                    os.writeBytes("exit\n");
                    os.flush();
                    process.waitFor();

                } catch (Exception e) {

                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btAlipayWallet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AlipayWallet.class);
                startActivity(intent);
//                overridePendingTransition(0, 0);
            }
        });

        findViewById(R.id.btAlipayQR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AlipayQr.class);
                startActivity(intent);
//                overridePendingTransition(0, 0);
            }
        });

        findViewById(R.id.btWechatQR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WechatQr.class);
                startActivity(intent);
//                overridePendingTransition(0, 0);
            }
        });
        findViewById(R.id.btWechatWallet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WechatWallet.class);
                startActivity(intent);
//                overridePendingTransition(0, 0);
            }
        });
    }
}