package control;

import java.util.Calendar;

import model.*;
import structures.SimpleLinkedListChest;

public class Controller {
    private SimpleLinkedListChest chests;
    private Season currentSeason;
    private Calendar firstTime;
    private static final int INTERVAL_MINUTES = 1;

    public Controller(){
        chests = new SimpleLinkedListChest();
        this.currentSeason = Season.SPRING;  // Initial season
        this.firstTime = Calendar.getInstance();

    }

    public void updateStation() {
        Calendar currenteTime = Calendar.getInstance();
        long elapsedTime = (currenteTime.getTimeInMillis() - firstTime.getTimeInMillis()) / (1000 * 60);

        if (elapsedTime >= INTERVAL_MINUTES) {
            changeSeason();
            firstTime = Calendar.getInstance(); 
        }
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
