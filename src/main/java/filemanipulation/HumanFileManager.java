package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private final List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                addHumanFromFileLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            List<String> lines = getMaleHumanFileLines();
            Files.write(path, lines);
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file!", e);
        }
    }

    private void addHumanFromFileLine(String line) {
        String[] parts = line.split(";");
        humans.add(new Human(parts[0], parts[1]));
    }

    private List<String> getMaleHumanFileLines() {
        List<String> lines = new ArrayList<>();
        for (Human human : humans) {
            if (isHumanMale(human)) {
                lines.add(human.getName() + ";" + human.getIdentityNumber());
            }
        }
        return lines;
    }

    private boolean isHumanMale(Human human) {
        char firstChar = human.getIdentityNumber().charAt(0);
        return switch (firstChar) {
            case '1', '3' -> true;
            default -> false;
        };
    }
}
