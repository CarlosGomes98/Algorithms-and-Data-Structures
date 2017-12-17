import java.util.Arrays;
import java.util.Scanner;

public class TestGraph{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Node<Integer> graph = new Node<Integer>(20);

        graph.addConnection(Arrays.asList(30, 40, 50));
        graph.getConnections().get(1).addConnection(45);
        graph.printGraph();
        System.out.println(graph.DFS(scan.nextInt()));
        System.out.println(graph.BFS(scan.nextInt()));
    }
}