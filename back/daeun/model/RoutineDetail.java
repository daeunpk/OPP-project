package model;
import java.util.List;

public class RoutineDetail {
    public String category;
    public List<String> options;

    public RoutineDetail(String category, List<String> options) {
        this.category = category;
        this.options = options;
    }
}
