package de.philipgraf.android.fitness.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import de.philipgraf.android.fitness.R;
import de.philipgraf.android.fitness.model.Exercise;
import de.philipgraf.android.fitness.model.Workout;

public class WorkoutActivity extends AppCompatActivity implements ExerciseFragment.Callbacks {

    Workout workout = Workout.getWorkout();
    int currentExercise = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            ExerciseFragment fragment = new ExerciseFragment();

            Bundle b = new Bundle();
            b.putSerializable(getString(R.string.intent_exercise), workout.getExercises().get(currentExercise));
            fragment.setArguments(b);

            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();
        }
    }

    @Override
    public void onStart(Exercise exercise) {

    }

    @Override
    public void onFinish(Exercise exercise) {
        currentExercise++;
        if (currentExercise >= workout.getExercises().size()) {
            finish();
        } else {
            ExerciseFragment fragment = new ExerciseFragment();
            Bundle b = new Bundle();
            b.putSerializable(getString(R.string.intent_exercise), workout.getExercises()
                    .get(currentExercise));
            fragment.setArguments(b);

            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit();
        }

    }
}
