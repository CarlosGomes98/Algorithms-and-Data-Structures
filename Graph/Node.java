import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Node<K extends Comparable <K>>{
    private K value;
    private List<Node<K>> connections = new ArrayList<Node<K>>();

    public Node(K value){
        this.value = value;
    }

    public void addConnection(List<K> nodeList){
        for (K node : nodeList) {
            connections.add(new Node<K>(node));
        }
    }

    public void addConnection(K node){
        connections.add(new Node<K>(node));
    }

    public List<Node<K>> getConnections(){
        return connections;
    } 

    public K getValue(){
        return value;
    }

    public Node<K> setValue(K value){
        this.value = value;
        return this;
    }

    public String toString(){
        return value.toString();
    }

    public boolean DFS(K value){
        Stack<Node<K>> stack = new Stack<Node<K>>();
        stack.add(this);

        while(!stack.empty()){
            Node<K> current = (Node<K>) stack.pop();

            if(current.getValue().compareTo(value) == 0){
                return true;
            }

            for(Node<K> node : current.getConnections()){
                stack.add(node);
            }
        }
        return false;

    }

    public boolean BFS(K value){
        Queue<Node<K>> queue = new LinkedList<Node<K>>();
        queue.add(this);

        while(!queue.isEmpty()){
            Node<K> current = (Node<K>) queue.remove();

            if(current.getValue().compareTo(value) == 0){
                return true;
            }

            for(Node<K> node : current.getConnections()){
                queue.add(node);
            }
        }
        return false;
    }

    public void printGraph(){
        Queue<Node<K>> queue = new LinkedList<Node<K>>();
        queue.add(this);

        while(!queue.isEmpty()){
            Node<K> current = (Node<K>) queue.remove();

            System.out.println("Node: " + current.value);
            System.out.println("Connected to: " + current.connections);
            
            for(Node<K> node : current.getConnections()){
                queue.add(node);
            }
        }

    }
}