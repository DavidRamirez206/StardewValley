package control;

import model.*;
import structures.SimpleLinkedListChest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller {
    private SimpleLinkedListChest chests;

    public Controller(){
        chests = new SimpleLinkedListChest();
    }

    public void createChest(String chestNumber){
        Chest chest = new Chest(chestNumber);
        chests.add(chestNumber, chest);
    }

    public Chest searchChest(String id){
        return chests.search(id).getChest();
    }

    public int chestSize(){
        return chests.size();
    }

    public SimpleLinkedListChest getSimpleLinkedListChest(){
        return chests;
    }

    public void createStackToChest(String chestID, String stackID){
        chests.search(chestID).getChest().createStack(stackID);
    }

}
