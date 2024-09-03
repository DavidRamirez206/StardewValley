package model;

public class Chest {
    private String chestNumber;
    private ChestCategory category;
    private Crop crop;
    ///Our node for the linkedList :)
    private Chest next;

    public Chest(String chestNumber, ChestCategory category, Crop crop, Chest next) {
        this.chestNumber = chestNumber;
        this.category = category;
        this.crop = crop;
        this.next = next;
    }
    

    public Chest(String chestNumber) {
        this.chestNumber = chestNumber;
        this.category = null;
        this.crop = null;
        this.next = null;
    }

    public Chest(){
    }

    public String getChestNumber() {
        return chestNumber;
    }

    public ChestCategory getCategory() {
        return category;
    }

    public Crop getCrop(){
        return crop;
    }

    public Chest getNext() {
        return next;
    }

    public void setChestNumber(String chestNumber) {
        this.chestNumber = chestNumber;
    }

    public void setCategory(ChestCategory category) {
        this.category = category;
    }    

    public void setCrop(Crop crop){
        this.crop = crop;
    }


    public void setNext(Chest next) {
        this.next = next;
    }

    @Override
    public String toString(){
        return "chest number: " + chestNumber +
                "\nCategory: " + category +
                "\nCrop: " + crop +
                "\n next Chest: " + next;
    }
}
