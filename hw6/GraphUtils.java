

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {

		/* IMPLEMENT THIS METHOD! */
		if(graph == null || src == null || dest == null || !graph.containsElement(src) || !graph.containsElement(dest))
			return -1; // this line is here only so this code will compile if you don't modify it
		BreadthFirstSearch b = new BreadthFirstSearch(graph);
		return b.BFS(graph.getNode(src), dest);
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		/* IMPLEMENT THIS METHOD! */
		Set<String> nodeSet = new HashSet<>();
		if(graph == null || src == null || !graph.containsElement(src) || distance < 1)
			return null;
		Set<Node> allNodes = graph.getAllNodes();
		for(Node node : allNodes) {
			if(!node.getElement().equals(src)) {
				int dist = minDistance(graph, src, node.getElement());
				if(dist != -1 && dist <= distance)
					nodeSet.add(node.getElement());
			}
		}
		return nodeSet; // this line is here only so this code will compile if you don't modify it
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
		if(g == null || values == null || values.isEmpty())
			return false;
		String src = values.get(0);
		String dest = values.get(values.size() - 1);
		if(!src.equals(dest))
			return false;
		Node current = g.getNode(src);
		Set<String> marked = new HashSet<>();
		marked.add(src);
		for(int i = 1; i < values.size(); i++) {
			String tmp = values.get(i);
			if(g.getNodeNeighbors(current).contains(g.getNode(tmp))){
				if(!marked.contains(tmp)) {
					marked.add(tmp);
					current = g.getNode(tmp);
				}
				else return false;
			}
			else return false;
		}
		return marked.size() == g.getNumEdges(); // this line is here only so this code will compile if you don't modify it
	}
}
