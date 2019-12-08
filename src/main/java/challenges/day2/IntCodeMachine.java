package challenges.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IntCodeMachine {

    public List<Integer> convertStringInputToIntArray(String pathname) throws IOException {
        String Content = new String(Files.readAllBytes(Paths.get(pathname)));
        String[] InputStringArray = Content.split(",");

        return Arrays.stream(InputStringArray)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    /*
        Exercise requires you to alter a few values in the program before executing logic
     */
    public void alterProgram1(List<Integer> operationProgram, int noun, int verb) {
        //action 1
        operationProgram.set(1, noun);
        //action 2
        operationProgram.set(2,verb);
    }

    public void operationLogic(List<Integer> operationProgram) {
        boolean ValidOpcode = true;

        for (int i = 0; i < operationProgram.size() ; i++) {
            if(ValidOpcode) {
                switch (operationProgram.get(i)) {
                    case 1:
                        operationProgram.set(operationProgram.get(i+3),
                                (operationProgram.get(operationProgram.get(i+1)) +
                                operationProgram.get(operationProgram.get(i+2))));
                        i += 3;
                        break;
                    case 2:
                        operationProgram.set(operationProgram.get(i+3),(operationProgram.get(operationProgram.get(i+1)) *
                                operationProgram.get(operationProgram.get(i+2))));
                        i += 3;
                        break;
                    case 99:
                    default:
                        ValidOpcode = false; // used to stop the machine
                        break;
                }
            }
            else {
                break;
            }
        }
    }

    public List<Integer> operationLogicOnFileInput(String pathName, int noun, int verb) throws IOException {
        List<Integer> convertedProgram = convertStringInputToIntArray(pathName);
        alterProgram1(convertedProgram, noun, verb);
        operationLogic(convertedProgram);
        return convertedProgram;
    }

    public int retrievePositionValueAfterLogic(int position, String pathName, int noun, int verb) throws IOException {
        List<Integer> output = operationLogicOnFileInput(pathName, noun, verb);
        return output.get(position);
    }
}
