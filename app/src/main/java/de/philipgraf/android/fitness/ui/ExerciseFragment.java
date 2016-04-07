package de.philipgraf.android.fitness.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.philipgraf.android.fitness.R;
import de.philipgraf.android.fitness.model.Exercise;

public class ExerciseFragment extends Fragment {

    boolean started = false;

    public ExerciseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        final Exercise exercise = (Exercise) getArguments().getSerializable(getString(R.string.intent_exercise));
        final TextView amount = (TextView) view.findViewById(R.id.amount);
        final ImageView image = (ImageView) view.findViewById(R.id.exercise_image);
        Button start = (Button) view.findViewById(R.id.start_exercise);

        final Callbacks c = (Callbacks) getActivity();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (started) {
                    started = false;
                    c.onFinish(exercise);
                } else {
                    started = true;
                    b.setText(R.string.stop);
                    c.onStart(exercise);
                    if (exercise != null) {
                        if (exercise.getUnit() == Exercise.Unit.SECONDS) {
                            new CountDownTimer(exercise.getAmount() * 1000, 1000) {

                                public void onTick(long millisUntilFinished) {
                                    String text = Exercise.getAmountString(
                                            (int) millisUntilFinished / 1000,
                                            exercise.getUnit());
                                    amount.setText(text);
                                }

                                public void onFinish() {
                                    amount.setText("Geschafft!");
                                }
                            }.start();
                        }
                    }
                }
            }
        });

        if (exercise != null) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle(exercise.getName());
            }

            amount.setText(exercise.getAmountString());
            image.setImageResource(exercise.getImageId());
        }


        return view;
    }

    public interface Callbacks {
        void onStart(Exercise exercise);

        void onFinish(Exercise exercise);
    }
}
