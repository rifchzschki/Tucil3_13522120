import java.util.List;
import java.util.ArrayList;
public class Node {
    private Node parent;
    private String word;
    private List<Node> connected;

    public Node(String word) {
        this.word = word;
        this.connected = new ArrayList<>();
    }

    public void addConnected(Node node) {
        this.connected.add(node);
    }

    // Metode untuk menetapkan parent dari node
    public void setParent(Node parent) {
        this.parent = parent;
    }

    // Metode untuk mendapatkan parent dari node
    public Node getParent() {
        return parent;
    }

    public String getWord(){
        return word;
    }

    public List<Node> getConnected(){
        return connected;
    }
}