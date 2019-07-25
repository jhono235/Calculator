package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity<decimalFormat> extends AppCompatActivity {

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    TextView window, input;
    Button zero, one, two,three,four,five,six,seven,eight,nine,add,
            subtract,multiply,divide,clear,decimal,equals;

    static final Button[] buttons = new Button[] {


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding views
        window = findViewById(R.id.window);
        input = findViewById(R.id.input);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);

        equals = findViewById(R.id.equal);

        decimal= findViewById(R.id.decimal);
        clear = findViewById(R.id.clear);

        //setting onClickListener of the buttons and decimal
        zero.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + "9");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                input.setText(input.getText() + ".");
            }
        });

        //setting onClickListener for clear
        clear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if(input.getText().length()>0) {
                    CharSequence currentText = input.getText();
                    input.setText(currentText.subSequence(0,currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    input.setText("");
                    window.setText("");
                }
            }
        });

        //setting onClickListeners of the operators
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                CURRENT_ACTION = ADDITION;
                window.setText(valueOne + "+");
                input.setText(null);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                CURRENT_ACTION = SUBTRACTION;
                window.setText(valueOne + "-");
                input.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                CURRENT_ACTION = MULTIPLICATION;
                window.setText(valueOne + "x");
                input.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                CURRENT_ACTION = DIVISION;
                window.setText(valueOne + "/");
                input.setText(null);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                window.setText(window.getText().toString() +
                        valueTwo + " = " + valueOne);
                valueOne = Double.NaN;
                CURRENT_ACTION ='0';

            }
        });



    }

    //function for operator clicks.
    private void compute(){
        if (!Double.isNaN(valueOne)){
            valueTwo = Double.parseDouble(input.getText().toString());
            input.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;

        }
        else{
            try{
                valueOne = Double.parseDouble(input.getText().toString());
            }
            catch (Exception e) {}
        }
    }



}
