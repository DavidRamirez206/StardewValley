package structures;

import Exceptions.ChestException;
import model.Chest;

public class SimpleLinkedListChest {

    private NodeChest first;

    public SimpleLinkedListChest(){
        this.first = null;
    }

    public void add(String id, Chest chest){
        NodeChest nodeChest = new NodeChest(id, chest);

        if(first == null){
            first = nodeChest;
        } else {
            NodeChest current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(nodeChest);
        }
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
    

    public int size(){
        int size = 0;

        if(first != null){
            size = 1;
            
            NodeChest current = first;
            while (current.getNext() != null) {
                size += 1;
                current = current.getNext();
            }
        }
        return size;
    }

    public NodeChest getFirst(){
        return first;
    }
}