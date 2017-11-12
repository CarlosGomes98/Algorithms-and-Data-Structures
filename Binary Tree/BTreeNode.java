import java.util.ArrayList;

public class BTreeNode<T extends Comparable<T>> implements Comparable<BTreeNode<T>>{
    private T value;
    private BTreeNode<T> left;
    private BTreeNode<T> right;
    
    public static enum Order{IN, PRE, POST};

    //create node with two children (may be null)
    public BTreeNode(T value, BTreeNode<T> left, BTreeNode<T> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    //create node with no children
    public BTreeNode(T value){
        this(value, null, null);
    }

    public T getValue(){
        return value;
    }

    public BTreeNode<T> getLeft(){
        return left;
    }

    public BTreeNode<T> getRight(){
        return right;
    }

    @Override
    public int compareTo(BTreeNode<T> other){
        return value.compareTo(other.getValue());
    }

    
    public BTreeNode<T> add(T value){
        BTreeNode<T> current = this;
        if (value.compareTo(this.value) < 0){
            if(current.getLeft() == null){
                BTreeNode<T> node = new BTreeNode<T>(value);
                current.left = node;
                return node;
            }
            current.getLeft().add(value);
        }
        else{
            if(current.getRight() == null){
                BTreeNode<T> node = new BTreeNode<T>(value);
                current.right = node;
                return node;
            }
            current.getRight().add(value);
        }
        return null;
    }

    public ArrayList<T> transverse(Order order){
        ArrayList<T> result = new ArrayList<T>();
        switch (order) {
            case IN:
                inOrder(this, result);
                break;
            case PRE:
                preOrder(this, result);
                break;
            case POST:
                postOrder(this, result);
        }
        return result;
    }

    private void inOrder(BTreeNode<T> node, ArrayList<T> result){
        if(node != null){
            inOrder(node.getLeft(), result);
            result.add(node.getValue());
            inOrder(node.getRight(), result);
        }
    }

    private void preOrder(BTreeNode<T> node, ArrayList<T> result) {
        if (node != null) {
            result.add(node.getValue());
            preOrder(node.getLeft(), result);
            preOrder(node.getRight(), result);
        }
    }
    
    private void postOrder(BTreeNode<T> node, ArrayList<T> result) {
        if (node != null) {
            postOrder(node.getLeft(), result);
            postOrder(node.getRight(), result);
            result.add(node.getValue());
        }
    }
}