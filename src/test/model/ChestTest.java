package model;
import model.Stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChestTest {
    private Chest chest1 = new Chest("01", "GENERAL");

    //Setup 4
    public void setupStage4(){
        chest1.createStack("01");
    }

    //Setup 5
    public void setupStage5(){
        chest1.createStack("01");
        chest1.createStack("02");
    }

    @Test
    public void esc1() {
        setupStage4();
    }

    @Test
    public void esc2() {
        setupStage5();
    }
}
