package challenges.day5;

import shared.IntCodeMachine;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntCodeMachineTest2 {
    IntCodeMachine intCodeMachine = new IntCodeMachine();

   @Test
    void testInputAndOutput() throws IOException{
       intCodeMachine.setInputForLogic(Arrays.asList(20));
       assertEquals(20, intCodeMachine.retrievePositionValueAfterLogic(0,"src/test/resources/day5/inputOutput.txt"));
   }

   @Test
   void testCompareModule() throws IOException{
       assertEquals("0",intCodeMachine.executeDay5Logic("src/test/resources/day5/comparePositionMode.txt", Arrays.asList(8)));
       assertEquals("1",intCodeMachine.executeDay5Logic("src/test/resources/day5/comparePositionMode.txt", Arrays.asList(7)));
       assertEquals("1",intCodeMachine.executeDay5Logic("src/test/resources/day5/comparePositionMode.txt", Arrays.asList(9)));

       assertEquals("0",intCodeMachine.executeDay5Logic("src/test/resources/day5/compareImmediateMode.txt", Arrays.asList(8)));
       assertEquals("0",intCodeMachine.executeDay5Logic("src/test/resources/day5/compareImmediateMode.txt", Arrays.asList(7)));
       assertEquals("1",intCodeMachine.executeDay5Logic("src/test/resources/day5/compareImmediateMode.txt", Arrays.asList(9)));

   }

   @Test
   void testJumpModule() throws IOException {
       intCodeMachine.executeDay5Logic("src/test/resources/day5/jumpTest", Arrays.asList(8));
       intCodeMachine.executeDay5Logic("src/test/resources/day5/jumpTest", Arrays.asList(0));
   }

   @Test
    void test5b() throws IOException {
       intCodeMachine.executeDay5Logic("src/test/resources/day5/5b.txt", Arrays.asList(7));
       intCodeMachine.executeDay5Logic("src/test/resources/day5/5b.txt", Arrays.asList(8));
       intCodeMachine.executeDay5Logic("src/test/resources/day5/5b.txt", Arrays.asList(9));
   }
}