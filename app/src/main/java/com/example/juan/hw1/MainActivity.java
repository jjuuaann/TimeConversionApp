package com.example.juan.hw1;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.R.attr.id;
import static android.R.id.input;

public class MainActivity extends AppCompatActivity {

    TextView timeLable;
    TextView prevDay;
    TextView newTime;
    EditText hour;
    EditText minute;

    Button est;
    Button cst;
    Button mst;
    Button pst;
    Button clear;
    RadioGroup rg;
    Button convert;

    Switch sw;


    LinearLayout btnLayout;
    LinearLayout rbLayout;



    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        est = (Button) findViewById(R.id.buttonEST);
        cst = (Button) findViewById(R.id.buttonCST);
        mst = (Button) findViewById(R.id.buttonMST);
        pst = (Button) findViewById(R.id.buttonPST);
        clear = (Button) findViewById(R.id.buttonClear);
        hour = (EditText) findViewById(R.id.etHour);
        minute = (EditText) findViewById(R.id.etMinutes);
        prevDay = (TextView) findViewById(R.id.editTextPrevDay);
        newTime = (TextView) findViewById(R.id.editTextTime);
        timeLable = (TextView) findViewById(R.id.tvTimeLable);
        rg = (RadioGroup) findViewById(R.id.radioButtons);
        convert = (Button) findViewById(R.id.btnConvert);

        btnLayout = (LinearLayout) findViewById(R.id.ButtonLayout);
        rbLayout = (LinearLayout) findViewById(R.id.radioButtonLayout);
        sw = (Switch) findViewById(R.id.switchToggle);
        //test = (TextView) findViewById(R.id.editTextTest);



        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                Log.d("demo", "Checked the " + rb.getText().toString());
            }
        });


        findViewById(R.id.btnConvert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rg.getCheckedRadioButtonId() == R.id.rbEST)
                {
                    Calculate("EST");
                    timeLable.setText("Time EST :");
                }
                else if (rg.getCheckedRadioButtonId() == R.id.rbCST)
                {
                    Calculate("CST");
                    timeLable.setText("Time CST :");
                }
                else if (rg.getCheckedRadioButtonId() == R.id.rbMST)
                {
                    Calculate("MST");
                    timeLable.setText("Time MST :");
                }
                else if (rg.getCheckedRadioButtonId() == R.id.rbPST)
                {
                    Calculate("PST");
                    timeLable.setText("Time PST :");
                }
               // else if (rg.getCheckedRadioButtonId() == R.id.rbClearAll)
                //{
                  //  Calculate("clear");
                //}
                else if (rg.getCheckedRadioButtonId() == R.id.rbClearAll)
                {
                    hour.setText("");
                    minute.setText("");
                    newTime.setText("");
                    prevDay.setText("");

                }
                else if (id == -1)
                {
                    Toast.makeText(getApplicationContext(), "Please select and option", Toast.LENGTH_SHORT).show();
                    Log.d("demo", "None is checked");
                }

            }
        });


        est.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int m = Integer.valueOf(minute.getText().toString());


                    if (m < 60 && m >= 0) {
                        Calculate("EST");
                        timeLable.setText("Time EST :");

                    } else {
                        hour.setText("");
                        minute.setText("");
                        newTime.setText("");
                        prevDay.setText("");
                        throw new Exception("Invalid Minute Value");
                    }
                } catch (Exception e) {

                    hour.setText("");
                    minute.setText("");
                    newTime.setText("");
                    prevDay.setText("");
                    Toast.makeText(MainActivity.this, "Enter valid minute", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cst.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                try {
                    int m = Integer.valueOf(minute.getText().toString());

                    if (m < 60 && m >= 0) {
                        Calculate("CST");
                        timeLable.setText("Time CST :");
                    } else {
                        hour.setText("");
                        minute.setText("");
                        newTime.setText("");
                        prevDay.setText("");
                        throw new Exception("Invalid Minute Value");
                    }
                } catch (Exception e) {

                    hour.setText("");
                    minute.setText("");
                    newTime.setText("");
                    prevDay.setText("");
                    Toast.makeText(MainActivity.this, "Enter valid minute", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mst.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                try {
                    int m = Integer.valueOf(minute.getText().toString());

                    if (m < 60 && m >= 0) {
                        Calculate("MST");
                        timeLable.setText("Time MST :");
                    } else {
                        hour.setText("");
                        minute.setText("");
                        newTime.setText("");
                        prevDay.setText("");
                        throw new Exception("Invalid Minute Value");
                    }
                } catch (Exception e) {

                    hour.setText("");
                    minute.setText("");
                    newTime.setText("");
                    prevDay.setText("");
                    Toast.makeText(MainActivity.this, "Enter valid minute", Toast.LENGTH_SHORT).show();
                }

            }
        });

        pst.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                try {
                    int m = Integer.valueOf(minute.getText().toString());

                    if (m < 60 && m >= 0) {
                        Calculate("PST");
                        timeLable.setText("Time PST :");
                    } else {
                        hour.setText("");
                        minute.setText("");
                        newTime.setText("");
                        prevDay.setText("");
                        throw new Exception("Invalid Minute Value");
                    }
                } catch (Exception e) {

                    hour.setText("");
                    minute.setText("");
                    newTime.setText("");
                    prevDay.setText("");
                    Toast.makeText(MainActivity.this, "Enter valid minute", Toast.LENGTH_SHORT).show();
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                hour.setText("");
                minute.setText("");
                newTime.setText("");
                prevDay.setText("");

            }
        });





        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButtonRB);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    //Intent intentBtn = new Intent(MainActivity.this, rbLayout.this);
                    // The toggle is enabled

                    /*
                    have a view covering rbLayoutand another covering buttons
                            give views id, make a flag
                            and only thing in the if statements */

                    btnLayout.setVisibility(View.INVISIBLE);
                    rbLayout.setVisibility(View.VISIBLE);







                } else {
                    // The toggle is disabled



                    btnLayout.setVisibility(View.INVISIBLE);
                    rbLayout.setVisibility(View.VISIBLE);
                   // btnLayout.setVisibility(View.INVISIBLE);

                Toast.makeText(MainActivity.this, "Toggle is off", Toast.LENGTH_SHORT).show();




                }
            }
        });

}




    public void Calculate(String zone) {
        try {
            int h = Integer.valueOf(hour.getText().toString());
            if (h <= 24 && h >= 0) {
                switch (zone) {
                    case "EST":
                        h -= 5;
                        break;
                    case "CST":
                        h -= 6;
                        break;
                    case "MST":
                        h -= 7;
                        break;
                    case "PST":
                        h -= 8;
                        break;
                    case "clear":
                        hour.setText("");
                        minute.setText("");
                        newTime.setText("");
                        prevDay.setText("");

                }
                if (h < 0) {
                    prevDay.setText("Previous Day");
                    prevDay.setTextColor(Color.RED);
                    h += 24;
                } else {
                    prevDay.setText("");
                }
                newTime.setText(String.format("%02d", h)
                        + ":"
                        + String.format("%02d", Integer.valueOf(minute.getText().toString())));
            } else {

                hour.setText("");
                minute.setText("");
                newTime.setText("");
                prevDay.setText("");
                Toast.makeText(this, "Enter valid hour", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            hour.setText("");
            minute.setText("");
            newTime.setText("");
            prevDay.setText("");
            Toast.makeText(this, "Enter valid number", Toast.LENGTH_SHORT).show();
        }
    }

}
