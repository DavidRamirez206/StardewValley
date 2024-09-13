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

    public int chestSize(){
        return chests.size();
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
    
    

    public String addCropToStack(String chestID, String stackId, String cropName, int seasonOption, int growthTime) {
        try {
            Chest chest = chests.search(chestID).getChest();    
            Stack stack = chest.searchStack(stackId);
            int size = stack.getCrops().size();
    
            String stackType = stack.stackType();
            String chesType = chest.getTypeChest();

            if(chesType.equalsIgnoreCase("GENERAL")){
                if(stackType == null){
                    return  stack.add(cropName, seasonOption, growthTime);
                } else if(stackType.equalsIgnoreCase(cropName) && size <= 25){
                    return stack.add(cropName, seasonOption, growthTime);
                }
            } else {
                if(stackType == null){
                    if(chesType.equalsIgnoreCase(cropName)){
                        return stack.add(cropName, seasonOption, growthTime);
                    }
                } else {
                    if(chesType.equalsIgnoreCase(cropName) && size <= 25){
                        return stack.add(cropName, seasonOption, growthTime);
                    }
                }
            }

            return "You cannot add this crop to this stack: You have attempted to add a crop of a different type or the stack is full. " +
                    "\nIf the chest is of only one type, remember that you can only add crops of that same type.";
    
        } catch (ChestException | StackException ce) {
            return "Error: " + ce.getMessage();
        }
    }

}
