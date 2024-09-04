package structures;

import model.Chest;

public class NodeChest {
    private String id;
    private Chest chest;

    private NodeChest next;

    public NodeChest(String id, Chest chest) {
        this.id = id;
        this.chest = chest;
        this.next = null;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public void setNext(NodeChest next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeChest{" +
                "id='" + id + '\'' +
                '}';
    }
}
