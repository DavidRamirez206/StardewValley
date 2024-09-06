package structures;

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
            if(first.getNext() == null) {
                first.setNext(nodeChest);
            } else {
                NodeChest current = first;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(nodeChest);
            }
        }
    }

    public NodeChest search(String id){
        NodeChest nodeFound= null;

        if (first != null && first.getId().equals(id)) {
            nodeFound = first;
        } else {
            NodeChest current = first;
            while (current.getNext() != null && !current.getId().equals(id)) {
                if (current.getNext().getId().equals(id)) {
                    nodeFound = current;
                    break;
                }
                current = current.getNext();
            }
        }

        if (nodeFound != null){
            return nodeFound;
        } else {
            throw new NullPointerException("the chest was not found");
        }
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