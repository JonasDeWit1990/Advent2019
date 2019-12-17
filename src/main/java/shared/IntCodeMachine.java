package shared;

import java.util.*;

public class IntCodeMachine {
    IntCodeMemory programCode;
    IntCodeLogic intCodeLogic = new IntCodeLogic();

    List<Integer> inputForLogic = new ArrayList<>();
    int inputIterator = 0;
    String outputString = "";

    public List<Integer> getInputForLogic() {
        return inputForLogic;
    }
    public void setInputForLogic(List<Integer> inputForLogic) {
        this.inputForLogic = inputForLogic;
    }

    /**
     * Reload program from filename
     * @param pathName path to file (absolute or content rooth path
     */
    public void loadProgramFromFile(String pathName) {
        programCode = new IntCodeMemory(pathName);
    }

    /**
     * Reload program from an IntegerList
     * @param programMemory List that contains IntMachine program
     */
    public void loadProgramFromList(List<Integer> programMemory) {
        programCode = new IntCodeMemory(programMemory);
    }

    public void ioModule(List<Integer> program, int index, String opCode) {
        switch(opCode.charAt(opCode.length() - 1)) {
            case '3':
                if(inputForLogic.size() < (inputIterator + 1)) {
                    System.out.println("input is lower then amount of inputs required");
                    break;
                }
                program.set(program.get(index + 1), inputForLogic.get(inputIterator));
                inputIterator++;
                break;
            case '4':
                if(outputString.equals("")) {
                    outputString += program.get(program.get(index + 1));
                }
                else {
                    outputString += "|" + program.get(program.get(index + 1));
                }
                break;
            default:
                System.out.println("Wrong io code");
        }
    }


    public void operationLogic() {
        boolean ValidOpcode = true;
        outputString = "";

        for (int i = 0; i < programCode.program.size() ; i++) {
            if(ValidOpcode) {
                String operationCode = programCode.program.get(i).toString();
                switch (programCode.program.get(i)%100) {
                    case 1:
                    case 2:
                        intCodeLogic.mathematicalModule(programCode.program, i, operationCode);
                        i += 3;
                        break;
                    case 3:
                    case 4:
                        ioModule(programCode.program, i, operationCode);
                        i += 1;
                        break;
                    case 5:
                    case 6:
                        int jumpVariable = intCodeLogic.jumpModule(programCode.program, i, operationCode);
                        if(jumpVariable != 0) {
                            i = (jumpVariable - 1);
                        }
                        else {
                            i += 2;
                        }
                        break;
                    case 7:
                    case 8:
                        intCodeLogic.compareModule(programCode.program, i, operationCode);
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

    public void operationLogicOnFileInput(String pathName) {
        loadProgramFromFile(pathName);
        operationLogic();
    }

    public int retrievePositionValueAfterLogic(int position, String pathName) {
        operationLogicOnFileInput(pathName);
        return programCode.getValueAtIndex(position);
    }

    public void operationLogicOnFileInputWithAlteration(String pathName, int noun, int verb) {
        loadProgramFromFile(pathName);
        programCode.manipulateMemoryManual(noun, verb);
        operationLogic();
    }

    public int retrievePositionValueAfterLogicWithAlteration(int position, String pathName, int noun, int verb) {
        operationLogicOnFileInputWithAlteration(pathName, noun, verb);
        return programCode.getValueAtIndex(position);
    }

    public String executeDay5Logic(String pathName, List<Integer> Input) {
        inputForLogic = Input;
        inputIterator = 0;
        operationLogicOnFileInput(pathName);
        return outputString;
    }
}
