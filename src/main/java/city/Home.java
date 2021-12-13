package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        validateLevels(levels);
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    protected void validateLevels(int levels) {
        if (levels > 3) {
            throw new IllegalArgumentException("Levels cannot exceed maximum value of 3.");
        }
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return getFullArea() / SQUARE_METERS_NEED_PER_PERSON;
    }
}
