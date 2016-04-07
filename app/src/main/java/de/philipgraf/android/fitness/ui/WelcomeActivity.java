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

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        final EditText name_text = (EditText) findViewById(R.id.user_data_name);

        Button next = (Button) findViewById(R.id.welcome_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_text.getText().toString();
                PrefManager pref = PrefManager.getInstance(WelcomeActivity.this);
                pref.setUserName(name);

                Intent i = new Intent(WelcomeActivity.this, StartDataActivity.class);
                startActivity(i);
            }
        });
    }
}
