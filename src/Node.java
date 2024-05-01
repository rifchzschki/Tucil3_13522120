import java.util.ArrayList;
import java.util.List;

// Definisikan kelas Node
public class Node {
    private String kata;
    private List<Node> neighbors;

    // Konstruktor
    public Node(String kata) {
        this.kata = kata;
        this.neighbors = new ArrayList<>();
    }

    // Getter dan setter untuk kata
    public String getData() {
        return kata;
    }

    public void setData(String kata) {
        this.kata = kata;
    }

    // Getter untuk tetangga (neighbors)
    public List<Node> getNeighbors() {
        return neighbors;
    }

    // Method untuk menambahkan tetangga baru
    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }
}
