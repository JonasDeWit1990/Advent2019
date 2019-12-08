import challenges.day1.FuelCalculator;
import challenges.day2.BruteForce;
import challenges.day2.IntCodeMachine;
import challenges.day3.ManhattanDistance;
import challenges.day4.PasswordCounter;

import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        FuelCalculator fuelCalculator = new FuelCalculator();
        IntCodeMachine intCode = new IntCodeMachine();
        BruteForce bruteForce = new BruteForce();
        ManhattanDistance manhattanDistance = new ManhattanDistance();
        PasswordCounter passwordCounter = new PasswordCounter();

        System.out.println("Challenge 1a solution: " + fuelCalculator.calculateFuelFromFile("src/main/resources/challengeInputs/day1.txt"));
        System.out.println("Challenge 1b solution: " + fuelCalculator.calculateExtraFuelFromFile("src/main/resources/challengeInputs/day1.txt"));

        System.out.println("-----------------------------------------");
        System.out.println("Challenge 2a solution: " + intCode.retrievePositionValueAfterLogic(0,"src/main/resources/challengeInputs/day2.txt", 12, 2));
        System.out.println("Challenge 2b solution: " + bruteForce.bruteForceSolution(19690720, "src/main/resources/challengeInputs/day2.txt"));

        System.out.println("-----------------------------------------");
        System.out.println("Challenge 3a solution: " + manhattanDistance.calculateClosestIntersection("src/main/resources/challengeInputs/day3.txt"));
        System.out.println("Challenge 3b solution: " + manhattanDistance.calculateShortestIntersection("src/main/resources/challengeInputs/day3.txt"));

        System.out.println("-----------------------------------------");
        System.out.println("Challenge 3a solution: " + passwordCounter.returnNumberOfValidPasswords(109165,576723));
        System.out.println("Challenge 3b solution: " + passwordCounter.returnNumberOfValidPasswordsPartTwo(109165, 576723));
    }
}
