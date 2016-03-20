package com.example.andy.cyquastion2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    TextView resultView;
    Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero;
    Button buttonAllClear, buttonBackspace, buttonNegative, buttonDivision, buttonMultiple, buttonMinus, buttonPlus, buttonDot, buttonEqual;
    int numberOfInput = 0;
    String input = "";
    String inputData="";
    boolean didInputASign = false;
    String[] signs = {"+", "-", "*", "/"};
    double result=0.0;
    boolean inputError=false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonAllClear = (Button) findViewById(R.id.buttonAllClear);
        buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        buttonNegative = (Button) findViewById(R.id.buttonNegative);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonMultiple = (Button) findViewById(R.id.buttonMultiple);
        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        resultView = (TextView) findViewById(R.id.ResultText);


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
                allClear();

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

        buttonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnNewInput("N");
            }
        });

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.isEmpty()) {
                    if (input.substring(input.length()-1,input.length()).contains(")")){
                        input = input.substring(0, input.length() - 3);
                    } else {
                        input = input.substring(0, input.length() - 1);
                    }


                    inputData=inputData.substring(0,inputData.length()-1);
                    resultView.setText(input);
                }


            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public  void allClear() {
        numberOfInput = 0;
        input = "";
        resultView.setText("");
        result=0;
        inputError=false;
        inputData="";
    }

    public void getAnNewInput(String NewInput) {
        if (NewInput=="N"){
            input=input+"(-)";
        } else {
            input = input + NewInput;
        }


        inputData =inputData+NewInput;


        if (input.length() > 14) {
            resultView.setTextSize(12);
            if (input.length() > 33) {
                allClear();
                resultView.setText("Overthrow");
                return;
            }
        }
        resultView.setText(input);
    }

    public void calculateResult() {
        String calculateNumber=inputData;
        int[] positionsOfSigns={0,0,0,0};
        String[] stringsSeperatedBySigns;
        String[] stringsSeperatedByPlus;
        double[] numbersSeperatedByPLus;
        for(int i=0;i<4;i++){
            for (int j=0; j<4;j++){
                if (calculateNumber.contains(signs[i]+signs[j])){
                    allClear();
                    resultView.setText("error");
                    return;
                }
            }
        }

        for (int i=0;i<4;i++){
            if(calculateNumber.substring(calculateNumber.length()-1,calculateNumber.length())==signs[i]||calculateNumber.substring(0,1)==signs[i]){
                allClear();
                resultView.setText("error");
                return;

            }
        }


        stringsSeperatedByPlus=calculateNumber.split("\\+");
        numbersSeperatedByPLus=new double[stringsSeperatedByPlus.length];
        for(int i=0;i<stringsSeperatedByPlus.length;i++){
            numbersSeperatedByPLus[i]=getNumberSeperateByPlus(stringsSeperatedByPlus[i]);
            result=result+numbersSeperatedByPLus[i];
        }
        if (inputError){
            resultView.setText("error");
        }else{
            resultView.setText(String.valueOf(result));
        }

    }

    public double getNumberSeperateByPlus(String stringSeperatedByPlus) {
        if (stringSeperatedByPlus.isEmpty()){
            inputError=true;
            return 0;
        }
        String[] stringsSeperatedByMinus=stringSeperatedByPlus.split("\\-");
        double[] numbersSeperatedByMinus;
        double result=0.0;

        numbersSeperatedByMinus=new double[stringsSeperatedByMinus.length];
        for(int i=0;i<stringsSeperatedByMinus.length;i++){
            numbersSeperatedByMinus[i]=getNumberSeperateByMultiple(stringsSeperatedByMinus[i]);
            if(i==0){
                result=numbersSeperatedByMinus[i];
            }
            else{
                result=result-numbersSeperatedByMinus[1];
            }
        }
        return result;
    }

    public double getNumberSeperateByMultiple(String stringSeperatedByMinus){
        double result=1;
        if (stringSeperatedByMinus.isEmpty()){
            inputError=true;
            return 0;
        }
        String[] stringsSeperatedByMultiple=stringSeperatedByMinus.split("\\*");
        double[] numbersSeperatedByMultiple;
        numbersSeperatedByMultiple=new double[stringsSeperatedByMultiple.length];
        for(int i=0;i<stringsSeperatedByMultiple.length;i++){
            numbersSeperatedByMultiple[i]=getNumberSeperateByDivision(stringsSeperatedByMultiple[i]);
            result=result*numbersSeperatedByMultiple[i];
        }
        return result;
    }

    public double getNumberSeperateByDivision(String stringSeperatedByMultiple){
        double result=1.0;
        if (stringSeperatedByMultiple.isEmpty()){
            inputError=true;
            return 0;
        }
        String[] stringsSeperatedByDivision=stringSeperatedByMultiple.split("\\/");
        double[] numbersSeperatedByDivision;
        numbersSeperatedByDivision=new double[stringsSeperatedByDivision.length];
        for(int i=1;i<stringsSeperatedByDivision.length;i++){
            if (getNumbers(stringsSeperatedByDivision[i])==0){
                inputError=true;
                return 0.0;
            }
        }
        result=getNumbers(stringsSeperatedByDivision[0]);
        for(int i=1;i<stringsSeperatedByDivision.length;i++){
            numbersSeperatedByDivision[i]=getNumbers(stringsSeperatedByDivision[i]);
            result=result/numbersSeperatedByDivision[i];
        }
        return result;
    }
    public double getNumbers(String stringSeperatedByDivision){
        double result=1.0;
        if (stringSeperatedByDivision.isEmpty()){
            inputError=true;
            return 0.0;
        }

        if (stringSeperatedByDivision.substring(1).contains("N")){
            inputError=true;
            return 0.0;
        }

        String[] dotNumber=stringSeperatedByDivision.split("\\.");
        if(dotNumber.length>2){
            inputError=true;
            return 0.0;
        }






        if (stringSeperatedByDivision.contains("N")){
            result=-Double.parseDouble(stringSeperatedByDivision.substring(1,stringSeperatedByDivision.length()));
        } else {
            result=Double.parseDouble(stringSeperatedByDivision);
        }
        return result;

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.andy.cyquastion2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.andy.cyquastion2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
