package control;

import model.*;

public class Controller {
    private Chest first;

    public Controller(){
    }

    public void createChest(String numberChest){
        Chest chest = new Chest(numberChest);
        
        addChest(chest);
    }

    private void addChest(Chest chest){
        this.first = chest;
    }
}
