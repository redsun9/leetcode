package basic.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static basic.utils.GeometryTools.triangleArea;
import static java.util.Comparator.comparingDouble;
import static org.junit.jupiter.api.Assertions.*;

class GeometryToolsTest {
    private static final Comparator<double[]> comparator =
            comparingDouble((double[] p) -> p[0])
                    .thenComparingDouble(p -> p[1]);

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

    @Test
    void lineCircleIntersection1() {
        double[][] points = GeometryTools.lineCircleIntersection(0, 1, -5, 1, 1, 5);
        assertEquals(2, points.length);
        Arrays.sort(points, comparator);

        assertEquals(-2.0, points[0][0], 1e-6);
        assertEquals(5.0, points[0][1], 1e-6);
        assertEquals(4.0, points[1][0], 1e-6);
        assertEquals(5.0, points[1][1], 1e-6);
    }

    @Test
    void lineCircleIntersection2() {
        double[][] points = GeometryTools.lineCircleIntersection(0, 1, -6, 1, 1, 5);
        assertEquals(1, points.length);
        assertEquals(1.0, points[0][0], 1e-6);
        assertEquals(6.0, points[0][1], 1e-6);
    }

    @Test
    void lineCircleIntersection3() {
        double[][] points = GeometryTools.lineCircleIntersection(0, 1, -7, 1, 1, 5);
        assertEquals(0, points.length);
    }
}