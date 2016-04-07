package de.philipgraf.android.fitness.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import de.philipgraf.android.fitness.R;
import de.philipgraf.android.fitness.utils.DatePickerFragment;
import de.philipgraf.android.fitness.utils.PrefManager;

public class StartDataActivity extends Activity implements DatePickerDialog.OnDateSetListener {

    private Button mChoiceStartDate;
    private String mChoicedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_data);
        mChoiceStartDate = (Button) findViewById(R.id.start_date);
        Button next = (Button) findViewById(R.id.btn_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText startWeight = (EditText) findViewById(R.id.start_weight);
                EditText startFat = (EditText) findViewById(R.id.start_fat);
                PrefManager prefs = PrefManager.getInstance(StartDataActivity.this);
                prefs.setStartWeight(Float.valueOf(startWeight.getText().toString()));
                prefs.setStartFat(Float.valueOf(startFat.getText().toString()));
                prefs.setStartDate(mChoicedDate);
                Intent i = new Intent(StartDataActivity.this, GoalActivity.class);
                startActivity(i);
            }
        });
        mChoiceStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        mChoicedDate = String.valueOf(dayOfMonth) + "." + (monthOfYear + 1) + "." + year;
        mChoiceStartDate.setText(mChoicedDate);
    }
}
