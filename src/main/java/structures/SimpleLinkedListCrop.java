package structures;

import model.Crop;

public class SimpleLinkedListCrop {
    private NodeCrop first;

    public SimpleLinkedListCrop() {
        this.first = null;
    }

    public void add(String name, Crop crop){
        NodeCrop node = new NodeCrop(name, crop);

        if (first == null){
            first = node;
        } else {
            NodeCrop current = first;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
        }
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
