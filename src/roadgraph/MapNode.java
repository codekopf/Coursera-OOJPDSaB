package roadgraph;

import java.util.ArrayList;
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
	private List<MapEdge> edges = new ArrayList<MapEdge>();

	/** Constructor **/
	public MapNode(GeographicPoint location)
	{
		this.location = location;
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

	public void setEdges(List<MapEdge> edges)
	{
		this.edges = edges;
	}
	
	public List<MapEdge> getEdges()
	{
		return edges;
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
		
//		MapNode other = (MapNode)o; 
//		double thisNodeDistance = this.getPqDistance();
//		double otherNodeDistance = other.getPqDistance();		
//		if (thisNodeDistance < otherNodeDistance) {
//		    return -1;
//		}
//		if (otherNodeDistance > thisNodeDistance) {
//		    return 1;
//		}
//		return 0;
	}
	
	/** Custom Methods **/
	
	/** Find all neighbours based on the list of nodes and the list of edges 
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
