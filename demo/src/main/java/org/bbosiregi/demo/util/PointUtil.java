package org.bbosiregi.demo.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

@Component
@RequiredArgsConstructor
public class PointUtil {
    private final GeometryFactory geometryFactory;

    public Point generatePoint(double lat, double lng) {
        return geometryFactory.createPoint(new Coordinate(lat, lng));
    }
}
