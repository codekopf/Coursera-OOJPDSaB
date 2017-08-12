package roadgraph;

import java.util.ArrayList;
import java.util.List;

import geography.GeographicPoint;

public class MapNode {
	// int location = GeographicPoint;
	// List<MapNodes> adj = ;/* Adjacency_nodes */
	// List<String> StreetName;
	// List<double distances> length = 3/3

	List<MapEdge> edges = new ArrayList<MapEdge>();
	
	private GeographicPoint location;


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
