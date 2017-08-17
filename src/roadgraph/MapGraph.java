/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which represents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
package roadgraph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

import geography.GeographicPoint;
import util.GraphLoader;

/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which represents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
public class MapGraph {
	// TODO : Add your member variables here in WEEK 3
	Map<GeographicPoint, MapNode> nodes;

	/** 
	 * Create a new empty MapGraph 
	 */
	public MapGraph()
	{
		// TODO : Implement in this constructor in WEEK 3
		nodes = new HashMap<GeographicPoint, MapNode>();
	}
	
	/**
	 * Get the number of vertices (road intersections) in the graph
	 * @return The number of vertices in the graph.
	 */
	public int getNumVertices()
	{
		//TODO : Implement this method in WEEK 3
		return nodes.size();
	}
	
	/**
	 * Return the intersections, which are the vertices in this graph.
	 * @return The vertices in this graph as GeographicPoints
	 */
	public Set<GeographicPoint> getVertices()
	{
		//TODO : Implement this method in WEEK 3
		Set<GeographicPoint> setOfVertices = new HashSet<GeographicPoint>();
		
		for (MapNode mapNode : nodes.values()) {
			setOfVertices.add(mapNode.getLocation());
		}
		
		return setOfVertices;
	}
	
	/**
	 * Get the number of road segments in the graph
	 * @return The number of edges in the graph.
	 */
	public int getNumEdges()
	{
		//TODO: Implement this method in WEEK 3
		int numberOfEdges = 0;
		
		for (MapNode mapNode : nodes.values()) {
			numberOfEdges += mapNode.getEdges().size();
		}
		
		return numberOfEdges;
	}

	
	
	/** Add a node corresponding to an intersection at a Geographic Point
	 * If the location is already in the graph or null, this method does 
	 * not change the graph.
	 * @param location  The location of the intersection
	 * @return true if a node was added, false if it was not (the node
	 * was already in the graph, or the parameter is null).
	 */
	public boolean addVertex(GeographicPoint location)
	{
		// TODO: Implement this method in WEEK 3
		if (nodes.get(location) == null) {
			nodes.put(location, new MapNode(location));
		} else {
			return false;
		}
		return true;
	}
	
