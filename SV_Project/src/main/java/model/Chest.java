package model;

public class Chest {
    private int chestNumer;
    private ChestCategory category;
    private Crop crop;

    public Chest(){
    }

    public Chest(int chestNumer, ChestCategory category, Crop crop) {
        this.chestNumer = chestNumer;
        this.category = category;
        this.crop = crop;
    }

    public int getChestNumer() {
        return chestNumer;
    }

    public ChestCategory getCategory() {
        return category;
    }

    public Crop getCrop(){
        return crop;
    }

    public void setChestNumer(int chestNumer) {
        this.chestNumer = chestNumer;
    }

    public void setCategory(ChestCategory category) {
        this.category = category;
    }    

    public void setCrop(Crop crop){
        this.crop = crop;
    }
}
