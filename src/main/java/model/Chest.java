package model;

public class Chest {
    private String chestNumber;
    private ChestCategory category;
    private Crop crop;

    public Chest(String chestNumber, ChestCategory category, Crop crop, Chest next) {
        this.chestNumber = chestNumber;
        this.category = category;
        this.crop = crop;
    }
    

    public Chest(String chestNumber) {
        this.chestNumber = chestNumber;
        this.category = null;
        this.crop = null;
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

    public void setChestNumber(String chestNumber) {
        this.chestNumber = chestNumber;
    }

    public void setCategory(ChestCategory category) {
        this.category = category;
    }    

    public void setCrop(Crop crop){
        this.crop = crop;
    }



    @Override
    public String toString(){
        return "chest number: " + chestNumber +
                "\nCategory: " + category +
                "\nCrop: " + crop;
    }
}
