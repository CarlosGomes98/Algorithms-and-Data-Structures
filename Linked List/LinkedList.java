public class LinkedList<K extends Comparable<K>>{
    
    private Node<K> head;
    private int length;

    public LinkedList(){
        this.head = null;
        this.length = 0;
    }

    public boolean has(K value){
        Node<K> current = head;
        while(current != null){
            if(current.getValue().equals(value))
                return true;
            current = current.getNext();
        }
        //if not found
        return false;
    }

    public void insertOrdered(K value){
        Node<K> insertPoint = head;
        int index = 0;
        while(insertPoint != null && value.compareTo(insertPoint.getValue()) > 0){
            insertPoint = insertPoint.getNext();
            index++;
        }
        insert(value, index);
    }
    public void insert(K value, int index){
        
        Node<K> node = new Node<K>(null, value);
        
        //go to the end of the linked list
        Node<K> end = head;
        
        if(index > length){
            System.out.println("Oops! " + index + " is bigger than the length of the list! Working with " + length);
            index = length;
        }

        if(index == 0){
            node.setNext(head);
            head = node;
        }
        else{
            Node<K> preInsert = head;

            for(int i = 1; i < index; i++)
                preInsert = preInsert.getNext();
            
            node.setNext(preInsert.getNext());
            preInsert.setNext(node);
        }
        length++;
        print();
    }

    public void print(){
        Node<K> current = head;
        
        System.out.println("Current state of the list");
        
        while(current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}
    
