package model;
import Exceptions.*;

public class Chest {
    private String chestID;
    private Stack firstStack;
    private String chestType;

    private int size = 0;
    
    private static final int MAX_STACKS = 3;

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

    public void sortingChestByOption(int sortOption){
        Stack sortedStack = null; // Stack that will contain the ordered elements
        Stack currentStack = firstStack; // Stack original

        while (currentStack != null) {
            Stack minNode = currentStack; // Smallest node
            Stack prevMinNode = null; // Node before minimum
            Stack prevNode =null; // Node before the current node
            Stack searchStack = currentStack; //Stack to find the node with the smallest name

            // Find the smallest node in the rest of the list
            while (searchStack != null) {
                if (searchStack.compareByOption(minNode, sortOption) > 0) {
                    minNode = searchStack;
                    prevMinNode = prevNode;
                }
                prevNode = searchStack;
                searchStack = searchStack.getNextStack();
            }

            // Remove the minimum node from the original list
            if (prevMinNode != null) {
                prevMinNode.setNextStack(minNode.getNextStack());
            } else {
                currentStack = minNode.getNextStack(); // Move the start if the minimum was the first node
            }

            // Insert the minimum node to the top of the sorted stack
            minNode.setNextStack(sortedStack);
            sortedStack = minNode;
        }

        // Update the original stack with the sorted stack
        setStack(sortedStack);
    }

    @Override
    public String toString(){
        return "\nChest number: " + chestID +
                "\nType: " + chestType +
                "\nSize: " + size +
                "\nStacks: " + firstStack.toString();
    }

}
