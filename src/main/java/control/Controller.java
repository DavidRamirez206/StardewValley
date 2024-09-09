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
        } else {
            season = 4;
        }
        return season;
    }


    public Season getCurrentSeason() {
        return currentSeason;
    }
 
    public void createChest(String chestNumber, String typeChest){
        Chest chest = new Chest(chestNumber, typeChest);
        chests.add(chestNumber, chest);
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
    
            if (chest.stackSize() <= 50) { 
                chest.createStack(stackID);
                return "Stack added successfully to chest: " + chestID;
            } else {
                return "You cannot add more stacks to this chest.";
            }
        } catch (ChestException se) {
            return "Error: " + se.getMessage();
        }
    }
    
    

    public String addCropToStack(String chestNumber, String stackId, String cropName, int seasonOption, int growthTime) {
        try {
            Chest chest = chests.search(chestNumber).getChest();    
            Stack stack = chest.searchStack(stackId);
            int size = stack.getCrops().size();
    
            String stackType = stack.stackType();
            String chesType = chest.getTypeChest();

            if(chesType.equalsIgnoreCase("GENERAL")){
                if(stackType == null){
                    stack.add(cropName, seasonOption, growthTime);
                    return "Crop added successfully to stack: " + stackId;
                } else if(stackType.equalsIgnoreCase(cropName) && size <= 25){
                    stack.add(cropName, seasonOption, growthTime);
                    return "Crop added successfully to stack: " + stackId;
                }
            } else {
                if(stackType == null){
                    if(chesType.equalsIgnoreCase(cropName)){
                        stack.add(cropName, seasonOption, growthTime);
                        return "Crop added successfully to stack: " + stackId;
                    }
                } else {
                    if(chesType.equalsIgnoreCase(cropName) && size <= 25){
                        stack.add(cropName, seasonOption, growthTime);
                        return "Crop added successfully to stack: " + stackId;
                    }
                }
            }

            return "You cannot add this crop to this stack: You have attempted to add a crop of a different type or the stack is full. " +
                    "\nIf the chest is of only one type, remember that you can only add crops of that same type.";
    
        } catch (ChestException ce) {
            return "Error: " + ce.getMessage();
        } catch (StackException se) {
            return "Error: " + se.getMessage();
        }
    }

}
