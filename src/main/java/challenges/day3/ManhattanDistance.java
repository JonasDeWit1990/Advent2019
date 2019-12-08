package challenges.day3;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class ManhattanDistance {

    public List<List<String>> readInputFromFile(String pathName) throws IOException {
        List<String> inputFile = Files.readAllLines(Paths.get(pathName));
        List<List<String>> commaSeparatedFile = new ArrayList<>(2);
        for (String inputString: inputFile) {
            commaSeparatedFile.add(Arrays.asList(inputString.split(",")));
        }

        return commaSeparatedFile;
    }

    public List<Set<Point>> createSetForWires(List<List<String>> inputStrings) {
        List<Set<Point>> UniquePointsPerWire = new ArrayList<>();

        // Loop over each wire
        for(List<String> inputString: inputStrings) {
            Set<Point> WireSet = new HashSet<>();
            Point LocationOnWire = new Point(0,0);
            // Loop over each value in the wire
            for(String inputValue: inputString) {
                switch(inputValue.charAt(0)) {
                    case 'R':
                        for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                            LocationOnWire.move(LocationOnWire.x + 1, LocationOnWire.y);
                            WireSet.add(new Point(LocationOnWire));
                        }
                        break;
                    case 'L':
                        for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                            LocationOnWire.move(LocationOnWire.x - 1, LocationOnWire.y);
                            WireSet.add(new Point(LocationOnWire));
                        }
                        break;
                    case 'U':
                        for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                            LocationOnWire.move(LocationOnWire.x , LocationOnWire.y + 1);
                            WireSet.add(new Point(LocationOnWire));
                        }
                        break;
                    case 'D':
                        for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                            LocationOnWire.move(LocationOnWire.x , LocationOnWire.y - 1);
                            WireSet.add(new Point(LocationOnWire));
                        }
                        break;
                    default:
                        System.out.println("Wrong wire command");
                }
            }

            UniquePointsPerWire.add(WireSet);
        }

        return UniquePointsPerWire;
    }

    public int calculateClosestIntersection(List<Set<Point>> inputSets) {
        Set<Point> retainedList = inputSets.get(0);
        retainedList.retainAll(inputSets.get(1));
        return retainedList
                .stream()
                .mapToInt(point -> Math.abs(point.x) + Math.abs(point.y))
                .min()
                .getAsInt();
    }

    public Set<Point> getAllIntersections(List<Set<Point>> inputSets) {
        Set<Point> retainedList = inputSets.get(0);
        retainedList.retainAll(inputSets.get(1));
        return retainedList;
    }

    public int calculateWireDistance(List<String> wire, Point intersectionPoint) {
        int distance = 0;
        Point locationOnWire = new Point(0,0);

        for(String inputValue: wire) {
            switch(inputValue.charAt(0)) {
                case 'R':
                    for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                        locationOnWire.move(locationOnWire.x + 1, locationOnWire.y);
                        distance++;
                        if(intersectionPoint.equals(locationOnWire)) {
                            break;
                        }
                    }
                    break;
                case 'L':
                    for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                        locationOnWire.move(locationOnWire.x - 1, locationOnWire.y);
                        distance++;
                        if(intersectionPoint.equals(locationOnWire)) {
                            break;
                        }
                    }
                    break;
                case 'U':
                    for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                        locationOnWire.move(locationOnWire.x , locationOnWire.y + 1);
                        distance++;
                        if(intersectionPoint.equals(locationOnWire)) {
                            break;
                        }
                    }
                    break;
                case 'D':
                    for(int count = 0 ;count < Integer.parseInt(inputValue.substring(1)); count++) {
                        locationOnWire.move(locationOnWire.x , locationOnWire.y - 1);
                        distance++;
                        if(intersectionPoint.equals(locationOnWire)) {
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Wrong wire command");
            }

            if(intersectionPoint.equals(locationOnWire)) {
                break;
            }
        }

        return distance;
    }

    public int calculateShortestIntersection(String pathName) throws IOException {
        List<List<String>> wires = readInputFromFile(pathName);
        Set<Point> listToCalculate = getAllIntersections(createSetForWires(wires));

        return listToCalculate.stream()
                .mapToInt(p -> calculateWireDistance(wires.get(0), p) + calculateWireDistance(wires.get(1), p))
                .min()
                .getAsInt();
    }

    public int calculateClosestIntersection(String pathName) throws IOException {
        return calculateClosestIntersection(createSetForWires(readInputFromFile(pathName)));
    }
}
