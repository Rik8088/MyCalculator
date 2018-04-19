package rik.example.com.mycalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener {

    private enum OPERATOR {

        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL

    }

    TextView txtcalc;
    TextView txtResult;


    //Instance Variables

    private String currentno;
    private String Leftno;
    private String Rightno;
    private OPERATOR currentoperator;
    private double calc;
    private String calcstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentno = "";
        calc = 0;

        calcstring = "";

        txtcalc = findViewById(R.id.txtcalc);
        txtResult = findViewById(R.id.txtresult);


        findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btnAdd).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMul).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDivide).setOnClickListener(Calculator.this);
        findViewById(R.id.btnsub).setOnClickListener(Calculator.this);
        findViewById(R.id.btnclr).setOnClickListener(Calculator.this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEqual:
                operatortap(OPERATOR.EQUAL);

                break;

            case R.id.btnDivide:
                operatortap(OPERATOR.DIVIDE);
                calcstring += " / ";
                break;

            case R.id.btnMul:
                operatortap(OPERATOR.MULTIPLY);
                calcstring += " * ";
                break;

            case R.id.btnAdd:
                operatortap(OPERATOR.PLUS);
                calcstring += " + ";
                break;

            case R.id.btnsub:
                operatortap(OPERATOR.SUBTRACT);
                calcstring += " - ";
                break;
            case R.id.btnclr:
                clearTapped();
                break;


            case R.id.btn9:
                numbertapped(9);
                break;

            case R.id.btn8:
                numbertapped(8);
                break;

            case R.id.btn7:
                numbertapped(7);
                break;

            case R.id.btn6:
                numbertapped(6);
                break;

            case R.id.btn5:
                numbertapped(5);
                break;

            case R.id.btn4:
                numbertapped(4);
                break;

            case R.id.btn3:
                numbertapped(3);
                break;

            case R.id.btn2:
                numbertapped(2);
                break;

            case R.id.btn1:
                numbertapped(1);
                break;

            case R.id.btn0:
                numbertapped(0);
                break;


        }
        txtcalc.setText(calcstring);
    }

    private void numbertapped(int tap) {
        currentno = currentno + String.valueOf(tap);
        txtResult.setText(currentno);
        calcstring = currentno;
        txtcalc.setText(calcstring);
    }

    private void operatortap(OPERATOR tappedoperator)
    {
        if (currentoperator != null ) {
            if (currentno != "") {

                Rightno = currentno;
                currentno = "";

                switch (currentoperator) {
                    case PLUS:
                        calc = Double.parseDouble(Leftno) +
                                Double.parseDouble(Rightno);

                        break;

                    case SUBTRACT:
                        calc = Double.parseDouble(Leftno) -
                                Double.parseDouble(Rightno);

                        break;

                    case MULTIPLY:

                        calc = Double.parseDouble(Leftno) *
                                Double.parseDouble(Rightno);
                        break;

                    case DIVIDE:

                        calc =Double.parseDouble(Leftno) /
                              Double.parseDouble(Rightno);

                        break;
                    case EQUAL:
                        calc= calc;

                }
                Leftno = String.valueOf(calc);
                txtResult.setText(Leftno);
                calcstring = Leftno;
            }
        }

             else {
                Leftno = currentno;
                currentno = "";


            }

        currentoperator = tappedoperator;
    }

    private void clearTapped() {


        Leftno = "";
        Rightno = "";
        calc = 0;
        currentno = "";
        currentoperator = null;
        txtResult.setText("0");
        calcstring = "0";


    }
}