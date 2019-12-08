package challenges.day3;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanDistanceTest {
    ManhattanDistance manhattanDistance = new ManhattanDistance();

    @Test
    void testFileInput() throws IOException {
        List<List<String>> ListToAssert = manhattanDistance.readInputFromFile("src/test/resources/day3/wires1.txt");
        assertEquals("R83",ListToAssert.get(1).get(7));
    }

    @Test
    void testUniqueWire() {
        List<List<String>> inputString = new ArrayList<>(1);
        inputString.add(Arrays.asList("R10","U10"));
        List<Set<Point>> outputSet = manhattanDistance.createSetForWires(inputString);
        assertTrue(outputSet.get(0).contains(new Point(10,10)));
        assertTrue(outputSet.get(0).contains(new Point(10,0)));
        assertFalse(outputSet.get(0).contains(new Point(10,11)));
        assertFalse(outputSet.get(0).contains(new Point(11,10)));
    }

    @Test
    void testLowestManhattanDistance() throws IOException{
        int lowestIntersection = manhattanDistance.calculateClosestIntersection(
                manhattanDistance.createSetForWires(
                        manhattanDistance.readInputFromFile("src/test/resources/day3/wires1.txt")));
        assertEquals(159, lowestIntersection);

        lowestIntersection = manhattanDistance.calculateClosestIntersection(
                manhattanDistance.createSetForWires(
                        manhattanDistance.readInputFromFile("src/test/resources/day3/wires2.txt")));
        assertEquals(135, lowestIntersection);
    }

    @Test
    void testShortestWireDistance() throws  IOException {
        assertEquals(20, manhattanDistance.calculateShortestIntersection("src/test/resources/day3/wires3.txt"));
        assertEquals(610, manhattanDistance.calculateShortestIntersection("src/test/resources/day3/wires1.txt"));
        assertEquals(410, manhattanDistance.calculateShortestIntersection("src/test/resources/day3/wires2.txt"));
    }
}