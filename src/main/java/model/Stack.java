package model;

import Exceptions.StackException;
import structures.SimpleLinkedListCrop;

public class Stack {
    private SimpleLinkedListCrop crops;
    private String stackID;
    private Stack nextStack;

    private int size;
    private static final int MAX_CROPS = 2;

    public Stack(String stackID){
        crops = new SimpleLinkedListCrop();
        this.stackID = stackID;
        nextStack = null;
        size = 0;
    }

    public Stack(){}

    public SimpleLinkedListCrop getCrops() {
        return crops;
    }

    public String getId(){
        return stackID;
    }

    public Stack getNextStack() {
        return nextStack;
    }

    public int getSize(){
        return size;
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

    public void setSize(int size){
        this.size = size;
    }


    public String add(String name, int optionSeason, int growthTime) {
        Crop crop = new Crop(name, optionSeason, growthTime);

        if(size < MAX_CROPS ){
            if(stackType() == null){
                crops.add(name, crop);
                size++;
            } else {
                if(stackType().equalsIgnoreCase(name)){
                    crops.add(name, crop);
                    size++;
                }
            }
            return "Crop added";
        } else {
            return "Stack is full";
        }
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
