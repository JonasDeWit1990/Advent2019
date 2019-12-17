package challenges.day2;

import shared.IntCodeMachine;

import java.io.IOException;

public class BruteForce {
    IntCodeMachine intCodeMachine = new IntCodeMachine();

    public int bruteForceSolution(int solutionNumber, String pathName) throws IOException {
        int[] solution = new int[] {-1,-1};
        for(int noun = 0; noun < 100; noun++) {
            for(int verb = 0; verb < 100; verb++) {
                if(solutionNumber == intCodeMachine.retrievePositionValueAfterLogicWithAlteration(0, pathName, noun, verb)) {
                    solution[0] = noun;
                    solution[1] = verb;
                }
            }
        }

        return 100 * solution[0] + solution[1];
    }
}
