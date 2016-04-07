package de.philipgraf.android.fitness.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;


public class ExerciseTest {

    private Exercise exercise;

    @Before
    public void setup() {
        exercise = new Exercise("Situp", 30, 1, Exercise.Unit.TIMES);
    }

    @Test
    public void getNameTest() {
        assertThat(exercise.getName(), is("Situp"));
    }

    @Test
    public void getAmountTest() {
        assertThat(exercise.getAmount(), is(30));
    }

    @Test
    public void getImageIdTest() {
        assertThat(exercise.getImageId(), is(1));
    }

    @Test
    public void getUnitTest() {
        assertThat(exercise.getUnit(), is(Exercise.Unit.TIMES));
    }

    @Test
    public void getAmountStringTest() {
        assertThat(exercise.getAmountString(), is("x30"));
    }
}
