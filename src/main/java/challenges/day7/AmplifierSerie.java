package challenges.day7;

import shared.IntCodeMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmplifierSerie {
    IntCodeMachine intCodeMachine = new IntCodeMachine();
    List<Integer> amplifierInput;

    public int callAmplifier(String pathName, int input, int phase) {
        amplifierInput = new ArrayList<>(Arrays.asList(phase, input));
        return Integer.parseInt(intCodeMachine.executeDay5Logic(pathName, amplifierInput));
    }

    public int callAmplifierSerie(String pathName, int input, List<Integer> phaseArray) {
        int amplifierInput = input;
        for(int i = 0; i < 5; i++) {
            amplifierInput = callAmplifier(pathName, amplifierInput, phaseArray.get(i));
        }
        return amplifierInput;
    }

    public int iterateAmplifier(String pathName, int input) {
        List<Integer> phaseArray = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        IterationToFive iterator = new IterationToFive();
        int maxValue = 0;

        do {
            int checkValue = callAmplifierSerie(pathName, input, phaseArray);
            phaseArray = new ArrayList<>(iterator.increaseIteration());
            if(checkValue > maxValue)
                maxValue = checkValue;
        }while (phaseArray.get(0) != -1);
        return maxValue;
    }
}
