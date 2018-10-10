package com.example.user.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView sign1, sign2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        init();
    }

    private void init() {
        setTitle(R.string.calc);
        num1 = findViewById(R.id.num1);
        num1.setShowSoftInputOnFocus(false);
        num2 = findViewById(R.id.num2);
        num2.setShowSoftInputOnFocus(false);
        sign1 = findViewById(R.id.sign1);
        sign2 = findViewById(R.id.sign2);
        result = findViewById(R.id.result);
    }

    public void setNum(View v) {
        if(!result.getText().equals("")){
            return;
        }
        Button btn = (Button)v;
        String num = btn.getText().toString();
            if(sign1.getText().toString().equals("")) {
                String input = num1.getText().toString() + num;
                input = Integer.toString(Integer.parseInt(input));
                num1.setText(input);
            } else {
                String input = num2.getText().toString() + num;
                input = Integer.toString(Integer.parseInt(input));
                num2.setText(input);
        }
    }

    public void setSign(View v) {
        Button btn = (Button)v;
        if(btn.getText().toString().equals("C")) {
            num1.setText("");
            num2.setText("");
            sign1.setText("");
            result.setText("");
        } else if(result.getText().equals("")) {
            sign1.setText(btn.getText().toString());
        }
    }

    public void enter(View v) {
        Button btn = (Button)v;
        if(num1.getText().toString().equals("")||num2.getText().toString().equals("")||sign1.getText().toString().equals("")) {
            result.setText("incomplete");
        } else {
            String n1 = num1.getText().toString();
            String n2 = num2.getText().toString();
            String s1 = sign1.getText().toString();
            try {
                int no1 = Integer.parseInt(n1);
                int no2 = Integer.parseInt(n2);
                double no3 = 0.0;
                switch (s1) {
                    case "+" :
                        result.setText(Integer.toString(no1 + no2));
                        break;
                    case "-" :
                        result.setText(Integer.toString(no1 - no2));
                        break;
                    case "*" :
                        result.setText(Integer.toString(no1 * no2));
                        break;
                    case "/" :
                        if(no2==0) {
                            result.setText("div 0");
                        } else {
                            no3 = (double)no1/no2;
                            result.setText(Double.toString(no3));
                        }
                        break;
                }
            } catch(Exception e) {
                result.setText("error");
            }
        }
    }
}

