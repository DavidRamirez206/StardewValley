package model;

public class Chest {
    private String chestNumber;
    private Stack firstStack;

    public Chest(String chestNumber) {
        this.chestNumber = chestNumber;
        this.firstStack = null;
    }

    public Chest(){
    }

    public String getChestNumber() {
        return chestNumber;
    }

    public Stack getStack(){
        return firstStack;
    }

    public void setChestNumber(String chestNumber) {
        this.chestNumber = chestNumber;
    }

    public void setStack(Stack firstStack){
        this.firstStack = firstStack;
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

    public Stack searchStack(String id){
        Stack current = null;
        if(firstStack == null){
            throw new IllegalArgumentException ("This chest is empty. First create a stack");
        } else {
            if (firstStack.getId().equals(id)){
                current = firstStack;
            } else {
                Stack tempStack = firstStack;
                while (!tempStack.getId().equals(id) || tempStack.getNextStack() != null) {
                    tempStack = tempStack.getNextStack();
                    if (tempStack.getId().equals(id)){
                        current = tempStack;
                    }
                }
            }
        }

        if (current != null) {
            return current;
        } else {
            throw new IllegalArgumentException ("stack not found");
        }
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

    public void addCrop(String name, int optionSeason, int growthTime, String idStack){
        searchStack(idStack).add(name, optionSeason, growthTime);
    }

    @Override
    public String toString(){
        return "chest number: " + chestNumber +
                "\nStack: " + firstStack;
    }

}
