package model;
import Exceptions.*;

public class Chest {
    private String chestID;
    private Stack firstStack;
    private String chestType;

    private int size = 0;
    
    private static final int MAX_STACKS = 2;

    public Chest(String chestID, String chestType) {
        this.chestID = chestID;
        this.firstStack = null;
        this.chestType = chestType;
    }

    public Chest(){
    }

    public String getChestNumber() {
        return chestID;
    }

    public Stack getStack(){
        return firstStack;
    }

    public String getTypeChest(){
        return chestType;
    }

    public void setChestNumber(String chestID) {
        this.chestID = chestID;
    }

    public void setStack(Stack firstStack){
        this.firstStack = firstStack;
    }
    public void setTypeChest(String chestType){
        this.chestType = chestType;
    }

    public String createStack(String id){
        Stack stack = new Stack(id);

        if (size < MAX_STACKS) {
            if(firstStack == null){
                firstStack = stack;
            } else {
                if(firstStack.getNextStack() == null){
                    firstStack.setNextStack(stack);
                } else {
                    Stack currenStack = firstStack.getNextStack();
                    while (currenStack.getNextStack() != null) {
                        currenStack = currenStack.getNextStack();
                    }
                    currenStack.setNextStack(stack);
                }
            }
            this.size++;
            return "Stack added successfully to chest";
        } else {
            return "You cannot add more stacks to this chest.";
        }
    }

    public Stack searchStack(String id) throws StackException {
        if (firstStack == null) {
            throw new StackException("This chest is empty. First create a stack.");
        }

        if(firstStack.getId().equalsIgnoreCase(id)){
            return firstStack;
        }
        Stack tempStack = firstStack;
        while (tempStack != null) {
            if (tempStack.getId().equals(id)) {
                return tempStack;
            }
            tempStack = tempStack.getNextStack();
        }
    
        throw new StackException("Stack with ID '" + id + "' not found.");
    }

    @Override
    public String toString(){
        return "\nChest number: " + chestID +
                "\nStack: " + firstStack +
                "\nType: " + chestType +
                "\nSize: " + size;
    }

}
