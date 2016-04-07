package de.philipgraf.android.fitness.model;

import java.io.Serializable;

/**
 * Created by philip on 8/21/15.
 */
public class Exercise implements Serializable {

    public static String getAmountString(int amount, Unit unit) {
        switch (unit) {
            case TIMES:
                return "x" + amount;
            case SECONDS:
                return String.valueOf(amount) + " sec";
        }
        return "";
    }

    private String name;
    private int amount;
    private int image_id;
    private Unit unit;

    public Exercise(String name, int amount, int image_id, Unit unit) {
        this.name = name;
        this.amount = amount;
        this.image_id = image_id;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getImageId() {
        return image_id;
    }

    public void setImageId(int image) {
        this.image_id = image;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getAmountString() {
        return Exercise.getAmountString(amount, unit);
    }

    public enum Unit {
        TIMES, SECONDS
    }
}
