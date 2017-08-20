package roadgraph;

import geography.GeographicPoint;

public class MapEdge {
	
	private GeographicPoint start;
	private GeographicPoint end;
	private String streetName;
	private String roadType;
	private double length;
	
	public MapEdge(GeographicPoint start, GeographicPoint end, String streetName, String roadType, double length) {
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
	
	public double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((roadType == null) ? 0 : roadType.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapEdge other = (MapEdge) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (roadType == null) {
			if (other.roadType != null)
				return false;
		} else if (!roadType.equals(other.roadType))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		return true;
	}
}
