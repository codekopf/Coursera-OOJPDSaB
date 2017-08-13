package roadgraph;

import java.util.ArrayList;
import java.util.List;

import geography.GeographicPoint;

/**
 * A helping class which represent a point-node in map/graph.
 * Each point is represented by its location and the number of roads connecting.
 *
 */
public class MapNode {

	private GeographicPoint location;
	List<MapEdge> edges = new ArrayList<MapEdge>();
	
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
	
	public List<GeographicPoint> getNeighbours() {
		List<GeographicPoint> neighbours = new ArrayList<>();
		
		for (MapEdge edge : edges) {
		    neighbours.add(edge.getEnd());
		}
		
		return neighbours;
	}

}
