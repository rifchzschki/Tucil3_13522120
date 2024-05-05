import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Graph {
    Map<String, Node> nodes;

    // constructor
    public Graph() {
        this.nodes = new HashMap<>();
    }

    // add connection two word and put in graph
    public void add(String word1, String word2) {
        Node node1 = this.nodes.getOrDefault(word1, new Node(word1));
        Node node2 = this.nodes.getOrDefault(word2, new Node(word2));
        node1.addConnected(node2);
        node2.addConnected(node1);
        node2.setParent(node1);
        this.nodes.put(word1, node1);
        this.nodes.put(word2, node2);
    }

    // getter nodes
    public Node get(String word) {
        return this.nodes.get(word);
    }

    // save graph to txt file in csv format
    public void saveToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Map.Entry<String, Node> entry : nodes.entrySet()) {
                String word = entry.getKey();
                Node node = entry.getValue();
                for (Node connectedNode : node.getConnected()) {
                    String line = word + "," + connectedNode.getWord() + "\n";
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // load graph from txt
    public static Graph readFromCSV(String filename) {
        Graph graph = new Graph();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String word1 = parts[0];
                String word2 = parts[1];

                graph.add(word1, word2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }

    // build graph from dictionary
    public static Graph buildGraph(int length, List<String> dict){
        Graph graph = new Graph();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
        for (String word : dict) {
            executor.execute(() -> {
                if (word.length() == length) {
                    for (int i = 0; i < length; i++) {
                        for (int alp = 0; alp < 26; alp++) {
                            String current = word.substring(0, i) + (char) (97 + alp) + word.substring(i + 1);
                            if (dict.contains(current) && !current.equalsIgnoreCase(word)) {
                                graph.add(word, current);
                                System.out.println(word);
                            }
                        }
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Tunggu semua proses konkuren selesai
        }
        return graph;
    }   

    // print graph for checking
    public void printGraph() {
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            String word = entry.getKey();
            Node node = entry.getValue();
            System.out.print(word + " is connected to: ");
            for (Node connectedNode : node.getConnected()) {
                System.out.print(connectedNode.getWord() + " ");
            }
            System.out.println();
        }
    }
}
