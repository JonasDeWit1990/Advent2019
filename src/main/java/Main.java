import challenges.day1.FuelCalculator;
import challenges.day2.BruteForce;
import shared.IntCodeMachine;
import challenges.day3.ManhattanDistance;
import challenges.day4.PasswordCounter;
import challenges.day6.Space;
import challenges.day7.AmplifierSerie;

import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        FuelCalculator fuelCalculator = new FuelCalculator();
        IntCodeMachine intCode = new IntCodeMachine();
        BruteForce bruteForce = new BruteForce();
        ManhattanDistance manhattanDistance = new ManhattanDistance();
        PasswordCounter passwordCounter = new PasswordCounter();
        Space space = new Space();
        AmplifierSerie amp = new AmplifierSerie();

        /*
        System.out.println("Challenge 1a solution: " + fuelCalculator.calculateFuelFromFile("src/main/resources/challengeInputs/day1.txt"));
        System.out.println("Challenge 1b solution: " + fuelCalculator.calculateExtraFuelFromFile("src/main/resources/challengeInputs/day1.txt"));

        System.out.println("-----------------------------------------");
        System.out.println("Challenge 2a solution: " + intCode.retrievePositionValueAfterLogicWithAlteration(0,"src/main/resources/challengeInputs/day2.txt", 12, 2));
        System.out.println("Challenge 2b solution: " + bruteForce.bruteForceSolution(19690720, "src/main/resources/challengeInputs/day2.txt"));

        System.out.println("-----------------------------------------");
        System.out.println("Challenge 3a solution: " + manhattanDistance.calculateClosestIntersection("src/main/resources/challengeInputs/day3.txt"));
        System.out.println("Challenge 3b solution: " + manhattanDistance.calculateShortestIntersection("src/main/resources/challengeInputs/day3.txt"));

        System.out.println("-----------------------------------------");
        System.out.println("Challenge 4a solution: " + passwordCounter.returnNumberOfValidPasswords(109165,576723));
        System.out.println("Challenge 4b solution: " + passwordCounter.returnNumberOfValidPasswordsPartTwo(109165, 576723));


        System.out.println("-----------------------------------------");
        System.out.print("Challenge 5a solution: " + intCode.executeDay5Logic("src/main/resources/challengeInputs/day5.txt", Arrays.asList(1)));
        System.out.print("\nChallenge 5b solution: " + intCode.executeDay5Logic("src/main/resources/challengeInputs/day5.txt", Arrays.asList(5)));

        System.out.println("\n-----------------------------------------");
        space.readOrbitsFromFile("src/main/resources/challengeInputs/day6.txt");
        System.out.println("Challenge 6a solution: " + space.calculateGalacticDistance());
        System.out.println("Challenge 6b solution: " + space.calculateMoveDistance());

         */
        System.out.println("\n-----------------------------------------");
        System.out.println("Challenge 7a solution: " + amp.iterateAmplifier("src/main/resources/challengeInputs/day7.txt", 0));
        System.out.println("Challenge 7b solution: ");
    }
}
