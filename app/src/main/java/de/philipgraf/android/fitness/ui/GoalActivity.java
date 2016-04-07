package de.philipgraf.android.fitness.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.philipgraf.android.fitness.R;
import de.philipgraf.android.fitness.utils.PrefManager;

public class GoalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        final EditText goal_weight = (EditText) findViewById(R.id.goal_weight);
        final EditText goal_fat = (EditText) findViewById(R.id.goal_fat);
        final EditText duration = (EditText) findViewById(R.id.goal_duration);

        Button finishButtn = (Button) findViewById(R.id.btn_finish);
        finishButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefManager prefs = PrefManager.getInstance(GoalActivity.this);
                prefs.setGoalWeight(Float.valueOf(goal_weight.getText().toString()));
                prefs.setGoalFat(Float.valueOf(goal_fat.getText().toString()));
                prefs.setDuration(Integer.valueOf(duration.getText().toString()));
                prefs.setSetupFinished(true);
                Intent i = new Intent(GoalActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
