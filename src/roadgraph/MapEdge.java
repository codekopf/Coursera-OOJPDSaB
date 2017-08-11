package roadgraph;

import geography.GeographicPoint;

public class MapEdge {
	
	private GeographicPoint start;
	private GeographicPoint end;
	private String streetName;
	// TODO: StreetType (enum)
	private String roadType;
	private Double length;
	
	public MapEdge(GeographicPoint start, GeographicPoint end, String streetName, String roadType, Double length) {
		super();
		this.start = start;
		this.end = end;
		this.streetName = streetName;
		this.roadType = roadType;
		this.length = length;
	}
	
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
	
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}

}
