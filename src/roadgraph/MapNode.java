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
	private double predictedDistanceToGoal;

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
	
	public void setPqDistance(double pqDistance) {
		this.pqDistance = pqDistance;
	}
	
	public double getPqDistance() {
		return pqDistance;
	}

	public void setPredictedDistanceToGoal(double predictedDistanceToGoal) {
		this.predictedDistanceToGoal = predictedDistanceToGoal;
	}
	
	public double getPredictedDistanceToGoal() {
		return predictedDistanceToGoal;
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
	
	//@Override
	public int compareTo(Object o) {
		
//		MapNode toCompareMapNode = (MapNode)other; 
//		int lastCmp = pqDistance.compareTo(toCompareMapNode.pqDistance);
//	    return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
//		
//		return this.compareTo(other.bookTitle);
		
//		MapNode m = (MapNode)o; 
//		return ((Double)this.getDistance()).compareTo((Double)m.getDistance());
//
//		MapNode otherNode = (MapNode)o;
//		
//		if (otherNode.getPredictedDistanceToGoal() != 0) {
//			if ((this.getPqDistance() + this.getPredictedDistanceToGoal()) < (otherNode.getPqDistance() + otherNode.getPredictedDistanceToGoal())) {
//	            return -1;
//	        }
//	        if ((this.getPqDistance() + this.getPredictedDistanceToGoal()) > (otherNode.getPqDistance() + otherNode.getPredictedDistanceToGoal())) {
//	            return 1;
//	        }
//	        if ((this.getPqDistance() + this.getPredictedDistanceToGoal()) == (otherNode.getPqDistance() + otherNode.getPredictedDistanceToGoal())) {
//	        	return 0;
//			}
//		} else {
//			if (this.getPqDistance() < otherNode.getPqDistance()) {
//	            return -1;
//	        }
//	        if (this.getPqDistance() > otherNode.getPqDistance()) {
//	            return 1;
//	        }
//	        return 0;
//		}
//		return 0;
		
//		MapNode otherNode = (MapNode)o;
//		
//		if (this.getPqDistance() < otherNode.getPqDistance()) {
//            return -1;
//        }
//        if (this.getPqDistance() > otherNode.getPqDistance()) {
//            return 1;
//        }
//        return 0;
        
        
        MapNode m = (MapNode)o; 
		return ((Double)this.getPqDistance()).compareTo((Double) m.getPqDistance());

        
        
        
        
        
        
        
        
//		MapNode other = (MapNode)o; 
//
//		double thisNodeDistance = this.getPqDistance(); // + this.getPredictedDistanceToGoal();
//		double otherNodeDistance = other.getPqDistance(); // + other.getPredictedDistanceToGoal();
//		
//		if (thisNodeDistance < otherNodeDistance) {
//            return -1;
//        }
//        if (otherNodeDistance > thisNodeDistance) {
//            return 1;
//        }
//        return 0;
	}
	
	
}
