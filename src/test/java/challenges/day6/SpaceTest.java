package challenges.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {
    Space space;

    @Test
    void addOrbitFromString() {
        space = new Space();
        space.readOrbitsFromFile("src/test/resources/day6/day6test.txt");
        assertEquals(11, space.orbits.size());
    }

    @Test
    void calculateDistance() {
        space = new Space();
        space.readOrbitsFromFile("src/test/resources/day6/day6test.txt");
        assertEquals(42, space.calculateGalacticDistance());
    }

    @Test
    void calculateMoveDistance() {
        space = new Space();
        space.readOrbitsFromFile("src/test/resources/day6/day6testb.txt");
        assertEquals(4, space.calculateMoveDistance());
    }
}