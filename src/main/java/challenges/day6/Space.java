package challenges.day6;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Space {
    List<Orbit> orbits = new ArrayList<>();

    public Orbit findOrbit(String parentName) {
        for(Orbit orbit: orbits) {
            if(orbit.child.equals(parentName))
                return orbit;
        }
        return null;
    }

    public void addOrbitFromString(String Pattern) {
        int bracketIndex = Pattern.indexOf(')');
        orbits.add(new Orbit(Pattern.substring(0,bracketIndex), Pattern.substring(bracketIndex + 1)));
    }

    public void readOrbitsFromFile (String pathName) {
        try {
            Stream<String> input = Files.lines(Paths.get(pathName));

            input.forEach(this::addOrbitFromString);
        }
        catch (Exception e) {
            System.out.println("Error reading out orbitList");
        }
    }

    public int returnDistance(Orbit orbit) {
        if(orbit.parent.equals("COM"))
            return 1;
        else {
            return 1 + returnDistance(findOrbit(orbit.parent));
        }
    }

    public String returnPlanetList(Orbit orbit) {
        if(orbit.parent.equals("COM"))
            return ",COM";
        else {
            return "," + orbit.parent + returnPlanetList(findOrbit(orbit.parent));
        }
    }

    public int calculateGalacticDistance() {
        int combine = 0;
        for(Orbit orbit: orbits) {
            combine += returnDistance(orbit);
        }
        return combine;
    }

    public int calculateMoveDistance() {
        Orbit startOrbit = findOrbit("YOU");
        Orbit finishOrbit = findOrbit("SAN");
        List<String> youToCenter = new ArrayList<>(Arrays.asList(returnPlanetList(startOrbit).split(",")));
        List<String> sanToCenter = new ArrayList<>(Arrays.asList(returnPlanetList(finishOrbit).split(",")));
        youToCenter.remove("");
        sanToCenter.remove("");

        for(String planet: youToCenter) {
            int index = sanToCenter.indexOf(planet);
            if(index != -1) {
                return index + youToCenter.indexOf(planet);
            }
        }

        return 0;
    }
}
