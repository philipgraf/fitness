package de.philipgraf.android.fitness.model;

import java.util.ArrayList;

import de.philipgraf.android.fitness.R;

/**
 * Created by philip on 8/21/15.
 */
public class Workout {
    private String name;
    private int sets;
    private int secondsBetweenSets;
    private ArrayList<Exercise> exercises;


    public static Workout getWorkout() {
        Workout workout = new Workout();

        workout.setName("Wake Up Workout");
        ArrayList<Exercise> exercises = new ArrayList<>(9);
        exercises.add(new Exercise("Jumping Jacks", 15, R.drawable.jumping_jack, Exercise.Unit.TIMES));
        exercises.add(new Exercise("Squats", 15, R.drawable.squats, Exercise.Unit.TIMES));
        exercises.add(new Exercise("Lunges", 15, R.drawable.lunges, Exercise.Unit.TIMES));
        exercises.add(new Exercise("Climbers", 25, R.drawable.climbers, Exercise.Unit.TIMES));
        exercises.add(new Exercise("Push Ups", 15, R.drawable.push_ups, Exercise.Unit.TIMES));
        exercises.add(new Exercise("Plank Jacks", 15, R.drawable.plank_jacks, Exercise.Unit.TIMES));
        exercises.add(new Exercise("Situps", 15, R.drawable.situps, Exercise.Unit.TIMES));
        //  exercises.add(new Exercise("Knee to elbow crunches", 15, R.drawable.knee_to_elbow_crunches, Exercise.Unit.TIMES));
        exercises.add(new Exercise("Plank JumpIns", 10, R.drawable.plank_jump_ins, Exercise.Unit.TIMES));
        exercises.add(new Exercise("elbow plank", 35, R.drawable.elbow_plank, Exercise.Unit.SECONDS));
        workout.setExercises(exercises);

        return workout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}


