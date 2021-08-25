package com.example.inclass2b;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import static java.lang.Float.parseFloat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Declaring variables
        TextView convertedValue = findViewById(R.id.convertedValue);
        EditText inchesText = findViewById(R.id.inchesText);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);


        //Button logic code
        findViewById(R.id.convertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                double value;

                //Condition to check if the input box is empty
                if((inchesText.getText().toString().isEmpty()) && (checkedId != R.id.clear)){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    if(checkedId == R.id.meters){
                        value = (parseFloat(inchesText.getText().toString()) * 0.0254);
                        convertedValue.setText(value + " " + getResources().getString(R.string.metersText));
                    }
                    else if(checkedId == R.id.feet){
                        value = (parseFloat(inchesText.getText().toString()) / 12);
                        convertedValue.setText(value + " " + getResources().getString(R.string.feetText));
                    }
                    else if(checkedId == R.id.miles){
                        value = (parseFloat(inchesText.getText().toString()) / 63360);
                        convertedValue.setText(value + " " + getResources().getString(R.string.milesText));
                    }
                    else if(checkedId == R.id.clear){
                        inchesText.setText("");
                        convertedValue.setText("");
                    }
                }

            }
        });

    }
}