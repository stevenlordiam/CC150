/** 
 * Chapter 4-Trees and Graphs
 * Question 4-2
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

public class TreesAndGraphs_2 {				// iterative solution, Depth First Search
	public enum State{
		Unvisited, Visited, Visiting;
	}

	public static boolean search(Graph g, Node start, Node end){
		
		LinkedList<Node> q = new LinkedList<node>(); 		// operate as Queue

		for(Node u : g.getNodes()){
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		while(!q.isEmpty()){
			Node u = q.removeFirst(); 	// dequeue
			if(u != null){
				for(Node v:u.getAdjacent()){
					if(v == end){
						return true;
					} else {
						v.state = State.Visiting;
						q.add(v);		
					}
				}
			}
			u.state = State.Visited;
		}
	}
	return false;

}

/*

  key: 
  * Mark any node found as "visited" to avoid repetition of the nodes
  * DFS is simpler to implement since it can bwe done with simple recursion

*/