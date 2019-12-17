package challenges.day1;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FuelCalculator {

    int singleFuelCalc(int mass) {
        return (mass/3) - 2;
    }

    int singleFuelCalcWithExtraFuel(int mass) {
        int total = 0;
        int fuel = singleFuelCalc(mass);
        total = fuel;
        while(fuel > 0) {
            fuel = singleFuelCalc(fuel);
            if(fuel > 0)
                total += fuel;
        }
        return total;
    }

    public int calculateFuelFromFile(String pathOfFile) {
        try {
            Stream<String> input = Files.lines(Paths.get(pathOfFile));

            return input
                    .mapToInt(Integer::parseInt)
                    .map(this::singleFuelCalc)
                    .sum();
        }
        catch (Exception e) {
            return -1;
        }
    }

    public int calculateExtraFuelFromFile(String pathOfFile) {
        try {
            Stream<String> input = Files.lines(Paths.get(pathOfFile));

            return input
                    .mapToInt(Integer::parseInt)
                    .map(this::singleFuelCalcWithExtraFuel)
                    .sum();
        }
        catch (Exception e) {
            return -1;
        }
    }
}
