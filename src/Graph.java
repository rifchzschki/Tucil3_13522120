import java.util.ArrayList;
import java.util.List;

// Definisikan kelas Graph
public class Graph {
    private List<Node> nodes;

    // Konstruktor
    public Graph() {
        this.nodes = new ArrayList<>();
    }

    // Getter untuk nodes
    public List<Node> getNodes() {
        return nodes;
    }

    // Method untuk menambahkan node baru ke dalam graf
    public void addNode(Node node) {
        this.nodes.add(node);
    }
}