	/**
	 * Adds a directed edge to the graph from pt1 to pt2.  
	 * Precondition: Both GeographicPoints have already been added to the graph
	 * @param from The starting point of the edge
	 * @param to The ending point of the edge
	 * @param roadName The name of the road
	 * @param roadType The type of the road
	 * @param length The length of the road, in km
	 * @throws IllegalArgumentException If the points have not already been
	 *   added as nodes to the graph, if any of the arguments is null,
	 *   or if the length is less than 0.
	 */
	public void addEdge(GeographicPoint from, GeographicPoint to, String roadName,
			String roadType, double length) throws IllegalArgumentException {

		//TODO: Implement this method in WEEK 3

		// One line solution:
		// nodes.get(from).getEdges().add(new MapEdge(from, to, roadName, roadType, length));
		
		MapNode mapNode = nodes.get(from);
		List<MapEdge> mapNodeEdges = mapNode.getEdges();
		mapNodeEdges.add(new MapEdge(from, to, roadName, roadType, length));
	}
	

	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return bfs(start, goal, temp);
	}
	
	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, 
			 					     GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 3
		
		// Initialize structures
		Map<GeographicPoint, GeographicPoint> parentMap = new HashMap<GeographicPoint, GeographicPoint>();
		Queue<GeographicPoint> queueToSearch = new LinkedList<GeographicPoint>();
		Set<GeographicPoint> visitedSet = new HashSet<GeographicPoint>();
		boolean flagPathExist = false;
		
		// Enqueue S in queue and add to visited
		queueToSearch.add(start);
		visitedSet.add(start);

		// While queue is not empty:
		while(!queueToSearch.isEmpty()){
			
			// Dequeue node curr from front of queue
			GeographicPoint curr = queueToSearch.poll();
			
			// Hook for visualization
			nodeSearched.accept(curr);

			// If curr == G return parent map 
			if (curr.equals(goal)) {
				flagPathExist = true;
				break;
			}
			
			// For each of curr's unvisited neighbours, n:
			List<GeographicPoint> neighbours = nodes.get(curr).getNeighbours();
			for (GeographicPoint neighbour : neighbours){
				if(!visitedSet.contains(neighbour)) {

					// add n to visited set
					visitedSet.add(neighbour);
					
					// add curr as n's parent in parent map
					parentMap.put(neighbour, curr);
					
					// engueu n to back of queue
					queueToSearch.add(neighbour);
				}
			}
		}
		
		// Backward loop from end to start, looping trough parentMap
		if(flagPathExist) {
			LinkedList<GeographicPoint> path = new LinkedList<GeographicPoint>();
			GeographicPoint curr = goal;

			while (!curr.equals(start)) {
				path.addFirst(curr);
				curr = parentMap.get(curr);
			}

			path.addFirst(start);	
			return path;	
		} else {
			// If we get here then there's no path;
			return null;
		}
	}
	

	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
		// You do not need to change this method.
        Consumer<GeographicPoint> temp = (x) -> {};
        return dijkstra(start, goal, temp);
	}
	
	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, 
										  GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 4
		// Dijkstra(S,G):
		if (!nodes.containsKey(start)) {
			return null;
		}
		if (!nodes.containsKey(goal)) {
			return null;
		}
		
		// Distances to infinity
		nodes.keySet().forEach((node) -> {node.setPqDistance(Double.POSITIVE_INFINITY);});
		
		// Parent HashMap
		Map<GeographicPoint, GeographicPoint> parentMap = new HashMap<GeographicPoint, GeographicPoint>();
		// Priority Queue (PQ)
		Queue<GeographicPoint> queueToSearch = new PriorityQueue<GeographicPoint>();
		// Visited HashSet
		Set<GeographicPoint> visitedSet = new HashSet<GeographicPoint>();
		
		boolean flagPathExist = false;
		// Enqueue {S,0} onto the PQ
		start.setPqDistance(0);
		queueToSearch.add(start);
		
		// While PQ is not empty:
		while(!queueToSearch.isEmpty()) {
			// Dequeue node curr from front of queue
			GeographicPoint curr = queueToSearch.poll();
			// Hook for visualization
			nodeSearched.accept(curr);			
			// If (curr is not visited)
			if (!visitedSet.contains(curr)) {
				// Add curr to visited set
				visitedSet.add(curr);
		
				// If curr == G return parent map 
				if (curr.equals(goal)) {
					flagPathExist = true;
					break;
				}
				
				// For each of curr's neighbors, n, not in visited set:
				List<GeographicPoint> neighbours = nodes.get(curr).getNeighbours();
				for (GeographicPoint neighbour : neighbours) {
					if(!visitedSet.contains(neighbour)) {
						double toNeigbour = curr.getPqDistance() + curr.distance(neighbour);
						// If path through curr to n is shorter
						if(toNeigbour < neighbour.getPqDistance()) {
							// Update curr as n's parent in parent map
							parentMap.put(neighbour, curr);
							// Enqueue {n,distance} into the PQ
							neighbour.setPqDistance(toNeigbour);
							queueToSearch.add(neighbour);
						}
					}
				}
			}
		}
		
		// Backward loop from end to start, looping trough parentMap
		if(flagPathExist) {
			LinkedList<GeographicPoint> path = new LinkedList<GeographicPoint>();
			GeographicPoint curr = goal;

			while (!curr.equals(start)) {
				path.addFirst(curr);
				curr = parentMap.get(curr);
			}

			path.addFirst(start);	
			return path;	
		} else {
			// If we get here then there's no path from S to G
			return null;
		}
	}

	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return aStarSearch(start, goal, temp);
	}
	
	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, 
											 GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
	{
		// TODO: Implement this method in WEEK 4
		
		// Hook for visualization.  See writeup.
		//nodeSearched.accept(next.getLocation());
		
		return null;
	}

	
	
	public static void main(String[] args)
	{
		System.out.print("Making a new map...");
		MapGraph firstMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/testdata/simpletest.map", firstMap);
		System.out.println("DONE.");
		
		// You can use this method for testing.  
		
		
		/* Here are some test cases you should try before you attempt 
		 * the Week 3 End of Week Quiz, EVEN IF you score 100% on the 
		 * programming assignment.
		 */
		/*
		MapGraph simpleTestMap = new MapGraph();
		GraphLoader.loadRoadMap("data/testdata/simpletest.map", simpleTestMap);
		
		GeographicPoint testStart = new GeographicPoint(1.0, 1.0);
		GeographicPoint testEnd = new GeographicPoint(8.0, -1.0);
		
		System.out.println("Test 1 using simpletest: Dijkstra should be 9 and AStar should be 5");
		List<GeographicPoint> testroute = simpleTestMap.dijkstra(testStart,testEnd);
		List<GeographicPoint> testroute2 = simpleTestMap.aStarSearch(testStart,testEnd);
		
		
		MapGraph testMap = new MapGraph();
		GraphLoader.loadRoadMap("data/maps/utc.map", testMap);
		
		// A very simple test using real data
		testStart = new GeographicPoint(32.869423, -117.220917);
		testEnd = new GeographicPoint(32.869255, -117.216927);
		System.out.println("Test 2 using utc: Dijkstra should be 13 and AStar should be 5");
		testroute = testMap.dijkstra(testStart,testEnd);
		testroute2 = testMap.aStarSearch(testStart,testEnd);
		
		
		// A slightly more complex test using real data
		testStart = new GeographicPoint(32.8674388, -117.2190213);
		testEnd = new GeographicPoint(32.8697828, -117.2244506);
		System.out.println("Test 3 using utc: Dijkstra should be 37 and AStar should be 10");
		testroute = testMap.dijkstra(testStart,testEnd);
		testroute2 = testMap.aStarSearch(testStart,testEnd);
		*/
		
		
		/* Use this code in Week 3 End of Week Quiz */
		/*MapGraph theMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/maps/utc.map", theMap);
		System.out.println("DONE.");

		GeographicPoint start = new GeographicPoint(32.8648772, -117.2254046);
		GeographicPoint end = new GeographicPoint(32.8660691, -117.217393);
		
		
		List<GeographicPoint> route = theMap.dijkstra(start,end);
		List<GeographicPoint> route2 = theMap.aStarSearch(start,end);

		*/
		
	}
	
}
