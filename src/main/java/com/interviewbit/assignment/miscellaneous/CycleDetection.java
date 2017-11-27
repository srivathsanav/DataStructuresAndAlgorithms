import java.util.List;

/**
 * Created by avsrivathsan on 6/21/2017.
 */
public class CycleDetection {

    private boolean detectCycle(GraphNode source) {
        if (source.color == COLOR.BLACK) {
            return false;
        }
        source.color = COLOR.GREY;
        for (GraphNode currentNode : source.edges) {
            if (currentNode.color == COLOR.GREY) {
                return true;
            }
            if (detectCycle(currentNode)) {
                return true;
            }
        }
        source.color = COLOR.BLACK;
        return false;
    }


    enum COLOR {
        BLACK, GREY, WHITE;
    }
    class GraphNode {
        int label;
        COLOR color;
        List<GraphNode> edges;

        public GraphNode(int label) {
            this.label = label;
        }

        public COLOR getColor() {
            return color;
        }

        public void setColor(COLOR color) {
            this.color = color;
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
