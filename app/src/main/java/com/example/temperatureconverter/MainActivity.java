package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText celciusInput;
    TextView kelvintext,fahrenText;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celciusInput = (EditText) findViewById(R.id.celciusEditText);
        fahrenText = findViewById(R.id.fahrenheitAnswer);
        kelvintext = findViewById(R.id.kelvinAnswer);
        convert = findViewById(R.id.convertButton);

        LinearLayout outputlayout = (LinearLayout) findViewById(R.id.outputLayout);
        outputlayout.setVisibility(View.INVISIBLE);

        setTheme(android.R.style.Theme_Light);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(celciusInput.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter the temperature in celcius", Toast.LENGTH_SHORT).show();
                    outputlayout.setVisibility(View.INVISIBLE);
                }
                else{

                    outputlayout.setVisibility(View.VISIBLE);
                    float celcius = Float.parseFloat(celciusInput.getText().toString());

                    float kelvin = (float) (273.15 + celcius);
                    kelvintext.setText(kelvin+"kelvin");

                    float fahrenheit = (float) (celcius*1.8 + 32);
                    fahrenText.setText(fahrenheit+" fahrenheit");
                }

            }
        });


    }
}