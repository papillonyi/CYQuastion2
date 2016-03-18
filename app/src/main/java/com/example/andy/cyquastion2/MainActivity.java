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
    Button buttonAllClear, buttonBackspace, buttonPerCent, buttonDivision, buttonMultiple, buttonMinus, buttonPlus, buttonDot, buttonEqual;
    int numberOfInput = 0;
    String input = "";
    boolean didInputASign = false;
    String[] signs = {"+", "-", "x", "/"};
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
        buttonPerCent = (Button) findViewById(R.id.buttonPerCent);
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
                numberOfInput = 0;
                input = "";
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

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                    resultView.setText(input);
                }


            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void getAnNewInput(String NewInput) {
        input = input + NewInput;
        if (input.length() > 14) {
            resultView.setTextSize(12);
            if (input.length() > 33) {
                resultView.setText("Overthrow");
                return;
            }
        }
        resultView.setText(input);
    }

    public void calculateResult() {


    }

    public int positionOfFirstSign(String input) {
        int firstSigns = 50;

        for (int i = 0; i < signs.length; i++) {
            if (firstSigns > input.indexOf(signs[i]) && input.indexOf(signs[i]) > 0) {
                firstSigns = input.indexOf(signs[i]);
            }
        }
        if (firstSigns==50){
            return  -1;
        }

        return firstSigns;


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
