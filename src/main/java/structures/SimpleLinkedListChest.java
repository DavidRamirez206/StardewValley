package structures;

import Exceptions.ChestException;
import model.Chest;

public class SimpleLinkedListChest {

    private NodeChest first;

    private int size;

    public SimpleLinkedListChest(){
        this.first = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(String id, Chest chest){
        NodeChest nodeChest = new NodeChest(id, chest);

        if(first == null){
            first = nodeChest;
        } else {
            if(first.getNext() == null){
                first.setNext(nodeChest);
                first.getNext().setIndex(size);
            } else {
                NodeChest temp = first;
                while(temp.getNext() != nodeChest){
                    temp = temp.getNext();
                }
                temp.setNext(nodeChest);
                temp.getNext().setIndex(size);
            }
        }
        size++;
    }

    public NodeChest search(String id) throws ChestException {
        if (first == null) {
            throw new ChestException("There is no chest. First create one.");
        }
    
        NodeChest current = first;
        while (current != null) {
            if (current.getId().equalsIgnoreCase(id)) {
                return current; 
            }
            current = current.getNext();
        }
    
        throw new ChestException("Chest with ID '" + id + "' not found.");
    }

    public NodeChest getFirst(){
        return first;
    }
}