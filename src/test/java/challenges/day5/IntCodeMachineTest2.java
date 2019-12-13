package challenges.day5;

import challenges.day2.IntCodeMachine;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntCodeMachineTest2 {
    IntCodeMachine intCodeMachine = new IntCodeMachine();

   @Test
    void testInputAndOutput() throws IOException{
       intCodeMachine.setInputForLogic(20);
       assertEquals(20, intCodeMachine.retrievePositionValueAfterLogic(0,"src/test/resources/day5/inputOutput.txt"));
   }

   @Test
   void testCompareModule() throws IOException{
       intCodeMachine.executeDay5Logic("src/test/resources/day5/comparePositionMode.txt", 8);
       intCodeMachine.executeDay5Logic("src/test/resources/day5/comparePositionMode.txt", 7);
       intCodeMachine.executeDay5Logic("src/test/resources/day5/comparePositionMode.txt", 9);

       intCodeMachine.executeDay5Logic("src/test/resources/day5/compareImmediateMode.txt", 8);
       intCodeMachine.executeDay5Logic("src/test/resources/day5/compareImmediateMode.txt", 7);
       intCodeMachine.executeDay5Logic("src/test/resources/day5/compareImmediateMode.txt", 9);

   }

   @Test
   void testJumpModule() throws IOException {
       intCodeMachine.executeDay5Logic("src/test/resources/day5/jumpTest", 8);
       intCodeMachine.executeDay5Logic("src/test/resources/day5/jumpTest", 0);
   }

   @Test
    void test5b() throws IOException {
       intCodeMachine.executeDay5Logic("src/test/resources/day5/5b.txt", 7);
       intCodeMachine.executeDay5Logic("src/test/resources/day5/5b.txt", 8);
       intCodeMachine.executeDay5Logic("src/test/resources/day5/5b.txt", 9);
   }
}