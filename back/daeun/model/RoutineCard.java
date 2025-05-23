package model;
import java.util.List;

public class RoutineCard {
    public String title;
    public List<String> steps;

    public RoutineCard(String title, List<String> steps) {
        this.title = title;
        this.steps = steps;
    }
}
