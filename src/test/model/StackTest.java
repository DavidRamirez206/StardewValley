package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    //Setup 6
    public void setupStage6(){
        stack = new Stack("01");
        stack.add("Poppy", 2, 28);
        stack.add("Poppy", 2, 28);
    }

    //Setup 6
    public void setupStage7(){
        stack = new Stack("01");
        stack.add("Poppy", 2, 28);
        stack.add("Poppy", 2, 28);
        stack.add("Poppy", 2, 28);
    }

    //Esc 1
    @Test
    public void esc1() {
        //init
        setupStage6();

        //Act
        stack.add("Poppy", 2, 28);

        Crop crop = new Crop("Poppy", 2, 28);
        assertEquals(crop.getName(), stack.searchCrop("Poppy").getName());
    }

    //Esc 2
    @Test
    public void esc2() {
        //init
        setupStage7();

        //Act

        //Stack size before adding another crop
        int expectedStackSize = stack.getSize();
        stack.add("Poppy", 2, 28);

        //Stack size after
        expectedStackSize ++;

        //Assert
        Crop crop = new Crop("Poppy", 2, 28);
        assertEquals(expectedStackSize, stack.getSize());
    }

    //Esc 3
    @Test
    public void esc3() {
        //init
        setupStage7();

        //Act
        int expectedStackSize = stack.getSize();
        stack.add("Poppy", 1, 28);

        //Assert
        Crop crop = new Crop("Garli", 2, 28);
        assertEquals(crop.getName(), stack.stackType());
    }
}
