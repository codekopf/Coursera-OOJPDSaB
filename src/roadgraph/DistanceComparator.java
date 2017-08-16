package roadgraph;

import java.util.Comparator;

import geography.GeographicPoint;

public class DistanceComparator implements Comparator<GeographicPoint>
{
    @Override
    public int compare(GeographicPoint x,GeographicPoint y)
    {
        if (x.getPqDistance() < y.getPqDistance()) {
            return -1;
        }
        if (x.getPqDistance() > y.getPqDistance()) {
            return 1;
        }
        return 0;
    }
}