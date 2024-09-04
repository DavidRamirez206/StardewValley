package structures;

import model.Crop;

public class NodeCrop {

    private String name;
    private String cropType;
    private int growthTime;
    private Crop crop;

    private NodeCrop next;

    public NodeCrop(String name, String cropType, int growthTime, Crop crop) {
        this.name = name;
        this.cropType = cropType;
        this.growthTime = growthTime;
        this.crop = crop;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public String getCropType() {
        return cropType;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public Crop getCrop() {
        return crop;
    }

    public NodeCrop getNext() {
        return next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public void setNext(NodeCrop next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeCrop{" +
                "name='" + name + '\'' +
                '}';
    }
}
