package challenges.day7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AmplifierSerieTest {
    AmplifierSerie amplifierSerie = new AmplifierSerie();

    @Test
    void callAmplifierSerie() {
        List<Integer> phaseSetting = new ArrayList<>(Arrays.asList(4,3,2,1,0));
        assertEquals(43210, amplifierSerie.callAmplifierSerie("src/test/resources/day7/test1.txt", 0, phaseSetting));
        phaseSetting = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        assertEquals(54321, amplifierSerie.callAmplifierSerie("src/test/resources/day7/test2.txt", 0, phaseSetting));
        phaseSetting = new ArrayList<>(Arrays.asList(1,0,4,3,2));
        assertEquals(65210, amplifierSerie.callAmplifierSerie("src/test/resources/day7/test3.txt", 0, phaseSetting));
    }
}