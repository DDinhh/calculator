package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import nguyenvanquan7826.com.Balan;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvMath;
    private TextView tvResult;
    //Button equal,Xoa;
    private int[] idButton = {
            R.id.btn0,
            R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnDot, R.id.btnOpen, R.id.btnClose,
            R.id.btnPlus, R.id.btnSub, R.id.btnMul, R.id.btnDiv,
            R.id.btnC,
            R.id.btnResult,
    };
    Button btchuyen,btndelete,btn_nguyendu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();

        btn_nguyendu = findViewById(R.id.btn_nguyen);
        btndelete = findViewById(R.id.btndelete);
        btn_nguyendu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInt(1);
                //getInt(2);

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMath = (TextView) findViewById(R.id.tvMath);
                try {

                    String strNew = tvMath.getText().toString().substring(0, tvMath.getText().toString().length()-1);
                    tvMath.setText(strNew);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

    private void connectView() {
        tvMath = (TextView) findViewById(R.id.tvMath);
        tvResult = (TextView) findViewById(R.id.tvResult);

        for (int i = 0; i < idButton.length; i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
        init();
    }


    private void init() {
        tvMath.setText("|");
        tvResult.setText("0");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // check button number and button operator
        for (int i = 0; i < idButton.length - 2; i++) {
            if (id == idButton[i]) {
                String text = ((Button) findViewById(id)).getText().toString();

                // clear char | on top
                if (tvMath.getText().toString().trim().equals("|")) {
                    tvMath.setText("");
                }

                tvMath.append(text);
                return;
            }
        }

        // clear screen
        if (id == R.id.btnC) {
            init();
            return;
        }
        if (id == R.id.btnResult) {
            cal();
        }
    }
    public void getInt(int i) {
        float sobc = 0;
        String math = tvMath.getText().toString().trim();
        try {
            String chuoi = "";
            String chuoi1 = "";
            if (math.length() > 0) {
                Balan balan = new Balan();
                String result = balan.valueMath(math) + "";
                String[] nguyen = result.split("\\.");
                String[] laysobichia = math.split("\\/");
                int temp = result.indexOf(".");
                int temp2 = math.indexOf("/");

                if (i == 1) {
                    if (temp > 0) {
                        chuoi = "Nguyen:" + nguyen[0] + "";
                    } else if (temp == -1) {
                        chuoi = "Nguyen:" + result + "";
                    }
                    if (temp2 > 0) {
                        if (temp == -1) {
                            chuoi1 = "so du: 0";
                        } else {
                            for (int j = 0; j < laysobichia.length; j++) {
                                sobc = Float.parseFloat(laysobichia[j]);
                            }
                            float laydu = (Float.parseFloat("0." + nguyen[1]) * sobc);
                            chuoi1 = "Du: " + laydu + "";
                        }
                        tvResult.setText(chuoi + "---" + chuoi1);
                    } else if (temp2 == -1) {
                        tvResult.setText("nhap phep tinh chia");

                    }
                }

            }


        } catch (Exception e) {
            tvResult.setText("error math");
        }
    }

    private void cal() {
        String math = tvMath.getText().toString().trim();
        if (math.length() > 0) {
            Balan balan = new Balan();
            String result = balan.valueMath(math) + "";
            String error = balan.getError();
            // check error
            if (error != null) {
                tvResult.setText(error);
            } else { // show result
                tvResult.setText(result);
            }
        }
    }

    private long i=0;

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Actitity-1");
    }

    @Override
    protected void onDestroy() {

            super.onDestroy();

            if(!isFinishing()) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Toast.makeText(this, "xoay1", Toast.LENGTH_SHORT).show();
            }

    }


}


