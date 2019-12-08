package challenges.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCounterTest {
    PasswordCounter passwordCounter = new PasswordCounter();

    @Test
    void checkAdjacency() {
        assertTrue(passwordCounter.checkAdjacency(111111));
        assertTrue(passwordCounter.checkAdjacency(223450));
        assertFalse(passwordCounter.checkAdjacency(123789));
    }

    @Test
    void checkAscendance() {
        assertTrue(passwordCounter.checkAscendance(111111));
        assertFalse(passwordCounter.checkAscendance(223450));
        assertTrue(passwordCounter.checkAscendance(123789));
    }

    @Test
    void checkUniqueAdjacency() {
        assertTrue(passwordCounter.checkUniqueAdjacency(112233));
        assertFalse(passwordCounter.checkUniqueAdjacency(123444));
        assertTrue(passwordCounter.checkUniqueAdjacency(111122));
    }
}