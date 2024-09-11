package model;

import Exceptions.StackException;
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

    //Esc 1
    @Test
    public void esc3() throws StackException {
        //init
        setupStage4();

        //Act
        chest1.createStack("02");

        //Assert
        Stack stack = new Stack("02");
        assertEquals(stack.getId(), chest1.searchStack("02").getId());
    }

    //Esc 2
    @Test
    public void esc2() throws StackException {
        //init
        setupStage5();

        //Act
        chest1.createStack("03");

        assertEquals("02", chest1.searchStack("02").getId());
    }
}
