package basic.utils;

import org.junit.jupiter.api.Test;

import static basic.utils.GeometryTools.triangleArea;
import static org.junit.jupiter.api.Assertions.*;

class GeometryToolsTest {

    @Test
    void testTriangleArea() {
        assertEquals(3.0, triangleArea(0, 0, 2, 0, 0, 3), 1e-6);
    }

    @Test
    void testClockwise() {
        assertTrue(GeometryTools.clockwise(0, 0, 0, 1, 1, 1));
    }

    @Test
    void testLineIntersection1() {
        double[] p = GeometryTools.lineIntersection(0, 0, 4, 2, 0, 2, 4, 0);
        assertNotNull(p);
        assertEquals(2.0, p[0], 1e-6);
        assertEquals(1.0, p[1], 1e-6);
    }

    @Test
    void testLineIntersection2() {
        double[] p = GeometryTools.lineIntersection(0, 0, 1, 1, 0, 2, 1, 3);
        assertNull(p);
    }

    @Test
    void testLineIntersection3() {
        double[] p = GeometryTools.lineIntersection(2, -4, 0, 2, 4, 8);
        assertNotNull(p);
        assertEquals(2.0, p[0], 1e-6);
        assertEquals(1.0, p[1], 1e-6);
    }

    @Test
    void testLineIntersection4() {
        double[] p = GeometryTools.lineIntersection(2, -4, 0, 1, -2, 0);
        assertNull(p);
    }

    @Test
    void segmentIntersects() {
        assertTrue(GeometryTools.segmentIntersects(0, 0, 2, 2, 0, 2, 2, 0));
        assertFalse(GeometryTools.segmentIntersects(0, 0, 2, 2, 3, 3, 4, 5));
        assertTrue(GeometryTools.segmentIntersects(0, 0, 0, 10, -1, 2, 2, 5));
    }

    @Test
    void polygonSquare() {
        double[][] p = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};
        assertEquals(1.0, GeometryTools.polygonSquare(p), 1e-6);
    }

    @Test
    void massCenterOfPoints() {
        double[][] p = {{0, 0, 1}, {4, 0, 1}, {4, 2, 1}, {0, 2, 1}};
        double[] center = GeometryTools.massCenterOfPoints(p);
        assertEquals(2.0, center[0], 1e-6);
        assertEquals(1.0, center[1], 1e-6);
    }

    @Test
    void massCenterOfEdges() {
        double[][] p = {{0, 0}, {4, 0}, {4, 2}, {0, 2}};
        double[] center = GeometryTools.massCenterOfEdges(p);
        assertEquals(2.0, center[0], 1e-6);
        assertEquals(1.0, center[1], 1e-6);
    }

    @Test
    void massCenterOfPolygon() {
        double[][] p = {{0, 0}, {4, 0}, {4, 2}, {0, 2}};
        double[] center = GeometryTools.massCenterOfPolygon(p);
        assertEquals(2.0, center[0], 1e-6);
        assertEquals(1.0, center[1], 1e-6);
    }
}