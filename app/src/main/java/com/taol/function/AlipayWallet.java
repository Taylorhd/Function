package com.taol.function;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.DataOutputStream;

public class AlipayWallet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_alipay_wallet);
        Runtime mRuntime = Runtime.getRuntime();
        Process process = null;
        DataOutputStream os = null;
        try {
            String cmd="am start -n com.eg.android.AlipayGphone/com.alipay.mobile.onsitepay9.payer.OspTabHostActivity";
            process = Runtime.getRuntime().exec("su"); //切换到root帐号
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(cmd + "\n");
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finish();
    }
}