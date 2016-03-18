package com.example.andy.cyquastion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultView;
    Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero;
    Button buttonAllClear, buttonPlusOrMinus, buttonPerCent, buttonDivision, buttonMultiple, buttonMinus, buttonPlus, buttonDot, buttonEqual;
    int numberOfInput=0;
    String input="";
    boolean didInputASign=false;
    String[] signs={"+","-","x","/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonZero=(Button)findViewById(R.id.buttonZero);
        buttonAllClear=(Button)findViewById(R.id.buttonAllClear);
        buttonPlusOrMinus=(Button)findViewById(R.id.buttonPlusOrMinus);
        buttonPerCent=(Button)findViewById(R.id.buttonPerCent);
        buttonDivision=(Button)findViewById(R.id.buttonDivision);
        buttonSeven=(Button)findViewById(R.id.buttonSeven);
        buttonEight=(Button)findViewById(R.id.buttonEight);
        buttonNine=(Button)findViewById(R.id.buttonNine);
        buttonMultiple=(Button)findViewById(R.id.buttonMultiple);
        buttonFour=(Button)findViewById(R.id.buttonFour);
        buttonFive=(Button)findViewById(R.id.buttonFive);
        buttonSix=(Button)findViewById(R.id.buttonSix);
        buttonMinus=(Button)findViewById(R.id.buttonMinus);
        buttonOne=(Button)findViewById(R.id.buttonOne);
        buttonTwo=(Button)findViewById(R.id.buttonTwo);
        buttonThree=(Button)findViewById(R.id.buttonThree);
        buttonPlus=(Button)findViewById(R.id.buttonPlus);
        buttonDot=(Button)findViewById(R.id.buttonDot);
        buttonEqual=(Button)findViewById(R.id.buttonEqual);
        resultView=(TextView)findViewById(R.id.ResultText);


        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("0");
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("3");
            }
        });


        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("9");
            }
        });

        buttonAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfInput=0;
                input="";
                resultView.setText("");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("-");
            }
        });

        buttonMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("*");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("/");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput(".");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }

        });

        buttonPerCent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("%");
            }
        });

        buttonPlusOrMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void getAnNewInput(String NewInput) {
        input=input+NewInput;
        if (input.length()>14) {
            resultView.setText("overflow");
            return;
        }
        resultView.setText(input);
    }

    public void calculateResult() {
        for (int i=0;i<signs.length;i++) {
            if (input.indexOf(signs[i])>0){

            }
        }
    }
}
