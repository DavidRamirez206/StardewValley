package control;

import java.util.Calendar;

import Exceptions.*;
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
        Calendar currentTime = Calendar.getInstance();
        long elapsedTime = (currentTime.getTimeInMillis() - firstTime.getTimeInMillis()) / (1000 * 60);

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
        } else {
            season = 4;
        }
        return season;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }
 
    public void createChest(String chestID, String typeChest){
        Chest chest = new Chest(chestID, typeChest);
        chests.add(chestID, chest);
    }

    public SimpleLinkedListChest getSimpleLinkedListChest(){
        return chests;
    }

    public String createStackToChest(String chestID, String stackID) {
        try {
            Chest chest = chests.search(chestID).getChest();
            return chest.createStack(stackID);
        } catch (ChestException se) {
            return "Error: " + se.getMessage();
        }
    }

    public String addCropToStack(String chestNumber, String stackId, String cropName, int seasonOption, int growthTime) {
        try {
            Chest chest = chests.search(chestNumber).getChest();
            Stack stack = chest.searchStack(stackId);
            String chesType = chest.getTypeChest();

            if(chesType.equalsIgnoreCase("GENERAL")){
                return stack.add(cropName, seasonOption, growthTime);
            } else if(chesType.equalsIgnoreCase(cropName)){

                return stack.add(cropName, seasonOption, growthTime);
            } else {
                return "You are trying to add a different crop to a specific crop chest. The type of chest and the crop are different";
            }
        } catch (ChestException ce) {
            return "Error: " + ce.getMessage();
        } catch (StackException se) {
            return "Error: " + se.getMessage();
        }
    }

    public void sortingChest(int sortOption){
        switch (sortOption){
            case 1:
                sortingChestByName();
                break;
            case 2:
                sortingChestByType();
                break;
            case 3:
                sortingChestByGrowthTime();
                break;
            default:
                break;
        }
    }

    public void sortingChestByName(){
    }

    public void sortingChestByType(){
    }

    public void sortingChestByGrowthTime(){
    }
}