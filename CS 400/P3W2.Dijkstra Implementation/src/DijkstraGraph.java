// --== CS400 File Header Information ==--
// Name: <Reed Lokken>
// Email: <Rlokken@wisc.edu>
// Group and Team: <AE, Red>
// Group TA: <Rachit>
// Lecturer: <Gary>


import java.util.PriorityQueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * This class extends the BaseGraph data structure with additional methods for
 * computing the total cost and list of node data along the shortest path
 * connecting a provided starting to ending nodes.  This class makes use of
 * Dijkstra's shortest path algorithm.
 */
public class DijkstraGraph<NodeType, EdgeType extends Number>
    extends BaseGraph<NodeType,EdgeType>
    implements GraphADT<NodeType, EdgeType> {

    /**
     * While searching for the shortest path between two nodes, a SearchNode
     * contains data about one specific path between the start node and another
     * node in the graph.  The final node in this path is stored in it's node
     * field.  The total cost of this path is stored in its cost field.  And the
     * predecessor SearchNode within this path is referened by the predecessor
     * field (this field is null within the SearchNode containing the starting
     * node in it's node field).
     *
     * SearchNodes are Comparable and are sorted by cost so that the lowest cost
     * SearchNode has the highest priority within a java.util.PriorityQueue.
     */
    protected class SearchNode implements Comparable<SearchNode> {
        public Node node;
        public double cost;
        public SearchNode predecessor;
        public SearchNode(Node node, double cost, SearchNode predecessor) {
            this.node = node;
            this.cost = cost;
            this.predecessor = predecessor;
        }
        public int compareTo(SearchNode other) {
            if( cost > other.cost ) return +1;
            if( cost < other.cost ) return -1;
            return 0;
        }
    }

    /**
     * This helper method creates a network of SearchNodes while computing the
     * shortest path between the provided start and end locations.  The
     * SearchNode that is returned by this method is represents the end of the
     * shortest path that is found: it's cost is the cost of that shortest path,
     * and the nodes linked together through predecessor references represent
     * all of the nodes along that shortest path (ordered from end to start).
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return SearchNode for the final end node within the shortest path
     * @throws NoSuchElementException when no path from start to end is found
     *         or when either start or end data do not correspond to a graph node
     */
    protected SearchNode computeShortestPath(NodeType start, NodeType end) {
        PriorityQueue<SearchNode> pq = new PriorityQueue<>();
        Hashtable<NodeType, SearchNode> visited = new Hashtable<>();
        
        Node startNode = nodes.get(start);
        Node endNode = nodes.get(end);
        if (startNode == null || endNode == null) {
            throw new NoSuchElementException("Start or end data do not correspond to a graph node.");
        }

        pq.add(new SearchNode(startNode, 0, null));

        while (!pq.isEmpty()) {
            SearchNode current = pq.poll();
            NodeType currentNodeData = (NodeType) current.node.data;

            if (!visited.containsKey(currentNodeData)) {
                visited.put(currentNodeData, current);
                if (currentNodeData.equals(end)) {
                    return current;
                }

                for (BaseGraph<NodeType, EdgeType>.Edge edge : current.node.edgesLeaving) {
                    NodeType neighborData = (NodeType) edge.successor.data;
                    if (!visited.containsKey(neighborData)) {
                        double newCost = current.cost + edge.data.doubleValue();
                        pq.add(new SearchNode(edge.successor, newCost, current));
                    }
                }
            }
        }

        throw new NoSuchElementException("No path from start to end found.");
    }

    /**
     * Returns the list of data values from nodes along the shortest path
     * from the node with the provided start value through the node with the
     * provided end value.  This list of data values starts with the start
     * value, ends with the end value, and contains intermediary values in the
     * order they are encountered while traversing this shorteset path.  This
     * method uses Dijkstra's shortest path algorithm to find this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return list of data item from node along this shortest path
     */
    public List<NodeType> shortestPathData(NodeType start, NodeType end) {
        SearchNode endSearchNode = computeShortestPath(start, end);
        List<NodeType> path = new LinkedList<>();
    
        while (endSearchNode != null) {
            path.add(0, (NodeType) endSearchNode.node.data);
            endSearchNode = endSearchNode.predecessor;
        }
    
        return path;
    }

    /**
     * Returns the cost of the path (sum over edge weights) of the shortest
     * path freom the node containing the start data to the node containing the
     * end data.  This method uses Dijkstra's shortest path algorithm to find
     * this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return the cost of the shortest path between these nodes
     */
    public double shortestPathCost(NodeType start, NodeType end) {
        return computeShortestPath(start, end).cost;

    }
    @Test
    public void testShortestPathData() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>();
        graph.insertEdge("A", "B", 1);
        graph.insertEdge("A", "C", 4);
        graph.insertEdge("B", "C", 2);
        graph.insertEdge("B", "D", 5);
        graph.insertEdge("C", "D", 3);

        List<String> expectedPath = Arrays.asList("A", "B", "C", "D");
        assertEquals(expectedPath, graph.shortestPathData("A", "D"));
    }

    @Test
    public void testShortestPathCost() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>();
        graph.insertEdge("A", "B", 1);
        graph.insertEdge("A", "C", 4);
        graph.insertEdge("B", "C", 2);
        graph.insertEdge("B", "D", 5);
        graph.insertEdge("C", "D", 3);

        double expectedCost = 6.0;
        assertEquals(expectedCost, graph.shortestPathCost("A", "D"), 1e-9);
    }

    @Test
    public void testShortestPathWithAdditionalEdges() {
        DijkstraGraph<String, Integer> graph = new DijkstraGraph<>();
        graph.insertEdge("A", "B", 1);
        graph.insertEdge("A", "C", 4);
        graph.insertEdge("B", "C", 2);
        graph.insertEdge("B", "D", 5);
        graph.insertEdge("C", "D", 3);
        graph.insertEdge("D", "E", 1);
        graph.insertEdge("C", "E", 2);

        List<String> expectedPath = Arrays.asList("A", "B", "C", "E");
        assertEquals(expectedPath, graph.shortestPathData("A", "E"));
    }
}