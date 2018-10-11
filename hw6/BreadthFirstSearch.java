

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ListIterator;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
				return false;
		}
		if (start.getElement().equals(elementToFind)) {
			return true;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return false;
	}
	
	public int BFS(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
				return -1;
		}
		if (start.getElement().equals(elementToFind)) {
			return 0;
		}
		Map<String, String> traced = new HashMap<>();
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					traced.put(neighbor.getElement(), current.getElement());
					if (neighbor.getElement().equals(elementToFind)) {
						String tmp = traced.get(elementToFind);
						int cnt = 1;
						if(tmp != null) {
							while(!tmp.equals(start.getElement())) {
								tmp = traced.get(tmp);
								cnt++;
							}
							return cnt;
						}
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return -1;
	}
}
