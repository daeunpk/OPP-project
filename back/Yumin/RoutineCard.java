// RoutineCard.java

import java.util.List;

public class RoutineCard {
    private String name;
    private String description;
    private List<RoutineStep> steps;

    public RoutineCard() {
        // Jackson 기본 생성자
    }

    public RoutineCard(String name, String description, List<RoutineStep> steps) {
        this.name = name;
        this.description = description;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RoutineStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RoutineStep> steps) {
        this.steps = steps;
    }
}
