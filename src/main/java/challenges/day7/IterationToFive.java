package challenges.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterationToFive {
    List<Integer> iteration = new ArrayList<>(Arrays.asList(0,1,2,3,4));

    public List<Integer> getIteration() {
        return iteration;
    }

    public boolean checkUnique(String number) {
        List<Integer> uniqueCount = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
        for(int i = 0; i < 5; i++) {
            int index = Integer.parseInt(Character.toString(number.charAt(i)));
            uniqueCount.set(index, uniqueCount.get(index) + 1);
        }

        boolean unique =  uniqueCount.get(0) == 1 && uniqueCount.get(1) == 1 && uniqueCount.get(2) == 1 &&
                uniqueCount.get(3) == 1 && uniqueCount.get(4) == 1;
        boolean higherThenFive = uniqueCount.get(5) > 0 && uniqueCount.get(6) > 0 && uniqueCount.get(7) > 0 &&
                uniqueCount.get(8) > 0 && uniqueCount.get(9) > 0;

        return unique && !higherThenFive;
    }

    public List<Integer> increaseIteration() {
        int lowNumber = iteration.get(0) * 10000 + iteration.get(1) * 1000 + iteration.get(2) * 100 + iteration.get(3) * 10
                + (iteration.get(4) + 1);
        for(int a = lowNumber; a < 54321; a++) {
            String number = Integer.toString(a);
            if(number.length() == 4)
                number = "0" + number;
                if (checkUnique(number)) {
                    iteration = new ArrayList<>(Arrays.asList(Integer.parseInt(Character.toString(number.charAt(0))),
                            Integer.parseInt(Character.toString(number.charAt(1))),Integer.parseInt(Character.toString(number.charAt(2))),
                            Integer.parseInt(Character.toString(number.charAt(3))), Integer.parseInt(Character.toString(number.charAt(4)))));
                    return iteration;
                }

        }
        return new ArrayList<Integer>(Arrays.asList(-1,-1));
    }
}
