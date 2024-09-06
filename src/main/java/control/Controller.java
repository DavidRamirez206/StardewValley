package control;

import model.*;
import structures.SimpleLinkedListChest;

public class Controller {
    private SimpleLinkedListChest chests;
    private Season currentSeason;
    private Thread seasonChangeThread;

    public Controller(){
        chests = new SimpleLinkedListChest();
        this.currentSeason = Season.SPRING;  // Initial season
        startSeasonChange();

    }

    private void startSeasonChange() {
        seasonChangeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1 * 60 * 1000);  // Wait 1 minute (5 * 60 * 1000 ms)
                        changeSeason();
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException("Season change interrupted.");
                    }
                }
            }
        });
        seasonChangeThread.start();  // Start the thread
    }

    // Method to change to the next season
    private void changeSeason() {
        switch (currentSeason) {
            case SPRING:
                currentSeason = Season.SUMMER;
                break;
            case SUMMER:
                currentSeason = Season.FALL;
                break;
            case FALL:
                currentSeason = Season.WINTER;
                break;
            case WINTER:
                currentSeason = Season.SPRING;
                break;
            case ANY_SEASON:
                currentSeason = Season.ANY_SEASON;
                break;
        }
    }

    // Getter for the current season
    public int currentSeason(){
        int season = 0;
        if (currentSeason.equals(Season.SPRING)) {
            season = 1;
        } else if (currentSeason.equals(Season.SUMMER)) {
            season = 2;
        } else if (currentSeason.equals(Season.FALL)) {
            season = 3;
        } else if (currentSeason.equals(Season.WINTER)) {
            season = 4;
        } else {
            season = 5;
        }
        return season;
    }


    public Season getCurrentSeason() {
        return currentSeason;
    }

    // Method to stop the thread (when the program ends)
    public void stopThread() {
        if (seasonChangeThread != null && seasonChangeThread.isAlive()) {
            seasonChangeThread.interrupt();
        }
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
