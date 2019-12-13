package challenges.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IntCodeMachine {
    public int getInputForLogic() {
        return InputForLogic;
    }

    public void setInputForLogic(int inputForLogic) {
        InputForLogic = inputForLogic;
    }

    int InputForLogic = 0;

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

    public int returnReadingParameter(List<Integer> program, int index, String opCode, int paramLoc) {
        if(opCode.length() - 2 - paramLoc >= 0) {
            switch(opCode.charAt(opCode.length() - 2 - paramLoc)) {
                case '1':
                    return program.get(index);
                case '0':
                default:
                    return program.get(program.get(index));
            }
        }
        return program.get(program.get(index));
    }

    public void additionModule(List<Integer> program, int param1, int param2, int param3) {
        program.set(param3, (param1 + param2));
    }

    public void multiplicationModule(List<Integer> program, int param1, int param2, int param3) {
        program.set(param3, (param1 * param2));
    }
    
    public void mathematicalModule(List<Integer> program, int index, String opCode) {
        int param1 = returnReadingParameter(program,index + 1,opCode, 1);
        int param2 = returnReadingParameter(program,index + 2,opCode, 2);
        int param3 = program.get(index + 3);

        switch(opCode.charAt(opCode.length() - 1)) {
            case '1':
                additionModule(program, param1, param2, param3);
                break;
            case '2':
                multiplicationModule(program, param1, param2, param3);
                break;
            default:
                System.out.println("Wrong math code");
        }
    }

    public void ioModule(List<Integer> program, int index, String opCode) {
        switch(opCode.charAt(opCode.length() - 1)) {
            case '3':
                program.set(program.get(index + 1), InputForLogic);
                break;
            case '4':
                System.out.print(program.get(program.get(index + 1)) + "|");
                break;
            default:
                System.out.println("Wrong io code");
        }
    }

    public int jumpModule(List<Integer> program, int index, String opCode) {
        int param1 = returnReadingParameter(program, index + 1, opCode, 1);
        int param2 = returnReadingParameter(program,index + 2,opCode, 2);

        switch(opCode.charAt(opCode.length() - 1)) {
            case '5':
                if(param1 != 0) {
                    return param2;
                }
                break;
            case '6':
                if(param1 == 0) {
                    return param2;
                }
                break;
            default:
                System.out.println("Wrong jump code");
                return 0;
        }
        return 0;
    }

    public void compareModule(List<Integer> program, int index, String opCode) {
        int param1 = returnReadingParameter(program,index + 1,opCode, 1);
        int param2 = returnReadingParameter(program,index + 2,opCode, 2);
        int param3 = program.get(index + 3);

        switch(opCode.charAt(opCode.length() - 1)) {
            case '7':
                if(param1 < param2)
                    program.set(param3, 1);
                else
                    program.set(param3, 0);
                break;
            case '8':
                if(param1 == param2)
                    program.set(param3, 1);
                else
                    program.set(param3, 0);
                break;
            default:
                System.out.println("Wrong math code");
        }
    }

    public void operationLogic(List<Integer> operationProgram) {
        boolean ValidOpcode = true;

        for (int i = 0; i < operationProgram.size() ; i++) {
            if(ValidOpcode) {
                String operationCode = operationProgram.get(i).toString();
                switch (operationProgram.get(i)%100) {
                    case 1:
                    case 2:
                        mathematicalModule(operationProgram, i, operationCode);
                        i += 3;
                        break;
                    case 3:
                    case 4:
                        ioModule(operationProgram, i, operationCode);
                        i += 1;
                        break;
                    case 5:
                    case 6:
                        int jumpVariable = jumpModule(operationProgram, i, operationCode);
                        if(jumpVariable != 0) {
                            i = (jumpVariable - 1);
                        }
                        else {
                            i += 2;
                        }
                        break;
                    case 7:
                    case 8:
                        compareModule(operationProgram, i, operationCode);
                        i += 3;
                        break;
                    default:
                        System.out.print("wrong code");
                    case 99:
                        ValidOpcode = false; // used to stop the machine
                        break;
                }
            }
            else {
                break;
            }
        }
    }

    public List<Integer> operationLogicOnFileInput(String pathName) throws IOException {
        List<Integer> convertedProgram = convertStringInputToIntArray(pathName);
        operationLogic(convertedProgram);
        return convertedProgram;
    }

    public int retrievePositionValueAfterLogic(int position, String pathName) throws IOException {
        List<Integer> output = operationLogicOnFileInput(pathName);
        return output.get(position);
    }

    public List<Integer> operationLogicOnFileInputWithAlteration(String pathName, int noun, int verb) throws IOException {
        List<Integer> convertedProgram = convertStringInputToIntArray(pathName);
        alterProgram1(convertedProgram, noun, verb);
        operationLogic(convertedProgram);
        return convertedProgram;
    }

    public int retrievePositionValueAfterLogicWithAlteration(int position, String pathName, int noun, int verb) throws IOException {
        List<Integer> output = operationLogicOnFileInputWithAlteration(pathName, noun, verb);
        return output.get(position);
    }

    public void executeDay5Logic(String pathName, int Input) throws IOException {
        InputForLogic = Input;
        List<Integer> AfterExecution = operationLogicOnFileInput(pathName);
    }
}
