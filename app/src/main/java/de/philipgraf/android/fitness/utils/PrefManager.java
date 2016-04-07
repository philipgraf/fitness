package de.philipgraf.android.fitness.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by philip on 8/21/15.
 */
public class PrefManager {

    private static PrefManager instance = null;

    private static final String FILE_NAME = "prefs";
    private static final String USER_NAME = "user_name";
    private static final String START_WEIGHT = "start_weight";
    private static final String START_FAT = "start_fat";
    private static final String START_DATE= "start_date";
    private static final String GOAL_WEIGHT = "goal_weight";
    private static final String GOAL_FAT = "goal_fat";
    private static final String DURATION = "duration";
    private static final String SETUP_FINISHED = "setup_finished";

    private SharedPreferences prefs;

    private PrefManager(Context context) {
        prefs = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static PrefManager getInstance(Context context) {
        if (instance == null) {
            instance = new PrefManager(context);
        }
        return instance;
    }

    public void setUserName(String userName) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    public boolean isSetupFinished() {
        return prefs.getBoolean(SETUP_FINISHED, false);
    }

    public void setGoalWeight(Float weight) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(GOAL_WEIGHT, weight);
        editor.apply();
    }

    public void setGoalFat(Float fat) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(GOAL_FAT, fat);
        editor.apply();
    }

    public void setStartWeight(Float weight) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(START_WEIGHT, weight);
        editor.apply();
    }

    public void setStartFat(Float fat) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(START_FAT, fat);
        editor.apply();
    }

    public void setDuration(Integer duration) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(DURATION, duration);
        editor.apply();
    }

    public void setSetupFinished(boolean setupFinished) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(SETUP_FINISHED, setupFinished);
        editor.apply();
    }

    public void setStartDate(String startDate) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(START_DATE, startDate);
        editor.apply();
    }
}
