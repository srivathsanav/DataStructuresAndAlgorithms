import java.util.*;

/**
 * Created by avsrivathsan on 6/21/2017.
 */
public class CloneGraph {
        private GraphNode cloneGraph(GraphNode source) {
        Map<GraphNode, GraphNode> nodeGraphNodeMap = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(source);
        nodeGraphNodeMap.put(source, new GraphNode(source.label));

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            for (GraphNode node : current.getEdges()) {
                if (nodeGraphNodeMap.containsKey(node)) {
                    nodeGraphNodeMap.put(node, new GraphNode(node.label));
                }
                nodeGraphNodeMap.get(current).edges.add(nodeGraphNodeMap.get(node));
            }
        }
        return nodeGraphNodeMap.get(source);
    }
    public static void main(String[] args) {

    }

    class GraphNode {
        int label;
        List<GraphNode> edges;

        public GraphNode(int label) {
            this.label = label;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public List<GraphNode> getEdges() {
            return edges;
        }

        public void setEdges(List<GraphNode> edges) {
            this.edges = edges;
        }
    }
}
