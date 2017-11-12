public class Node<K>{
    
    private Node<K> next;
    private K value;

    public Node(Node<K> next, K value){
        this.next = next;
        this.value = value;
    }

    public Node<K> getNext(){
        return next;
    }

    public void setNext(Node<K> next){
        this.next = next;
    }

    public K getValue(){
        return value;
    }
}