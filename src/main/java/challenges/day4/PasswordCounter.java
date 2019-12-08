package challenges.day4;

import java.util.ArrayList;
import java.util.List;

public class PasswordCounter {

    public boolean checkAdjacency (int number) {
        String convertNumber = Integer.toString(number);

        return (convertNumber.charAt(0) == convertNumber.charAt(1) ||
                convertNumber.charAt(1) == convertNumber.charAt(2) ||
                convertNumber.charAt(2) == convertNumber.charAt(3) ||
                convertNumber.charAt(3) == convertNumber.charAt(4) ||
                convertNumber.charAt(4) == convertNumber.charAt(5));
    }

    public boolean checkUniqueAdjacency (int number) {
        String convertNumber = Integer.toString(number);
        boolean[] adjacent = new boolean[5];
        for(int i = 0; i < 5 ;i++) {
            adjacent[i] = convertNumber.charAt(i) == convertNumber.charAt(i+1);
        }

        return (adjacent[0] && !adjacent[1]) || (!adjacent[0] && adjacent[1] && !adjacent[2]) ||
                (!adjacent[1] && adjacent[2] && !adjacent[3]) ||
                (!adjacent[2] && adjacent[3] && !adjacent[4]) ||
                (!adjacent[3] && adjacent[4]);
    }

    public boolean checkAscendance (int number) {
        int interNumber1 = (number - (number % 100000)) / 100000;
        int interNumber2 = (number - (number % 10000)) / 10000 - interNumber1 * 10;
        int interNumber3 = (number - (number % 1000)) / 1000- interNumber1 * 100 - interNumber2 * 10;
        int interNumber4 = (number - (number % 100)) / 100- interNumber1 * 1000 - interNumber2 * 100 - interNumber3 * 10;
        int interNumber5 = (number - (number % 10)) / 10 - interNumber1 * 10000 - interNumber2 * 1000 - interNumber3 * 100
                - interNumber4 * 10;
        int interNumber6 = number - interNumber1 * 100000 - interNumber2 * 10000 - interNumber3 * 1000
                - interNumber4 * 100 - interNumber5 * 10;

        return interNumber1 <= interNumber2 &&
                interNumber2 <= interNumber3 &&
                interNumber3 <= interNumber4 &&
                interNumber4 <= interNumber5 &&
                interNumber5 <= interNumber6;
    }

    public int returnNumberOfValidPasswords(int lowerLimit, int upperLimit) {
        int count = 0;

        for(int counter = lowerLimit; counter < upperLimit; counter++) {
            if(checkAdjacency(counter) && checkAscendance(counter))
                count++;
        }
        return count;
    }

    public int returnNumberOfValidPasswordsPartTwo(int lowerLimit, int upperLimit) {
        int count = 0;

        for(int counter = lowerLimit; counter < upperLimit; counter++) {
            if(checkAdjacency(counter) && checkAscendance(counter))
                if(checkUniqueAdjacency(counter))
                    count++;
        }
        return count;
    }
}
