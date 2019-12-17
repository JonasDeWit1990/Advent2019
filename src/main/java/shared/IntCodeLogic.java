package shared;

import java.util.List;

public class IntCodeLogic {
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

    private void additionModule(List<Integer> program, int param1, int param2, int param3) {
        program.set(param3, (param1 + param2));
    }

    private void multiplicationModule(List<Integer> program, int param1, int param2, int param3) {
        program.set(param3, (param1 * param2));
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
}
