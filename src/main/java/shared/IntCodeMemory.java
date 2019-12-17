package shared;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class IntCodeMemory {
    List<Integer> program;

    IntCodeMemory(String pathNameToFile) {
        try {
            String Content = new String(Files.readAllBytes(Paths.get(pathNameToFile)));
            String[] InputStringArray = Content.split(",");

            program =  Arrays.stream(InputStringArray)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }
        catch(Exception e) {
            System.out.println("Error reading file");
        }
    }

    IntCodeMemory(List<Integer> programList) {
        program = programList;
    }


    /**
     * Day 2 Manual manipulation of the program
     * @param noun noun to be altered
     * @param verb verb to be altered
     */
    public void manipulateMemoryManual(int noun, int verb) {
        //action 1
        program.set(1, noun);
        //action 2
        program.set(2,verb);
    }

    public int getValueAtIndex(int index) {
        return program.get(index);
    }
}
