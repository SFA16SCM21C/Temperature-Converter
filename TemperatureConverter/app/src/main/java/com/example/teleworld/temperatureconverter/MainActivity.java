package com.example.teleworld.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    //variable declarations for the widgets used
    private EditText enterTemp;
    private RadioButton FahtoCel;
    private RadioButton CeltoFah;

    //variable declaration for history of temperature changes
    private TextView historyOfValues;
    private TextView tipTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the data from the inputs in the layout
        enterTemp = (EditText)findViewById(R.id.temperatureText);
        FahtoCel = (RadioButton)findViewById(R.id.toCelsiusRadioBtn);
        CeltoFah = (RadioButton)findViewById(R.id.toFahrenheitRadioBtn);
        historyOfValues = (TextView)findViewById(R.id.historytemp);
        tipTemp = (TextView)findViewById(R.id.tipTemp);
    }

    //button clicked-method
    public void convertTemp(View v){

        //getting the value and providing as input to the desired methods
        double tempValue = new Double(enterTemp.getText().toString());
        String firstvalue = enterTemp.getText().toString();
        String changedvalues,tip;

        //checking which radio button is clicked and calling the appropriate function
        if(FahtoCel.isChecked()){

            //call function converting Fahrenheit to Celsius
            tempValue = TempConvert.fahrenheit_celsius(tempValue);
            changedvalues = firstvalue + " F" + " to " + tempValue + " C";
            int cel = (int)tempValue;

            //tip for celsius range
            if(cel <= 0){
                tip = "TIP : Get your winter Wear on!";
            }
            else if(cel > 0 && cel <= 20){
                tip = "TIP : A bright Sunny day to enjoy!";
            }
            else if(cel > 20 && cel <= 40){
                tip = "TIP : Time to wear some light clothes!";
            }
            else if(cel > 40 && cel <= 55){
                tip = "TIP : Advisable to stay inside your house!";
            }
            else{
                tip = "TIP : Not for Humans!";
            }
        }
        else
        {
            tempValue = TempConvert.celsius_fahrenheit(tempValue);
            changedvalues = firstvalue + " C" + " to " + tempValue + " F";
            int fah = (int)tempValue;

            //tip for celsius range
            if(fah < 32){
                tip = "TIP : Get your winter Wear on!";
            }
            else if(fah > 32 && fah <= 68){
                tip = "TIP : A bright Sunny day to enjoy!";
            }
            else if(fah > 68 && fah <= 95){
                tip = "TIP : Time to wear some light clothes!";
            }
            else if(fah > 95 && fah <= 131){
                tip = "TIP : Advisable to stay inside your house!";
            }
            else{
                tip = "TIP : Not for Humans!";
            }
        }

        //setting back the new value after conversion
        enterTemp.setText(new Double(tempValue).toString());

        //setting the history into the textview
        String history =  historyOfValues.getText().toString();
        historyOfValues.setMovementMethod(new ScrollingMovementMethod());
        historyOfValues.setText(changedvalues + "\n" + history);

        //setting the tip to the textview
        tipTemp.setText(tip);

        //clearing the enter temperature space
        enterTemp.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("HISTORY",historyOfValues.getText().toString());
        outState.putString("TIP",tipTemp.getText().toString());

        // Call super last to save the values
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        // Call super first to extract the values
        super.onRestoreInstanceState(savedInstanceState);
        historyOfValues.setText(savedInstanceState.getString("HISTORY"));
        tipTemp.setText(savedInstanceState.getString("TIP"));
    }
    }
