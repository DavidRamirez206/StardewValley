package structures;

import model.Crop;

public class SimpleLinkedListCrop {
    private NodeCrop first;
    private int size;

    public SimpleLinkedListCrop() {
        this.first = null;
        this.size = 0;
    }

    public void add(String name, Crop crop){
        NodeCrop node = new NodeCrop(name, crop);

        if (first == null){
            first = node;
        } else {
            if(first.getNext() == null){
                first.setNext(node);
                first.getNext().setIndex(size);
            } else {
                NodeCrop current = first;
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
                current.setIndex(size);
            }
        }
        size++;
    }

    public NodeCrop search(String name){

        NodeCrop nodeFound = null;
        if (first != null && first.getName().equals(name)){
            nodeFound = first;
        } else {
            NodeCrop current = first;
            while (current.getNext() != null && !current.getName().equals(name)){
                if (current.getName().equals(name)){
                    nodeFound = current;
                    break;
                }
                current = current.getNext();
            }
        }
        return nodeFound;
    }

    public int size(){
        int size = 0;

        if(first != null){
            size = 1;
            
            NodeCrop current = first;
            while (current.getNext() != null) {
                size += 1;
                current = current.getNext();
            }
        }
        return size;
    }

    public NodeCrop getFirst(){
        return first;
    }

    public String type() {
        if (first == null) {
            return null;
        }
        return first.getName();
    }
}
