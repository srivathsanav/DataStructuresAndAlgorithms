import java.util.*;

/**
 * Created by avsrivathsan on 2/14/2017.
 */
public class GraphNode {

    private int id;

    private LinkedList<GraphNode> adjacentNodes = new LinkedList<>();

    public int getId() {
        return id;
    }

    public GraphNode(int id) {
        this.id = id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public LinkedList<GraphNode> getNodes() {
        return adjacentNodes;
    }

    public void setNodes(LinkedList<GraphNode> nodes) {
        this.adjacentNodes = nodes;
    }

    public GraphNode getNode(int nodeId) {
        for (GraphNode graphNode : adjacentNodes) {
            if (nodeId == graphNode.getId()) {
                return graphNode;
            }
        }
        return null;
    }

    public void addEdge(int source, int  destination) {
        GraphNode sourceNode = getNode(source);
        GraphNode destinationNode = getNode(destination);
        sourceNode.adjacentNodes.add(destinationNode);
    }

    public boolean hasPathDFS(int source, int destination) {
        GraphNode sourceNode = getNode(source);
        GraphNode destinationNode = getNode(destination);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFSSearch(sourceNode, destinationNode, visited);
    }

    private boolean hasPathDFSSearch(GraphNode sourceNode, GraphNode destinationNode, Set<Integer> visited) {
            if (visited.contains(sourceNode)) {
                return false;
            }
            visited.add(sourceNode.getId());
            if (sourceNode.equals(destinationNode)) {
                return true;
            }
            for (GraphNode adjacentNode : sourceNode.getNodes()) {
                if (hasPathDFSSearch(adjacentNode, destinationNode, visited)) {
                    return true;
                }
            }
            return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        GraphNode sourceNode = getNode(source);
        GraphNode destinationNode = getNode(destination);
        return hasPathBFSSearch(sourceNode, destinationNode);
    }

    private boolean hasPathBFSSearch(GraphNode sourceNode, GraphNode destinationNode) {
        Set<Integer> visited = new HashSet<>();

        LinkedList<GraphNode> nodes = new LinkedList<>();
        nodes.add(sourceNode);
        while (!nodes.isEmpty()) {
            GraphNode currentNode = nodes.poll();
            if (currentNode.equals(destinationNode)) {
                return true;
            }
            if (visited.contains(currentNode)) {
                continue;
            }
            visited.add(sourceNode.getId());
            for (GraphNode adjacentNode : currentNode.adjacentNodes) {
                nodes.add(adjacentNode);
            }
        }
        return false;
    }

}
