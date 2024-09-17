package structures;

import model.Chest;

public class NodeChest {
    private String id;
    private Chest chest;
    private int index;

    private NodeChest next;

    public NodeChest(String id, Chest chest) {
        this.id = id;
        this.chest = chest;
        this.next = null;
        this.index = 0;
    }

    public String getId() {
        return id;
    }

    public Chest getChest() {
        return chest;
    }

    public NodeChest getNext() {
        return next;
    }

    public int getIndex() {
        return index;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public void setNext(NodeChest next) {
        this.next = next;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "NodeChest{" +
                "id='" + id + '\'' +
                '}';
    }
}
