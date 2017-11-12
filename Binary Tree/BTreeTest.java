import java.lang.IllegalArgumentException;
public class BTreeTest{
    public static void main(String[] args) {
        if (args.length < 2){
            throw new IllegalArgumentException("The tree needs at least one node and a transversal order!");
        }
        
        BTreeNode.Order transverseMode = parseTransverseMode(args[args.length - 1]);

        BTreeNode<Integer> root = new BTreeNode<Integer>(Integer.parseInt(args[0]));
        for (int i = 1; i < args.length - 1; i++){
            root.add(Integer.parseInt(args[i]));
        }
        System.out.println(root.transverse(transverseMode));
    }

    private static BTreeNode.Order parseTransverseMode (String mode){
        switch (mode) {
            case "in":
                return BTreeNode.Order.IN;
                //break;
            case "pre":
                return BTreeNode.Order.PRE;
                //break;
            case "post":
                return BTreeNode.Order.POST;
                //break;    
            default:
                throw new IllegalArgumentException(mode + " is not a valid transverse mode!");
                //break;
        }

    }
}