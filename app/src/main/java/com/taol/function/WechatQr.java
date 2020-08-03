package com.taol.function;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.DataOutputStream;

public class WechatQr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Runtime mRuntime = Runtime.getRuntime();
        Process process = null;
        DataOutputStream os = null;
        try {
            String cmd="am start -n com.tencent.mm/com.tencent.mm.plugin.scanner.ui.BaseScanUI";
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