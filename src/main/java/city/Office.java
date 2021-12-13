package city;

public class Office extends Building {

    private final String company;
    private final int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        validateNumberOfTablesPerLevel(numberOfTablesPerLevel);
    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        validateNumberOfTablesPerLevel(numberOfTablesPerLevel);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - 1) * numberOfTablesPerLevel;
    }

    private void validateNumberOfTablesPerLevel(int numberOfTablesPerLevel) {
        int minTables = (int) Math.ceil(getArea() / 5.0);
        int maxTables = (int) Math.floor(getArea() / 2.0);
        if (numberOfTablesPerLevel < minTables) {
            throw new IllegalArgumentException(String.format("Tables per level cannot be below minimum value of %d.", minTables));
        } else if (numberOfTablesPerLevel > maxTables) {
            throw new IllegalArgumentException(String.format("Tables per level cannot exceed maximum value of %d.", maxTables));
        }
    }
}
