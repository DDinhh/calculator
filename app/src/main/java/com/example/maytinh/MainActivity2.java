package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import nguyenvanquan7826.com.Balan;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView mEditText;
    TextView mTextView;
    Button btn_luythua, btn_sqrt, btn_hex, btn_bin, btn_dec, btn_oct, btn_log, btn_giaithua, btn_sin,
            btn_cos, btn_tan, btn_Int, btn_percent, btn_nsqrt, btn_e, btn_clear, btn_bang, btn_cham, btn_dele, btn_kq;
    private int[] idButton = {R.id.so0, R.id.btnDot, R.id.btn_sqrt, R.id.so00, R.id.mot, R.id.hai, R.id.ba, R.id.bon, R.id.nam, R.id.sau, R.id.bay,
            R.id.tam, R.id.chin, R.id.mo_ngoac, R.id.dong_ngoac, R.id.cong, R.id.tru, R.id.nhan, R.id.chia, R.id.clear_all,
            R.id.btn_cos, R.id.btn_sin, R.id.btn_tan, R.id.btnBin, R.id.btn_log, R.id.btn_luythua, R.id.btn_nsqrt, R.id.btn_giaithua, R.id.btn_e,
            R.id.btn_percent};
    public float i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnhXa();
        connectView();

        btn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("e");
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("|");
                mTextView.setText("0");
            }
        });

        btn_Int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInt(1);
            }
        });
        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInt(2);
            }
        });
        btn_hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvBin(1);
            }
        });
        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvBin(4);
            }
        });
        btn_oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvBin(2);
            }
        });
        btn_bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvBin(3);
            }
        });

        btn_bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal();
            }
        });
        btn_dele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText = (TextView) findViewById(R.id.nhap);
                try {

                    String strNew = mEditText.getText().toString().substring(0, mEditText.getText().toString().length() - 1);
                    mEditText.setText(strNew);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



    }

    @SuppressLint("ResourceType")
    private void AnhXa() {
        mEditText = findViewById(R.id.nhap);
        mTextView = findViewById(R.id.ketqua);

        btn_sqrt = findViewById(R.id.btn_sqrt);
        btn_hex = findViewById(R.id.btnHex);
        btn_bin = findViewById(R.id.btnBin);
        btn_dec = findViewById(R.id.btnDec);
        btn_oct = findViewById(R.id.btnOct);
        btn_log = findViewById(R.id.btn_log);
        btn_luythua = findViewById(R.id.btn_luythua);
        btn_giaithua = findViewById(R.id.btn_giaithua);
        btn_sin = findViewById(R.id.btn_sin);
        btn_cos = findViewById(R.id.btn_cos);
        btn_tan = findViewById(R.id.btn_tan);
        btn_Int = findViewById(R.id.btn_Int);
        btn_percent = findViewById(R.id.btn_percent);
        btn_nsqrt = findViewById(R.id.btn_nsqrt);
        btn_e = findViewById(R.id.btn_e);
        btn_clear = findViewById(R.id.clear_all);
        btn_bang = findViewById(R.id.bang);
        btn_cham = findViewById(R.id.btnDot);
        btn_dele = findViewById(R.id.btnDele);
        btn_kq = findViewById(R.id.bang);

    }

    public void getInt(int i) {
        float sobc = 0;
        String math = mEditText.getText().toString().trim();
        try {
            if (math.length() > 0) {
                Balan balan = new Balan();
                String result = balan.valueMath(math) + "";
                String[] nguyen = result.split("\\.");//tach chuoi va tra ve mang chuoi
                String[] laysobichia = math.split("\\/");
                int temp = result.indexOf(".");//tra ve chi so cua cac gia tri hoac chuoi con
                int temp2 = math.indexOf("/");
                if (i == 1) {
                    if (temp > 0) {
                        mTextView.setText("Nguyen:" + nguyen[0] + "");
                    } else if (temp == -1) {
                        mTextView.setText("Nguyen:" + result + "");
                    }
                } else if (i == 2 && temp2 > 0) {
                    if (temp == -1) {
                        mTextView.setText("so du: 0");
                    } else {
                        for (int j = 0; j < laysobichia.length; j++) {
                            sobc = Float.parseFloat(laysobichia[j]);
                        }
                        float laydu = (Float.parseFloat("0." + nguyen[1]) * sobc);
                        mTextView.setText("Du: " + laydu + "");
                    }
                } else if (temp2 == -1) {
                    mTextView.setText("nhap phep tinh chia");

                }
            }

        } catch (Exception e) {
            mTextView.setText("error math");
        }
    }

    private void cvBin(float i) {
        try {
            String ketqua = mEditText.getText().toString().trim();
//            if (ketqua.length() > 0) {
//                Balan b1 = new Balan();
//                String result = b1.valueMath(ketqua) + "";
            int chuyen = Integer.parseInt(ketqua);
            if (i == 1) {
                mTextView.setText(Integer.toHexString(chuyen));
            }
            if (i == 2) {
                mTextView.setText(Integer.toOctalString(chuyen));
            }
            if (i == 3) {
                mTextView.setText(Integer.toBinaryString(chuyen));
            }
            if (i == 4) {
                mTextView.setText(Integer.toString(chuyen));
            }

        } catch (Exception e) {
            mTextView.setText("Nhap so nguyen");
        }
    }

    private void connectView() {
        mEditText = (TextView) findViewById(R.id.nhap);
        mTextView = (TextView) findViewById(R.id.ketqua);

        for (int i = 0; i < idButton.length; i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
        init();
    }

    private void init() {
        mEditText.setText("|");
        mTextView.setText("0");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        // check button number and button operator
        for (int i = 0; i < idButton.length - 2; i++) {
            if (id == idButton[i]) {
                String text = ((Button) findViewById(id)).getText().toString();

                // clear char | on top
                if (mEditText.getText().toString().trim().equals("|")) {
                    mEditText.setText("");
                }
                mEditText.append(text);//nối chuỗi
                return;
            }
        }
        if (id == R.id.clear_all) {
            init();
            return;
        }
        if (id == R.id.bang) {
            cal();
        }
    }

    private void cal() {
        String math = mEditText.getText().toString().trim();
        if(math.substring(0,1).equals("√"))
            math=String.valueOf(Math.sqrt(Double.parseDouble(math.substring(1))));
        if(math.substring(0,1).equals("∛"))
            math=String.valueOf(Math.cbrt(Double.parseDouble(math.substring(1))));

        if (math.length() > 0) {
            Balan balan = new Balan();
            String result = balan.valueMath(math) + "";
            String error = balan.getError();
            // check error
            if (error != null) {
                mTextView.setText(error);
            } else { // show result
                mTextView.setText(result);
            }

        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Actitity-2");//gọi lại activity
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isFinishing()) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "xoay2", Toast.LENGTH_SHORT).show();
            //thoat khoi activity va sang activity còn lại
        }

    }


}