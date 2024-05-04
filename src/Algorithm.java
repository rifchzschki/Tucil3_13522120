import java.util.*;
public class Algorithm {
    private List<Node> visited;
    private PriorityQueue<NodeCostPair> pQueue;
    private String name;

    // constructor
    public Algorithm(String name){
        pQueue = new PriorityQueue<>();
        visited = new ArrayList<>();
        this.name = name;
    }

    // calculate cost UCS
    public int costUCS(NodeCostPair parent, boolean isFirst){
        if(isFirst){
            return 1;
        }else{
            return parent.getCost()+1;
        }
    }

    // calculate cost GBFS
    public int costGBFS(Node currentNode, String target, boolean isFirst){
        if(isFirst){
            return currentNode.getWord().length();
        }else{
            int dif=0;
            for (int i = 0; i < currentNode.getWord().length(); i++) {
                if(currentNode.getWord().charAt(i)!=target.charAt(i)){
                    dif++;
                }
            }
            return dif;
        }
    }

    // calculate cost
    public int calculateCost(Node currentNode, NodeCostPair parent, Node neighbor, String target, boolean isFirst){
        if(name.equalsIgnoreCase("gbfs")){
            return costGBFS(neighbor, target, isFirst);
        }else if(name.equalsIgnoreCase("ucs")){
            return costUCS(parent, isFirst);
        }else{
            return costUCS(parent, isFirst) + costGBFS(currentNode, target, isFirst);
        }
        
    }

    // Algoritma pencarian rute 
    public List<String> routeSearch(Graph g, String start, String target){
        Node startNode = g.get(start);
        Node targetNode = g.get(target);
        Map<Node, Node> parentMap = new HashMap<>();
        if (startNode == null || targetNode == null) {
            return null;
        }
        visited.add(startNode);
        for (Node node : startNode.getConnected()) {
            int cost = calculateCost(node, null, node, target, true);
            pQueue.add(new NodeCostPair(node, cost));
            parentMap.put(node, startNode);
        }
        while(!pQueue.isEmpty()){
            NodeCostPair current = pQueue.poll();
            // System.err.println("current: "+ current.getNode().getWord()+ ", cost: "+ current.getCost());
            if(visited.contains(current.getNode())){
                continue;
            }
            visited.add(current.getNode());
            if(target.equals(current.getNode().getWord())){
                List<String> res= getPathList(buildPath(parentMap, targetNode));
                return res;
            }
            for (Node node : current.getNode().getConnected()) {
                int cost = calculateCost(current.getNode(), current, node, target, false);
                pQueue.add(new NodeCostPair(node, cost));
                if(!visited.contains(node) && parentMap.get(node)==null){
                    parentMap.put(node, current.getNode());
                }
            }
            
        }
        return null;

    }

    // Metode untuk membangun jalur dari titik awal ke titik target
    public List<Node> buildPath(Map<Node, Node> parentMap, Node target) {
        List<Node> path = new ArrayList<>();
        Node current = target;

        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    public List<String> getPathList(List<Node> path){
        List<String> pathList = new ArrayList<>();
        for (Node node : path) {
            pathList.add(node.getWord());
        }
        return pathList;
    }

    public List<String> getVisitedList(){
        List<String> visitedList = new ArrayList<>();
        for (Node node : visited) {
            visitedList.add(node.getWord());
        }
        return visitedList;
    }
}


