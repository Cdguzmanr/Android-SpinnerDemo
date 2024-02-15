package edu.fvtc.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private static final String[] items = new String[]{
            "Call of Duty",
            "Counter-strike",
            "Battlefield 1940",
            "Hogwards Legacy",
            "World of Warcraft",
            "Baldur's Gate",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSpinner();
    }

    private void initSpinner() {
        Spinner spItems = findViewById(R.id.items);

        // This is how to bind data with the spinner (drop down box)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                items);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // connects back to the controller
        spItems.setAdapter(arrayAdapter);

        // handle clicking
        spItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: ");
                TextView tvInfo = findViewById(R.id.tvInfo);
                tvInfo.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}