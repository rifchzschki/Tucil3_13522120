// Kelas untuk menyimpan pasangan node dan cost
public class NodeCostPair implements Comparable<NodeCostPair> {
    private Node node;
    private int cost;

    // constructor
    public NodeCostPair(Node node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    // getter node
    public Node getNode(){
        return node;
    }

    // getter cost
    public int getCost(){
        return cost;
    }
    // setter cost
    public void setCost(int cost){
        this.cost = cost;
    }

    // Implementasi metode compareTo untuk membandingkan pasangan berdasarkan cost
    @Override
    public int compareTo(NodeCostPair other) {
        return Integer.compare(this.cost, other.cost);
    }
}