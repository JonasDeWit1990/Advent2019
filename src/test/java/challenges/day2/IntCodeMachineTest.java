package challenges.day2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntCodeMachineTest {
    IntCodeMachine intCodeMachine = new IntCodeMachine();

    @Test
    void testInputConversion() throws IOException {
        var intCodeToCheck = intCodeMachine.convertStringInputToIntArray("src/test/resources/day2/intCodes.txt");
        var assertCode = new ArrayList<>(Arrays.asList(1,0,0,3));
        assertEquals(assertCode, intCodeToCheck);
    }

    @Test
    void testLogic() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,0,0,0,99));
        intCodeMachine.operationLogic(input);
        assertEquals(2,input.get(0));

        input = new ArrayList<>(Arrays.asList(2,0,0,0,99));
        intCodeMachine.operationLogic(input);
        assertEquals(4,input.get(0));
    }

    @Test
    void testLogicFromFile() throws IOException {
        List<Integer> output = intCodeMachine.operationLogicOnFileInputWithAlteration("src/test/resources/day2/intCodes12.txt", 12, 2);
        assertEquals(2,output.get(3));
    }

    @Test
    void RetrieveCorrectValueAfterLogic() throws IOException {
        assertEquals(2, intCodeMachine.retrievePositionValueAfterLogicWithAlteration(3,"src/test/resources/day2/intCodes12.txt", 12,2));
    }
}