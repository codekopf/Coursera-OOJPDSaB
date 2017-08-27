package roadgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import geography.GeographicPoint;

/**
 * A helping class which represent a point-node in map/graph.
 * Each point is represented by its location and the number of roads connecting.
 *
 */
public class MapNode implements Comparable {

	/** The node location **/
	private GeographicPoint location;
	
	/** The Priority Queue Distance 
	 *  The distance from start to current node. 
	 *  Lower - the higher priority in priority queue
	 *  Higher - the lower priority in priority queue
	 */
	private double pqDistance;
	
	/** The distance from node **/
	private double predictedDistanceToGoal;

	/** The list of edges **/ 
	private List<MapEdge> edges;
	
	/** The road to get to node **/
	private String roadType;

	/** Constructor **/
	public MapNode(GeographicPoint location)
	{
		this.location = location;
		this.edges = new ArrayList<MapEdge>();
	}
	
	/** Setters & Getters **/
	public void setLocation(GeographicPoint location)
	{
		this.location = location;
	}
	
	public GeographicPoint getLocation()
	{
		return location;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	
	public double getPqDistance()
	{
		return pqDistance;
	}
	
	public void setPqDistance(double pqDistance)
	{
		this.pqDistance = pqDistance;
	}
	
	public double getPredictedDistanceToGoal()
	{
		return predictedDistanceToGoal;
	}
	
	public void setPredictedDistanceToGoal(double predictedDistanceToGoal)
	{
		this.predictedDistanceToGoal = predictedDistanceToGoal;
	}
	
	public void addEdge(MapEdge edge)
	{
		this.edges.add(edge);
	}
	
	/** Interface Methods **/
	
	/** Comparable Interface **/
	
	/** Simple elegant solution for comparing 2 nodes for priority queue 
	 *  based on their distance from start. 
	 *  
	 *  @param o Another MapNode object
	 *  @return -1,0,1 value based on comparison meaning
	 */
	@Override
	public int compareTo(Object o)
	{
        MapNode other = (MapNode)o; 
		return ((Double)this.getPqDistance()).compareTo((Double) other.getPqDistance());
		
		/** This is 6th week custom improvement. 
		 *	Custom enhancement of priority queue based upon the type of the road type 
		 *	
		 *	Uncomment code below and comment code above for testing custom solution
		 *
		 */
		/*
		MapNode other = (MapNode)o;
		
		int thisNodePriaority = computeRoadPriority(this.getRoadType());
		int otherNodePriaority = computeRoadPriority(other.getRoadType());

		if (thisNodePriaority < otherNodePriaority) {
		    return -1;
		}
		if (thisNodePriaority > otherNodePriaority) {
		    return 1;
		}
		return 0;
		*/
	}
		
	/** Custom Methods **/
	
	/** Find all neighbors based on the list of nodes and the list of edges 
	 * 
	 * @param nodes The map of nodes with key of their coordinates
	 * @param edges The set of edges. Each edges has starting and ending point
	 * @return The list of neighboring nodes of this node
	 */
	public List<MapNode> getNeighbours(Map<GeographicPoint, MapNode> nodes, Set<MapEdge> edges)
	{
		
		List<GeographicPoint> neighboursGeographicPoint = new ArrayList<GeographicPoint>();
		
		for (MapEdge edge : edges) {
			if(edge.getStart().equals(this.getLocation())) {
				neighboursGeographicPoint.add(edge.getEnd());
			}
		}
		
		List<MapNode> neighboursNodes = new ArrayList<MapNode>();
		
		for (GeographicPoint nodeGP : neighboursGeographicPoint) {
			neighboursNodes.add(nodes.get(nodeGP));
		}
		
		return neighboursNodes;

		/** This is 6th week custom improvement. 
		  *	Custom enhancement of priority queue based upon the type of the road type 
		 *	
		 *	Uncomment code below and comment code above for testing custom solution
		 *
		 */
		/*
		Map<GeographicPoint, String> neighboursGeographicPoint = new HashMap<GeographicPoint, String>();
		
		for (MapEdge edge : edges) {
			if(edge.getStart().equals(this.getLocation())) {
				neighboursGeographicPoint.put(edge.getEnd(), edge.getRoadType());
			}
		}
		
		List<MapNode> neighboursNodes = new ArrayList<MapNode>();
		
		for (Map.Entry<GeographicPoint, String> entry : neighboursGeographicPoint.entrySet()) {
			GeographicPoint key = entry.getKey();
			String value = entry.getValue();
			MapNode mp = nodes.get(key);
			mp.setRoadType(value);
			neighboursNodes.add(mp);
		}
		
		return neighboursNodes;
		*/
	}
	
	/** Compute road priority based on road type
	 * 
	 * @param roadType The different kind of the road type 
	 * @return The integer value based upon type of the road
	 */
	private int computeRoadPriority(String roadType)
	{
		// motorway, motorway_link, primary, residential, secondary, tertiary, trunk, unclassified
		if (roadType.equals("motorway") || roadType.equals("motorway_link") || roadType.equals("trunk")) {
			return 1;
		}
		if (roadType.equals("secondary") || roadType.equals("tertiary") || roadType.equals("unclassified")) {
			return -1;
		}
		// primary
		return 0;
	}
	
	/** Compute the distance (in arbitrary/unspecific unit) from this node to demanded node
	 * 
	 * @param other The other GoegraphyPoint
	 * @return The distance
	 */
	public double distance(GeographicPoint other)
	{
		return this.location.distance(other);     
	}

}
