package edu.fvtc.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.concurrent.BlockingDeque;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private static final String[] items ={
            "Call of Duty",
            "Counter-strike",
            "Battlefield 1942",
            "Hogwarts Legacy",
            "World of Warcraft",
            "Baldur's Gate",
            "Icewind Dale"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();
    }

    private void initSpinner() {
        Spinner spItems = findViewById(R.id.items);

        // Automatic Themes formatting
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_spinner_item,
        //        items);

        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Custom xml formatting
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.simple_spinner_item,
                items);

        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);


        spItems.setAdapter(arrayAdapter);

        // handle clicking
        spItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemSelected: ");
                TextView tvInfo = findViewById(R.id.tvInfo);
                tvInfo.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}