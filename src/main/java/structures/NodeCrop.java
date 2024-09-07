package structures;

import model.Crop;

public class NodeCrop {

    private String name;
    private Crop crop;

    private NodeCrop next;

    public NodeCrop(String name, Crop crop) {
        this.name = name;
        this.crop = crop;
        this.next = null;
    }

    public String getName() {
        return name;
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
