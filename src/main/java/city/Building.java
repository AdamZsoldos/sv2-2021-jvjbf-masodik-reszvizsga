package city;

public abstract class Building {

    private final int area;
    private final int levels;
    private final Address address;

    protected Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    protected Building(int area, Address address) {
        this.area = area;
        this.levels = 1;
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }

    public int getFullArea() {
        return area * levels;
    }

    public abstract int calculateNumberOfPeopleCanFit();
}
