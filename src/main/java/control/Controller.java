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
        if(first == null){
            this.first = chest;
        } else {
            if (first.getNext() == null) {
                first.setNext(chest);
            } else {
                Chest current = first.getNext();
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(chest);
            }
        }
    }

    public String chestInfo(){
        return this.first.toString();
    }
}
