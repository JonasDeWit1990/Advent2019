package challenges.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuelCalculatorTest {
    FuelCalculator fuelCalculator = new FuelCalculator();

    @Test
    void CorrectMassCalculated() {
        assertEquals(2,fuelCalculator.singleFuelCalc(12));
        assertEquals(2,fuelCalculator.singleFuelCalc(14));
        assertEquals(654,fuelCalculator.singleFuelCalc(1969));
        assertEquals(33583,fuelCalculator.singleFuelCalc(100756));
    }

    @Test
    void CorrectMassCalculated_WithExtraFuel() {
        assertEquals(2,fuelCalculator.singleFuelCalcWithExtraFuel(14));
        assertEquals(966,fuelCalculator.singleFuelCalcWithExtraFuel(1969));
        assertEquals(50346,fuelCalculator.singleFuelCalcWithExtraFuel(100756));
    }

    @Test
    void CorrectMassCalculatedFromFile() throws IOException {
        assertEquals((2+2+654+33583),fuelCalculator.calculateFuelFromFile("src/test/resources/day1/fuelTestFile.txt"));
    }

    @Test
    void CorrectMassCalculatedFromFile_WithExtraFuel() throws IOException {
        assertEquals((2+2+966+50346),fuelCalculator.calculateExtraFuelFromFile("src/test/resources/day1/fuelTestFile.txt"));
    }
}