package city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {

    private final String name;
    private final long fullArea;
    private final List<Building> buildings;

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
        buildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        validateBuilding(building);
        buildings.add(building);
    }

    /*public Building findHighestBuilding() {
        Building tallest = null;
        for (Building building : buildings) {
            if (tallest == null || building.getLevels() > tallest.getLevels()) {
                tallest = building;
            }
        }
        return tallest;
    }*/

    public Building findHighestBuilding() {
        return buildings.stream()
                .max(Comparator.comparing(Building::getLevels))
                .orElseThrow();
    }

    public List<Building> findBuildingsByStreet(String streetName) {
        List<Building> result = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().getStreet().equals(streetName)) {
                result.add(building);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeopleCanFit) {
        for (Building building : buildings) {
            if (building.calculateNumberOfPeopleCanFit() > numberOfPeopleCanFit) {
                return true;
            }
        }
        return false;
    }

    private void validateBuilding(Building building) {
        if (getTotalBuildingArea() + building.getArea() > fullArea) {
            throw new IllegalArgumentException(String.format("City can't be larger than %d", fullArea));
        }
    }

    private int getTotalBuildingArea() {
        int totalBuildingArea = 0;
        for (Building building : buildings) {
            totalBuildingArea += building.getArea();
        }
        return totalBuildingArea;
    }
}
