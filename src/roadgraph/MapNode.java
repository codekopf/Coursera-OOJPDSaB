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

	private GeographicPoint location;
	private double pqDistance;
	
	private List<MapEdge> edges = new ArrayList<MapEdge>();

	public MapNode(GeographicPoint location) {
		this.location = location;
	}

	public GeographicPoint getLocation() {
		return location;
	}

	public void setLocation(GeographicPoint location) {
		this.location = location;
	}

	public List<MapEdge> getEdges() {
		return edges;
	}

	public void setEdges(List<MapEdge> edges) {
		this.edges = edges;
	}
	
	public double getPqDistance() {
		return pqDistance;
	}

	public void setPqDistance(double pqDistance) {
		this.pqDistance = pqDistance;
	}
	
	public List<MapNode> getNeighbours(Map<GeographicPoint, MapNode> nodes, Set<MapEdge> edges) {
		
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
	
	
	public double distance(GeographicPoint other)
	{
		return this.location.distance(other);     
	}
	
	
	
	@Override
	public int compareTo(Object o) {
		MapNode toCompareMapNode = (MapNode)o; 
		if (this.getPqDistance() < toCompareMapNode.getPqDistance()) {
            return -1;
        }
        if (this.getPqDistance() > toCompareMapNode.getPqDistance()) {
            return 1;
        }
        return 0;
	}
}
