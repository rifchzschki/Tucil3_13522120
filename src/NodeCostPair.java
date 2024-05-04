// Kelas untuk menyimpan pasangan node dan cost
public class NodeCostPair implements Comparable<NodeCostPair> {
    private Node node;
    private int cost;

    public NodeCostPair(Node node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public Node getNode(){
        return node;
    }

    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    }

    // Implementasi metode compareTo untuk membandingkan pasangan berdasarkan cost
    @Override
    public int compareTo(NodeCostPair other) {
        return Integer.compare(this.cost, other.cost);
    }
}