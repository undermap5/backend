//package org.bbosiregi.demo.util;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.locationtech.jts.geom.Coordinate;
//import org.locationtech.jts.geom.GeometryFactory;
//import org.locationtech.jts.geom.Point;
//
//@Component
//@RequiredArgsConstructor
//public class PointUtil {
//    private final GeometryFactory geometryFactory;
//
//    public Point generatePoint(double lat, double lng) {
//        if (lat < -90 || lat > 90 || lng < -180 || lng > 180) {
//            throw new IllegalArgumentException("Invalid latitude or longitude values");
//        }
//        Point point = geometryFactory.createPoint(new Coordinate(lng, lat));
//        point.setSRID(4326);
//        return point;
//    }
//}
