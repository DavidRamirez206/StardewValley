package model;

import structures.SimpleLinkedListCrop;

public class Stack {
    private SimpleLinkedListCrop crops;
    private String stackID;

    private Stack nextStack;

    public Stack(String stackID){
        crops = new SimpleLinkedListCrop();
        this.stackID = stackID;
        nextStack = null;
    }

    public SimpleLinkedListCrop getCrops() {
        return crops;
    }

    public String getId(){
        return stackID;
    }

    public Stack getNextStack() {
        return nextStack;
    }

    public void setCrops(SimpleLinkedListCrop crops) {
        this.crops = crops;
    }

    public void setId(String stackID){
        this.stackID = stackID;
    }

    public void setNextStack(Stack nextStack) {
        this.nextStack = nextStack;
    }


    public void add(String name, int optionSeason, int growthTime) {
        Crop crop;
    
        switch (optionSeason) {
            case 1: // Spring
                crop = new SpringCrop(name, optionSeason, growthTime);
                break;
            case 2: // Summer
                crop = new SummerCrop(name, optionSeason, growthTime);
                break;
            case 3: // Fall
                crop = new FallCrop(name, optionSeason, growthTime);
                break;
            case 4: // Winter
                crop = new WinterCrop(name, optionSeason, growthTime);
                break;
            case 5: //Other
                crop = new OtherCrop(name, optionSeason, growthTime);
            default:
                // 
                throw new IllegalArgumentException("Invalid season option: " + optionSeason);
        }

        crops.add(name, crop);
    }

    public String stackType(){
        return crops.type();
    }

    @Override
    public String toString(){
        return "Crops: " + crops +
                "\nID: " + stackID +
                "\nNext Stack: " + nextStack; 
    }
    
}
