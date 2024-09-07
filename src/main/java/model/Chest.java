package model;
import Exceptions.*;

public class Chest {
    private String chestNumber;
    private Stack firstStack;
    private String typeChest;

    public Chest(String chestNumber, String typeChest) {
        this.chestNumber = chestNumber;
        this.firstStack = null;
        this.typeChest = typeChest;
    }

    public Chest(){
    }

    public String getChestNumber() {
        return chestNumber;
    }

    public Stack getStack(){
        return firstStack;
    }

    public String getTypeChest(){
        return typeChest;
    }

    public void setChestNumber(String chestNumber) {
        this.chestNumber = chestNumber;
    }

    public void setStack(Stack firstStack){
        this.firstStack = firstStack;
    }

    public void setTypeChest(String typeChest){
        this.typeChest = typeChest;
    }

    public void createStack(String id){
        Stack stack = new Stack(id);
        if(firstStack == null){
            firstStack = stack;
        } else {
            Stack currenStack = firstStack;
            while (currenStack.getNextStack() != null) {
                currenStack = currenStack.getNextStack();
            }
            currenStack.setNextStack(stack);
        }
    }

    public Stack searchStack(String id) throws StackException {
        if (firstStack == null) {
            throw new StackException("This chest is empty. First create a stack.");
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
    
    

    public int stackSize(){
        int size = 0;

        if(firstStack != null){
            size = 1;
            
            Stack current = firstStack;
            while (current.getNextStack() != null) {
                size += 1;
                current = current.getNextStack();
            }
        }
        return size;
    }

    @Override
    public String toString(){
        return "chest number: " + chestNumber +
                "\nStack: " + firstStack;
    }

}
