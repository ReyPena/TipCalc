package com.example.rey.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billTotalEditView;

    Button fivePercentButton;
    Button tenPercentButton;
    Button fifteenPercentButton;
    Button twentyPercentButton;

    TextView tipTotalTextView;
    TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        This is the imput box for the total bill
        billTotalEditView = (EditText) findViewById(R.id.billTotalEditText);

//        this are the group of buttons
        fivePercentButton = (Button) findViewById(R.id.fivePercentButton);
        tenPercentButton = (Button) findViewById(R.id.tenPercentButton);
        fifteenPercentButton = (Button) findViewById(R.id.fifteenPercentButton);
        twentyPercentButton = (Button) findViewById(R.id.twentyPercentButton);

//        This is the total text at the bottom
        tipTotalTextView = (TextView) findViewById(R.id.tipTotalTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);

        fivePercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clacTheTip(0.05);
            }
        });

        tenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clacTheTip(0.1);
            }
        });

        fifteenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clacTheTip(0.15);
            }
        });

        twentyPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clacTheTip(0.2);
            }
        });

    }

    void clacTheTip(Double tipPercentage) {
        if (billTotalEditView.length() > 0) {
//        This turn the string into a float number
            Double billTotal = Double.valueOf(billTotalEditView.getText().toString());

//        This is the tip calculation
            Double tipTotal = billTotal * tipPercentage;

            tipTotalTextView.setText("$" + String.format("%.2f", tipTotal));

//        This is the total calcualtion
            Double total = billTotal + tipTotal;

            totalTextView.setText("$" + String.format("%.2f", total));
        }
    }
}
