package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;
    private TextView resultUs;
    private TextView resultJp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edNtd = findViewById(R.id.ed_ntd);
        resultUs = findViewById(R.id.result_us);
        resultJp = findViewById(R.id.result_jp);
    }

    public void currency(View view){
        String tmpntd = edNtd.getText().toString();
        if (tmpntd.isEmpty())
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.enter_your_bmi)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        else {
            float ntd = Float.parseFloat(tmpntd);
            Log.d("MainActivity", "NTD input : " + ntd);
            float us = ntd / 30.9f;
            float jp = ntd / 0.27f;
            Log.d("MainActivity", "US = " + us);
            Log.d("Mainactivity", "JP = " + jp);
            resultUs.setText("" + us);
            resultJp.setText("" + jp);
            new AlertDialog.Builder(this)
                    .setTitle(R.string.currency)
                    .setMessage(getString(R.string.us_is) + us)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }
    }
}
