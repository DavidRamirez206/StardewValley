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
}
