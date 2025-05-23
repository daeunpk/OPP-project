// RoutineStep.java

public class RoutineStep {
    private String time;
    private String title;
    private String description;

    public RoutineStep() {
        // Jackson이 JSON -> 객체 변환할 때 기본 생성자 필요해!
    }

    public RoutineStep(String time, String title, String description) {
        this.time = time;
        this.title = title;
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
