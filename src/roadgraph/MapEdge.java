package roadgraph;

import geography.GeographicPoint;

public class MapEdge {
	
	/** The edge endpoints */
	private GeographicPoint start;
	private GeographicPoint end;
	
	/** The name of the street */
	private String streetName;
	
	/** The type of the road */
	private String roadType;
	
	/** The length of the road */
	private double length;
	
	/** Constructor **/
	public MapEdge(GeographicPoint start, GeographicPoint end, String streetName, String roadType, double length) {
		this.start = start;
		this.end = end;
		this.streetName = streetName;
		this.roadType = roadType;
		this.length = length;
	}
	
	/** Setters & Getters **/
	public GeographicPoint getStart() {
		return start;
	}
	
	public void setStart(GeographicPoint start) {
		this.start = start;
	}
	
	public GeographicPoint getEnd() {
		return end;
	}
	
	public void setEnd(GeographicPoint end) {
		this.end = end;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getRoadType() {
		return roadType;
	}
	
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	
	public double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}

}
